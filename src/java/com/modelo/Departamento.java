package com.modelo;

/**
 *
 * Nombre de la clase: Departamento
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class Departamento {
    
    private int idDepartamento;
    private String nombreDep;
    private int cupos;

    public Departamento() {
    }

    public Departamento(int idDepartamento, String nombreDep, int cupos) {
        this.idDepartamento = idDepartamento;
        this.nombreDep = nombreDep;
        this.cupos = cupos;
    }

    public Departamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }
 
}