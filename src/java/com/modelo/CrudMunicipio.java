package com.modelo;
import com.conexion.Conexion;
import java.sql.*;
import java.util.*;

/**
 * Nombre de la clase: CrudMunicipio
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class CrudMunicipio extends Conexion{
    public void insertarMunicipio(Municipio mun) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="insert into municipio values (?,?,?)";
            PreparedStatement pre = conexion.prepareStatement(sql);
            
            pre.setInt(1, mun.getIdMunicipio());
            pre.setString(2, mun.getNombreMuni());
            pre.setInt(3, mun.getDepartamento().getIdDepartamento());            
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        }        
    }
    
    public void modificarMunicipio(Municipio mun) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="update municipio set muniNombre=?, idDepartamento=? where idMunicipio=?";
            PreparedStatement pre = conexion.prepareStatement(sql);            
            
            pre.setString(1, mun.getNombreMuni());
            pre.setInt(2, mun.getDepartamento().getIdDepartamento());
            pre.setInt(3, mun.getIdMunicipio());
            
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        }        
    }
    
    public void eliminarMunicipio(Municipio mun) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="delete from municipio where idMunicipio=? ";
            PreparedStatement pre = conexion.prepareStatement(sql);
            
            pre.setInt(1, mun.getIdMunicipio());
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        }        
    }
    
    public List<Departamento>listarDepartamento() throws Exception
    {
        ResultSet rs;
        List<Departamento>ls=new ArrayList();
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="select * from departamento";
            PreparedStatement pre= conexion.prepareCall(sql);
            rs=pre.executeQuery();
            
            while(rs.next())
            {
                Departamento dep = new Departamento();
                dep.setIdDepartamento(rs.getInt("idDepartamento"));
                dep.setNombreDep(rs.getString("depaNombre"));
                ls.add(dep);
            }
            
        } 
        catch (Exception e) 
        {
            throw e;
        }
        return ls;
    }
    
    public List<Municipio>mostrarMunicipio() throws Exception
    {
        ResultSet rs;
        List<Municipio>ls=new ArrayList();
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="select municipio.idMunicipio, municipio.muniNombre, municipio.idDepartamento, Departamento.idDepartamento, departamento.depaNombre " +
                        "from municipio inner join departamento " +
                        "on municipio.idDepartamento = departamento.idDepartamento order by idMunicipio";
            PreparedStatement pre = conexion.prepareCall(sql);
            rs=pre.executeQuery();
            while(rs.next())
            {       
                
                Departamento dep = new Departamento();
                dep.setIdDepartamento(rs.getInt("idDepartamento"));
                dep.setNombreDep(rs.getString("depaNombre"));
                
                Municipio mun = new Municipio();
                mun.setIdMunicipio(rs.getInt("idMunicipio"));
                mun.setNombreMuni(rs.getString("muniNombre"));
                mun.setDepartamento(dep);
                                
                ls.add(mun); 
            }   
        } 
        catch (Exception e) 
        {
            throw e;
        }        
        return ls;
    }
}