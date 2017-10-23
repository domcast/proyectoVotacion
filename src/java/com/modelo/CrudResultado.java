package com.modelo;

/**
 *
 * Nombre de la clase: CrudResultado
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */

import java.sql.*;
import java.util.*;
import com.modelo.Resultado;
import com.conexion.Conexion;
import com.modelo.Persona;
public class CrudResultado extends Conexion{
    
    public List<Resultado> mostrarResultado() throws Exception
    {
        List<Resultado> listaRe=new ArrayList();
        ResultSet res;
        Conexion db=new Conexion();
        Connection conexion = null;
        try 
        {
            conexion=db.getConnection();
            String sql="select idResultado, candidato.idCandidato, totalVotos, resultado from resultado inner join candidato on resultado.idCandidato=candidato.idcandidato order by idresultado;";
            PreparedStatement pre=conexion.prepareCall(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Candidato can=new Candidato();
                can.setIdCandidato(res.getInt("idcandidato"));
                
                
                Resultado re=new Resultado();
                re.setIdResultado(res.getInt("idresultado"));
                re.setIdCandidato(can);
                re.setTotalVotos(res.getDouble("totalVotos"));
                re.setResultado(res.getString("resultado"));
                
                listaRe.add(re);
            }
        }
        catch (Exception e) 
        {
            throw e;
        }
        return listaRe;
    }
    
    public List<Candidato> mostrarpersona() throws Exception
    {
        List<Candidato> listaRe=new ArrayList();
        ResultSet res;
        Conexion db=new Conexion();
        Connection conexion = null;
        try 
        {
            conexion=db.getConnection();
            String sql="select idcandidato, perNombre from candidato inner join persona on candidato.idPersona=persona.idPersona";
            PreparedStatement pre=conexion.prepareCall(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Persona per=new Persona();
                per.setNombre(res.getString("perNombre"));
                
                Candidato can=new Candidato();
                can.setIdCandidato(res.getInt("idCandidato"));
                can.setPersona(per);
                
                listaRe.add(can);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return listaRe;
    }
    
    public void insertar(Resultado re) throws Exception
    {
        Conexion db=new Conexion();
        Connection conexion = null;
        try 
        {
            conexion=db.getConnection();
            String sql="insert into resultado values (?, ?, ?, ?)";
            PreparedStatement pre=conexion.prepareStatement(sql);
            pre.setInt(1, re.getIdResultado());
            pre.setInt(2, re.getIdCandidato().getIdCandidato());
            pre.setDouble(3, re.getTotalVotos());
            pre.setString(4, re.getResultado());
            pre.executeUpdate();
        }
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void modificar(Resultado re) throws Exception
    {
        Conexion db=new Conexion();
        Connection conexion = null;
        try 
        {
            conexion=db.getConnection();
            String sql="update resultado set idCandidato=?, totalVotos=?, resultado=? where idResultado=?";
            PreparedStatement pre=conexion.prepareStatement(sql);
            pre.setInt(1, re.getIdCandidato().getIdCandidato());
            pre.setDouble(2, re.getTotalVotos());
            pre.setString(3, re.getResultado());
            pre.setInt(4, re.getIdResultado());
            pre.executeUpdate();
        }
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void eliminar(Resultado re) throws Exception
    {
        Conexion db=new Conexion();
        Connection conexion = null;
        try
        {
            conexion=db.getConnection();
            String sql="delete from resultado where idResultado=?";
            PreparedStatement pre=conexion.prepareStatement(sql);
            pre.setInt(1, re.getIdResultado());
            pre.executeUpdate();
        }
        catch (Exception e) 
        {
            throw e;
        }
    }
}
