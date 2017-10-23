package com.modelo;

/**
 *
 * Nombre de la clase: Contrasenia
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class Contrasenia {
    

    private int idContrasenia;
    private String contrasenia;
    private int estado;

    public Contrasenia() {
    }

    public Contrasenia(int idContrasenia, String contrasenia, int estado) {
        this.idContrasenia = idContrasenia;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public int getIdContrasenia() {
        return idContrasenia;
    }

    public void setIdContrasenia(int idContrasenia) {
        this.idContrasenia = idContrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}