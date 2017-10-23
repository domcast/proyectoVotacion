package com.modelo;

/**
 *
 * Nombre de la clase: Resultado
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
import com.modelo.Candidato;

public class Resultado {
    private int idResultado;
    private Candidato idCandidato;
    private Double totalVotos;
    private String resultado;

    public Resultado(Candidato idCandidato) {
        this.idCandidato = idCandidato;
    }

    public Resultado(int idResultado, Candidato idCandidato, Double totalVotos, String resultado) {
        this.idResultado = idResultado;
        this.idCandidato = idCandidato;
        this.totalVotos = totalVotos;
        this.resultado = resultado;
    }

    public Resultado() {
    }

    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public Candidato getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(Candidato idCandidato) {
        this.idCandidato = idCandidato;
    }

    public Double getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(Double totalVotos) {
        this.totalVotos = totalVotos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    
    
    
}
