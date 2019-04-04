/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.HorarioAlimentacionEntity;
import co.edu.konradlorenz.zoo.persistence.HorarioAlimentacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic HorarioAlimentacion
 * @author carlosmejia
 */

@Stateless
public class HorarioAlimentacionLogic {
    @Inject
    private HorarioAlimentacionPersistence persistence;
    
    /**
     * Metodo para obtener lista de los horarios de alimentacion
     * @return ListHorarioALimentacion
     */
    public List<HorarioAlimentacionEntity> obtenerHorarioAlimentacion(){
        List<HorarioAlimentacionEntity> horarioAlimentacion = persistence.findall();
        return horarioAlimentacion;
    }
    
    /**
     * Metodo para obtener un horario de alimentacion
     * @param id
     * @return HorarioLAimentacion obtenido
     */
    public HorarioAlimentacionEntity obtenerHorarioAlimentacionPorId(Long id){
        HorarioAlimentacionEntity horarioAlimentacion = persistence.find(id);
        
        if(horarioAlimentacion == null){
            throw new IllegalArgumentException("El Horario de Alimentacion seleccionado no existe.");
        }
        
        return horarioAlimentacion;
    }
    
    /**
     * Metodo para crear un horario de alimentacion
     * @param entity
     * @return HorarioAlimentacion creado
     */
    public HorarioAlimentacionEntity crearHorarioAlimentacion(HorarioAlimentacionEntity entity){
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar un horario de alimentacion
     * @param entity
     * @param id
     * @return HorarioALimentacion actualizado
     */
    public HorarioAlimentacionEntity actualizarHorarioAlimentacion(HorarioAlimentacionEntity entity, Long id){
        HorarioAlimentacionEntity horarioAlimentacion = persistence.update(entity);
        return horarioAlimentacion;
    }
    
    /**
     * Metodo para eliminar un horario de alimentacion
     * @param id 
     */
    public void eliminarHorarioAlimentacion(Long id){
        persistence.delete(id);
    }
}
