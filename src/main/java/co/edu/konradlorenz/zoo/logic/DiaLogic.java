/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.DiaEntity;
import co.edu.konradlorenz.zoo.persistence.DiaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic Dia
 * @author carlosmejia
 */

@Stateless
public class DiaLogic {
    @Inject
    private DiaPersistence persistence;
    
    /**
     * Metodo para obtener toddos los elementos de dia 
     * @return ListDia
     */
    public List<DiaEntity> obtenerDia(){
        List<DiaEntity> dia = persistence.findall();
        return dia;
    }
    
    /**
     * Metodo para obtener un dia por id
     * @param id
     * @return Dia obtenido
     */
    public DiaEntity obtenerDiaPorId(Long id){
        DiaEntity dia = persistence.find(id);
        
        if(dia == null){
            throw new IllegalArgumentException("El dia solicitado no existe.");
        }
        
        return dia;
    }
    
    /**
     * Metodo para crear un dia
     * @param entity
     * @return dia creado 
     */
    public DiaEntity crearDia(DiaEntity entity){
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar un dia
     * @param entity
     * @return Dia actualizado
     */
    public DiaEntity actualizarDia(DiaEntity entity, Long id){
        DiaEntity dia = persistence.update(entity);
        return dia;        
    }
    
    /**
     * Metodo para eliminar un dia
     * @param id 
     */
    public void eliminarDia(Long id){
        persistence.delete(id);
    }
}
