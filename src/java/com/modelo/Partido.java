
package com.modelo;

/**
 *
 * Nombre de la clase: Partido
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class Partido {
    private int idPartido;
    private String parNombre;
    private String bandera;

    public Partido() {
    }

    public Partido(int idPartido) {
        this.idPartido = idPartido;
    }

  
    

    public Partido(int idPartido, String parNombre, String bandera) {
        this.idPartido = idPartido;
        this.parNombre = parNombre;
        this.bandera = bandera;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getParNombre() {
        return parNombre;
    }

    public void setParNombre(String parNombre) {
        this.parNombre = parNombre;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    
    
    
    
}