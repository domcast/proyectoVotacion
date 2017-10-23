package com.modelo;

import com.conexion.Conexion;
import java.sql.*;
import java.util.*;

/**
 *
 * Nombre de la clase: CrudDepartamento
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class CrudDepartamento extends Conexion{
    public void insertarDepartamento(Departamento dep) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="insert into departamento values (?,?,?)";
            PreparedStatement pre = conexion.prepareStatement(sql);
            
            pre.setInt(1, dep.getIdDepartamento());
            pre.setString(2, dep.getNombreDep());
            pre.setInt(3, dep.getCupos());
           
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        }        
    }
    
    public void modificarDepartamento(Departamento dep) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="update departamento set depanombre=?, cupos=? where iddepartamento=?";
            PreparedStatement pre = conexion.prepareStatement(sql);            
            
            pre.setString(1, dep.getNombreDep());
            pre.setInt(2, dep.getCupos());
            pre.setInt(3, dep.getIdDepartamento());
            
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        }        
    }
    public void eliminarDepartamento(Departamento dep) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="delete from departamento where iddepartamento=? ";
            PreparedStatement pre = conexion.prepareStatement(sql);
            
            pre.setInt(1, dep.getIdDepartamento());
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        }        
    }
    
    public List<Departamento>mostrarDepartamento() throws Exception
    {
        ResultSet rs;
        List<Departamento>ls=new ArrayList();
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="select * from departamento";
            PreparedStatement pre= conexion.prepareStatement(sql);
            rs=pre.executeQuery();
            
            while(rs.next())
            {
                Departamento dep= new Departamento();
                dep.setIdDepartamento(rs.getInt("idDepartamento"));
                dep.setNombreDep(rs.getString("depaNombre"));
                dep.setCupos(rs.getInt("cupos"));
                ls.add(dep);
            }  
        } 
        catch (Exception e) 
        {
            throw e;
        }
        return ls;
    }
}
