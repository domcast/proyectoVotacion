package com.modelo;

/**
 *
 * Nombre de la clase: CrudContrasenia
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
import com.modelo.Contrasenia;
import com.conexion.Conexion;
import java.util.*;
import java.sql.*;
public class CrudContrasenia extends Conexion{
    
    public List<Contrasenia> mostarContrasenia() throws Exception
    {
        List<Contrasenia> lscontra=new ArrayList();
        ResultSet res;
        Conexion db=new Conexion();
        Connection conexion = null;
        try 
        {
            conexion=db.getConnection();
            String sql="select * from contrasenia";
            PreparedStatement pre=conexion.prepareCall(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Contrasenia con=new Contrasenia();
                con.setIdContrasenia(res.getInt("idContrasenia"));
                con.setContrasenia(res.getString("contrasenia"));
                con.setEstado(res.getInt("estado"));
                lscontra.add(con);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return lscontra;
    }
    
    public void insertarcontra(Contrasenia con) throws Exception
    {
        Conexion db=new Conexion();
        Connection conexion = null;
        try 
        {
            conexion=db.getConnection();
            String sql="insert into contrasenia values (?, ?, ?)";
            PreparedStatement pre=conexion.prepareStatement(sql);
            
            pre.setInt(1, con.getIdContrasenia());
            pre.setString(2, con.getContrasenia());
            pre.setInt(3, con.getEstado());
            pre.executeUpdate();
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    
    public void modificarPersona(Contrasenia con) throws Exception
    {
        Conexion db=new Conexion();
        Connection conexion=null;
        try 
        {
            conexion = db.getConnection();
            String sql="update contrasenia set contrasenia=?, estado=? where idContrasenia=?";
            PreparedStatement pre=conexion.prepareStatement(sql);
            pre.setString(1, con.getContrasenia());
            pre.setInt(2, con.getEstado());
            pre.setInt(3, con.getIdContrasenia());
            pre.executeUpdate();
        }
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void eliminar(Contrasenia con) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion=null;
        try
        {
            conexion = db.getConnection();
            String sql="delete from contrasenia where idcontrasenia=?";
            PreparedStatement pre=conexion.prepareStatement(sql);
            
            pre.setInt(1, con.getIdContrasenia());
            
            pre.executeUpdate();
        }catch (Exception e) 
        {
            throw e;
        }
    }
    
}
