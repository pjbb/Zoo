/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.EvaluacionEntity;

/**
 * DTO evaluacion
 * @author carlosmejia
 */
public class EvaluacionDTO {
    /**
     * Atributo id evaluacion
     */
    private Long idEvaluacion;
    
    /**
     * Atributo valor
     */
    private int valor;
    
    /**
     * Atributo observacion
     */
    private String observacion;
    
    /**
     * Constructores
     */
    public EvaluacionDTO(){
        
    }

    public EvaluacionDTO(Long idEvaluacion, int valor, String observacion) {
        this.idEvaluacion = idEvaluacion;
        this.valor = valor;
        this.observacion = observacion;
    }
    
    /**
     * Convertitod DTO - Entity
     * @return EvaluacionEntity
     */
    public EvaluacionEntity toEntity(){
        EvaluacionEntity evaluacionEntity = new EvaluacionEntity();
        evaluacionEntity.setId(this.idEvaluacion);
        evaluacionEntity.setValor(this.valor);
        evaluacionEntity.setObservacion(this.observacion);
        
        return evaluacionEntity;
    }

    /**
     * Getters
     */
    public Long getIdEvaluacion() {
        return idEvaluacion;
    }

    public int getValor() {
        return valor;
    }

    public String getObservacion() {
        return observacion;
    }

    /**
     * Setters
     */
    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
}
