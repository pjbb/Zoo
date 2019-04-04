/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.CargoEntity;
import co.edu.konradlorenz.zoo.persistence.CargoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic Cargo
 * @author carlosmejia
 */

@Stateless
public class CargoLogic {
    
    @Inject
    private CargoPersistence persitence;
    
    /**
     * Metodo para obtener una lista de los cargos
     * @return ListCargo
     */
    public List<CargoEntity> obtenerCargo(){
        List<CargoEntity> cargo = persitence.findall();
        return cargo;
    }
    
    /**
     * Metodo para obtener cargo por id
     * @param id
     * @return Cargo encontrado
     */
    public CargoEntity obtenerCargoPorId(Long id){
        CargoEntity cargo = persitence.find(id);
        
        if(cargo == null){
            throw new IllegalArgumentException("El cargo solicitado no existe");
        }
        
        return cargo;
    }
    
    /**
     * Metodo para crear un cargo
     * @param entity
     * @return Cargo creado
     */
    public CargoEntity crearCargo(CargoEntity entity){
        persitence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar un cargo
     * @param entity
     * @param id
     * @return Crago actualizado
     */
    public CargoEntity actualizarCargo(CargoEntity entity, Long id){
        CargoEntity cargo = persitence.update(entity);
        return cargo;
    }
    
    /**
     * 
     * Metodo para eliminar un cargo
     * @param id 
     */
    public void eliminarCargo(Long id){
        persitence.delete(id);
    }
}
