package com.modelo;

/**
 *
 * Nombre de la clase: Ciudadano
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class Ciudadano {
    
    private int idciudadano;
    private Persona persona;
    private String pregunta;
    private int estado;

    public Ciudadano() {
    }

    public Ciudadano(int idciudadano, Persona persona, String pregunta, int estado) {
        this.idciudadano = idciudadano;
        this.persona = persona;
        this.pregunta = pregunta;
        this.estado = estado;
    }

    public int getIdciudadano() {
        return idciudadano;
    }

    public void setIdciudadano(int idciudadano) {
        this.idciudadano = idciudadano;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
