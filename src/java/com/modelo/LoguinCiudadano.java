package com.modelo;

/**
 *
 * Nombre de la clase: LoguinCiudadano
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */

import com.modelo.Ciudadano;
import com.conexion.Conexion;
import java.util.*;
import java.sql.*;
public class LoguinCiudadano extends Conexion{
    
    public int validarciudadano(String dui, String clave) throws Exception
    {
        Conexion db = new Conexion();
        Connection conexion = null;
        int ingreso=0;
        ResultSet res;
        try 
        {
             conexion = db.getConnection();
             String sql="select estado from contrasenia inner join persona on contrasenia=? and dui=?";
             PreparedStatement pre=conexion.prepareCall(sql);
             
             pre.setString(1, dui);
             pre.setString(2, clave);
             res=pre.executeQuery();
             while(res.next())
             {
                 ingreso=res.getInt(clave);
                 
             }
        }
        catch (Exception e) 
        {
            throw e;
        }
        return ingreso;
    }
    
}