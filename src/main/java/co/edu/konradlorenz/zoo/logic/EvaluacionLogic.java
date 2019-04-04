/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.EvaluacionEntity;
import co.edu.konradlorenz.zoo.persistence.EvaluacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic evaluacion
 * @author carlosmejia
 */

@Stateless
public class EvaluacionLogic {
    @Inject
    private EvaluacionPersistence persistence;
    
    /**
     * Metodo para obtener lista de evaluacion
     * @return ListEvaluacion
     */
    public List<EvaluacionEntity> obtenerEvaluacion(){
        List<EvaluacionEntity> evalaucion = persistence.findall();
        return evalaucion;
    }
    
    /**
     * Metodo para obtener una evaluaicon
     * @param id
     * @return evaluacion encontrada
     */
    public EvaluacionEntity obtenerEvaluacionPorId(Long id){
        EvaluacionEntity evaluacion = persistence.find(id);
        
        if(evaluacion == null){
            throw new IllegalArgumentException("La evaluación seleccionada no existe.");
        }
        
        return evaluacion;        
    }
    
    /**
     * Metodo para crear una evaluacion
     * @param entity
     * @return Evaluacion creada
     */
    public EvaluacionEntity crearEvaluacion(EvaluacionEntity entity){
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar una evaluacion
     * @param entity
     * @param id
     * @return Evaluacion actualizada
     */
    public EvaluacionEntity actualizarEvaluacion(EvaluacionEntity entity, Long id){
        EvaluacionEntity evaluacion = persistence.update(entity);
        return evaluacion;
    }
    
    /**
     * Metodo para eliminar una evaluacion
     * @param id 
     */
    public void eliminarEvaluacion(Long id){
        persistence.delete(id);
    }
}
