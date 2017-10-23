package com.modelo;
import com.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * Nombre de la clase: CrudPersona
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class CrudPersona extends Conexion{
    
    public void insertarPersona(Persona per) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="insert into persona values (?,?,?,?,?,?,?)";
            PreparedStatement pre = conexion.prepareStatement(sql);
            
            pre.setInt(1, per.getIdPersona());
            pre.setString(2, per.getNombre());
            pre.setString(3, per.getApellidos());
            pre.setString(4, per.getDui());
            pre.setInt(5, per.getEdad());
            pre.setString(6, per.getGenero());
            pre.setInt(7, per.getMunicipio().getIdMunicipio());            
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        }        
    }
    
    public void modificarPersona(Persona per) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="update persona set perNombre=?, apellidos=?, dui=?, edad=?, genero=?, idMunicipio=? "
                    + "where idPersona=?";
            PreparedStatement pre = conexion.prepareStatement(sql);            
            
            pre.setString(1, per.getNombre());
            pre.setString(2, per.getApellidos());
            pre.setString(3, per.getDui());
            pre.setInt(4, per.getEdad());
            pre.setString(5, per.getGenero());
            pre.setInt(6, per.getMunicipio().getIdMunicipio());
            pre.setInt(7, per.getIdPersona());
            
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        }        
    }
    
    public void eliminarPersona(Persona per) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="delete from persona where idPersona=? ";
            PreparedStatement pre = conexion.prepareStatement(sql);
            
            pre.setInt(1, per.getIdPersona());
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        }        
    }
    
    public List<Persona>mostrarPersona() throws Exception
    {
        ResultSet rs;
        List<Persona>ls=new ArrayList();
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="select persona.idPersona, persona.perNombre, persona.apellidos, persona.dui, persona.edad, persona.genero, municipio.idMunicipio, municipio.muninombre " +
                        "from persona inner join municipio " +
                        "on persona.idMunicipio = municipio.idMunicipio order by idPersona";
            PreparedStatement pre = conexion.prepareCall(sql);
            rs=pre.executeQuery();
            while(rs.next())
            {
                
                
                Municipio muni = new Municipio();
                muni.setIdMunicipio(rs.getInt("idMunicipio"));
                muni.setNombreMuni(rs.getString("muniNombre"));
                
                
                Persona per = new Persona();
                per.setIdPersona(rs.getInt("idPersona"));
                per.setNombre(rs.getString("perNombre"));
                per.setApellidos(rs.getString("apellidos"));
                per.setDui(rs.getString("dui"));
                per.setEdad(rs.getInt("edad"));
                per.setGenero(rs.getString("genero"));
                per.setMunicipio(muni);
                                
                ls.add(per);
                
            }
            
        } 
        catch (Exception e) 
        {
            throw e;
        }        
        return ls;
    }
    
    public List<Municipio>listaMunicipio() throws Exception
    {
        ResultSet rs;
        List<Municipio>ls=new ArrayList();
        Conexion db = new Conexion();
        Connection conexion = null;
        try 
        {
            conexion = db.getConnection();
            String sql="select * from municipio";
            PreparedStatement pre= conexion.prepareCall(sql);
            rs=pre.executeQuery();
            
            while(rs.next())
            {
                Municipio muni = new Municipio();
                muni.setIdMunicipio(rs.getInt("idMunicipio"));
                muni.setNombreMuni(rs.getString("muniNombre"));
                ls.add(muni);
            }
            
        } 
        catch (Exception e) 
        {
            throw e;
        }
        
        return ls;
    }
    
}
