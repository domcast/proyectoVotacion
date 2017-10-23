package com.modelo;

/**
 *
 * Nombre de la clase: Persona
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class Persona {
    
    private int idPersona;
    private String nombre;
    private String apellidos;
    private String dui;
    private int edad;
    private String genero;
    private Municipio municipio;
    

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String apellidos, String dui, int edad, String genero, Municipio municipio) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dui = dui;
        this.edad = edad;
        this.genero = genero;
        this.municipio = municipio;
        
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
  
}