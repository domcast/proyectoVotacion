package com.conexion;

/**
 * Nombre de la clase: Conexion
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */

import java.sql.*;
import java.util.*;
import javax.servlet.*;
import jdk.nashorn.internal.ir.TryNode;

    public class Conexion
    {
        public static Connection con;
        public static Connection getConnection()
        {
            try 
            {
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyecto?user=postgres&password=postgres");
                return con;
            } 
            catch (Exception e) 
            {                
                return null;
            }
        }
        
    



    /*public void desconectar() throws Exception
    {
        try 
        {
            if(con!=null)
            {
                if(con.isClosed()==false)
                {
                    con.close();
                }
            }
        }
        catch (Exception e)
        {
          
            throw e;
        }
    }*/
}
