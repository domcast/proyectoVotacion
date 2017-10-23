package com.modelo;

import com.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Nombre de la clase: CrudCandidato
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class CrudCandidato extends Conexion{
    
    public void insertarCandidato(Candidato ca) throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
       
        
       
        try {
            conexion = bd.getConnection();
            
            String sql="insert into candidato (idCandidato, idPersona, idPartido, foto) values (?,?,?,?)";
            PreparedStatement pre = conexion.prepareStatement(sql);
            
            pre.setInt(1, ca.getIdCandidato());
            pre.setInt(2,ca.getPersona().getIdPersona());
            pre.setInt(3,ca.getPartido().getIdPartido());
            pre.setString(4, ca.getFoto());
            pre.executeUpdate();
            
 
        } catch (Exception e) {
            throw  e;
        }
    }
    
    public void eliminarCandidato(Candidato ca) throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
        try {
            conexion=bd.getConnection();
            String sql="delete from candidato where idCandidato=?";
            PreparedStatement pre=conexion.prepareStatement(sql);
            pre.setInt(1, ca.getIdCandidato());
            pre.executeUpdate();
            
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarCandidato(Candidato ca) throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
        try {
            conexion=bd.getConnection();
            String sql="update candidato set idPersona=?, idPartido=?,foto=? where idCandidato=?";
            PreparedStatement pre=conexion.prepareStatement(sql);
            pre.setInt(1,ca.getPersona().getIdPersona());
            pre.setInt(2, ca.getPartido().getIdPartido());
           pre.setString(3,ca.getFoto());
            pre.setInt(4,ca.getIdCandidato());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Candidato>mostrarCandidato() throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
        ResultSet res;
        List<Candidato> lista=new ArrayList();
        try {
            conexion=bd.getConnection();
            String sql="select candidato.idCandidato,persona.perNombre,persona.idPersona,partido.parNombre,partido.idPartido,candidato.foto  " +
                       " from candidato inner join persona " +
                       " on candidato.idPersona = persona.idPersona inner join partido " +
                       " on candidato.idPartido = partido.idPartido ";
            
            PreparedStatement pre=conexion.prepareCall(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Partido par = new Partido();
                par.setIdPartido(res.getInt("idPartido"));
                par.setParNombre(res.getString("parNombre"));
                
                
                Persona per = new Persona();
                per.setIdPersona(res.getInt("idPersona"));
                per.setNombre(res.getString("perNombre"));
                
                Candidato ca = new Candidato();
                ca.setIdCandidato(res.getInt("idCandidato"));
                ca.setPersona(per);
                ca.setPartido(par);
                ca.setFoto(res.getString("foto"));
                
                lista.add(ca);
              
            }
            
           
            
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public List<Partido>MostrarPartido() throws Exception
    {
        Conexion bd= new Conexion();
        Connection conexion=null;
        ResultSet res;
        List<Partido> lista=new ArrayList();
        try {
            conexion=bd.getConnection();
            String sql="select * from partido";
            PreparedStatement pre= conexion.prepareCall(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Partido par= new Partido();
                par.setIdPartido(res.getInt("idPartido"));
                par.setParNombre(res.getString("parNombre"));
                par.setBandera(res.getString("bandera"));
                
                
                lista.add(par);
                
            }
            
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
  public List<Persona>mostrarPersona() throws Exception
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
          throw e;
      }
      return per;
  }
  
}

