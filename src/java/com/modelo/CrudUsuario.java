
package com.modelo;

import com.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Nombre de la clase: CrudUsuario
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class CrudUsuario extends Conexion{
    
    public void insertarUsuario(Usuario us) throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
        try {
            conexion = bd.getConnection();
            String sql="insert into usuario values(?,?,?,?,?)";
            PreparedStatement pre= conexion.prepareStatement(sql);
            pre.setInt(1, us.getIdUsurio());
            pre.setString(2,us.getCuenta());
            pre.setString(3, us.getContrasenia());
            pre.setInt(4, us.getCargo());
            pre.setInt(5,us.getIdPersona().getIdPersona());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarUsuario(Usuario us) throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
        try {
            conexion = bd.getConnection();
            String sql="delete from usuario where idUsuario=?";
            PreparedStatement pre=conexion.prepareStatement(sql);
            pre.setInt(1, us.getIdUsurio());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }
    public void modificarUsuario(Usuario us) throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
        
        
        try {
            conexion = bd.getConnection();
            String sql="update usuario set cuenta=?,contrasenia=?,cargo=?,idPersona=? where idUsuario=?";
        PreparedStatement pre=conexion.prepareStatement(sql);
        pre.setString(1, us.getCuenta());
        pre.setString(2,us.getContrasenia());
        pre.setInt(3,us.getCargo());
        pre.setInt(4,us.getIdPersona().getIdPersona());
        pre.setInt(5,us.getIdUsurio());
        pre.executeUpdate();
        
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Usuario>mostrarUsuario() throws Exception
    {
        List<Usuario> lista= new ArrayList();
        Conexion bd= new Conexion();
        Connection conexion=null;
        ResultSet res;
        try {
            conexion = bd.getConnection();
            String sql="select usuario.idusuario,usuario.cuenta,usuario.contrasenia,usuario.cargo,persona.idPersona,persona.perNombre,persona.apellidos " +
"from usuario inner join persona  " +
"on usuario.idPersona = persona.idPersona  ";
            PreparedStatement pre=conexion.prepareCall(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Persona per = new Persona();
                per.setIdPersona(res.getInt("idPersona"));
                per.setNombre(res.getString("perNombre"));
                per.setApellidos(res.getString("apellidos"));
                
                
                Usuario usu= new Usuario();
                usu.setIdUsurio(res.getInt("idUsuario"));
                usu.setCuenta(res.getString("cuenta"));
                usu.setContrasenia(res.getString("contrasenia"));
                usu.setCargo(res.getInt("cargo"));
                usu.setIdPersona(per);
                lista.add(usu);
                
            }
            
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public List<Persona>mostrarPersona()
  {
      List<Persona> per=new ArrayList();
      ResultSet res;
       Conexion bd= new Conexion();
        Connection conexion=null;
      
      try {
          conexion=bd.getConnection();
          String sql="select * from persona";
          PreparedStatement pre= conexion.prepareCall(sql);
          res=pre.executeQuery();
          while(res.next())
          {
              Persona pr =new Persona();
              pr.setIdPersona(res.getInt("idPersona"));
              pr.setNombre(res.getString("perNombre"));
              pr.setApellidos(res.getString("apellidos"));
              per.add(pr);
          }
          
          
      } catch (Exception e) {
      }
      return per;
  }
    
    
}
