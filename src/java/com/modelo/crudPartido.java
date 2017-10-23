
package com.modelo;

import com.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Nombre de la clase: CrudPartido
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class crudPartido extends Conexion{
    
    public List<Partido>mostrarPartido() throws Exception
    {
        List<Partido> list= new ArrayList();
        ResultSet res;
         Conexion bd= new Conexion();
        Connection conexion=null;
        try {
            conexion = bd.getConnection();
            String sql="select * from partido";
            PreparedStatement pre=conexion.prepareCall(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Partido par=new Partido();
                par.setIdPartido(res.getInt("idPartido"));
                par.setParNombre(res.getString("parNombre"));
                par.setBandera(res.getString("bandera"));
                list.add(par);
                  
            }
        } catch (Exception e) {
            throw e;
        }
     return list;   
    }
    
    public void modificarPartido(Partido par) throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
        
        try {
            conexion = bd.getConnection();
            String sql="update partido set parNombre=?,bandera=? where idPartido=?";
            PreparedStatement pre=conexion.prepareStatement(sql);
            pre.setString(1,par.getParNombre());
            pre.setString(2,par.getBandera());
            pre.setInt(3,par.getIdPartido());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }
    public void insertarPartido(Partido par) throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
        try {
            conexion = bd.getConnection();
        String sql="insert into partido values(?,?,?)";
        PreparedStatement pre=conexion.prepareStatement(sql);
        pre.setInt(1, par.getIdPartido());
        pre.setString(2,par.getParNombre());
        pre.setString(3, par.getBandera());
        pre.executeUpdate();
            conexion = bd.getConnection();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarPartido(Partido par) throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
      
        
        try {
            conexion = bd.getConnection();
        String sql="delete from partido where idPartido=?";
        PreparedStatement pre=conexion.prepareStatement(sql);
        pre.setInt(1, par.getIdPartido());
        pre.executeUpdate();
            conexion = bd.getConnection();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
