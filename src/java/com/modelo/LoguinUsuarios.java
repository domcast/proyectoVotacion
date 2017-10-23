package com.modelo;

/**
 * 
 * Nombre de la clase: LoginUsuarios
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */

import com.conexion.Conexion;
import java.sql.*;
public class LoguinUsuarios extends Conexion{
    
    public int ValidarUsuario(Usuario us) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        int cargo=0;
        ResultSet res;
        try 
        {
            conexion = db.getConnection();
            String sql="select cargo from usuario where cuenta=? and contrasenia=?";
            PreparedStatement pre = conexion.prepareCall(sql);
            
            pre.setString(1, us.getCuenta());
            pre.setString(2, us.getContrasenia());
            res=pre.executeQuery();
            
            while(res.next())
            {
            cargo=res.getInt("cargo");
            }
        }
        catch (Exception e) 
        {
            throw e;
        }     
        return cargo;
    }
}
