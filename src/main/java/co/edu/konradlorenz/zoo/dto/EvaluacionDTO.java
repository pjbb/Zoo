/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.EvaluacionEntity;
import java.util.ArrayList;
import java.util.List;

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

    public EvaluacionDTO(EvaluacionEntity evaluacion) {
        this.idEvaluacion = evaluacion.getId();
        this.valor = evaluacion.getValor();
        this.observacion = evaluacion.getObservacion();
    }
    
    /**
     * Conversión DTO - Entity
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
      * Método para conversión de lista DTO a lista Entidades
      * @param evaluacionList
      * @return 
      */
    public static List<EvaluacionDTO> toEvaluacionList(List<EvaluacionEntity> evaluacionList){
        List<EvaluacionDTO> listaEvaluaciones = new ArrayList<>();
        for (int i = 0; i < evaluacionList.size(); i++) {
            listaEvaluaciones.add(new EvaluacionDTO(evaluacionList.get(i)));
        }
        return listaEvaluaciones;
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
