package com.modelo;

/**
 *
 * Nombre de la clase: Municipio
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class Municipio {
    
    private int idMunicipio;
    private String nombreMuni;
    private Departamento departamento;

    public Municipio() {
    }

    public Municipio(int idMunicipio, String nombreMuni, Departamento departamento) {
        this.idMunicipio = idMunicipio;
        this.nombreMuni = nombreMuni;
        this.departamento = departamento;
    }

    public Municipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }    

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMuni() {
        return nombreMuni;
    }

    public void setNombreMuni(String nombreMuni) {
        this.nombreMuni = nombreMuni;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
    
}
