package com.modelo;

/**
 *
 * Nombre de la clase: Usuario
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */

import com.modelo.Persona;
public class Usuario {
    private int idUsurio;
    private String cuenta;
    private String contrasenia;
    private int cargo;
    private Persona idPersona;

    public Usuario(int idUsurio, String cuenta, String contrasenia, int cargo, Persona idPersona) {
        this.idUsurio = idUsurio;
        this.cuenta = cuenta;
        this.contrasenia = contrasenia;
        this.cargo = cargo;
        this.idPersona = idPersona;
    }

    public Usuario() {
    }

    public Usuario(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdUsurio() {
        return idUsurio;
    }

    public void setIdUsurio(int idUsurio) {
        this.idUsurio = idUsurio;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }
    
    
}