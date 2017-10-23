/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * Nombre de la clase: Candidato
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class Candidato {
    private int idCandidato;
    private Persona persona;
    private Partido partido;
    private String foto;

    public Candidato() {
    }

    public Candidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }
    

    public Candidato(Persona persona) {
        this.persona = persona;
    }
    
    
    

    public Candidato(int idCandidato, Persona persona, Partido partido, String foto) {
        this.idCandidato = idCandidato;
        this.persona = persona;
        this.partido = partido;
        this.foto = foto;
    }

    
    
    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    
    
}

