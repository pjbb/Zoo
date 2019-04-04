/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.AnimalEntity;
import co.edu.konradlorenz.zoo.persistence.AnimalPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic Animal
 * @author carlosmejia
 */

@Stateless
public class AnimalLogic {
    @Inject
    private AnimalPersistence persistence;
    
    /**
     * Metodo para obtener Animales
     * @return ListAnimal
     */
    public List<AnimalEntity> obtenerAnimal(){
        List<AnimalEntity> animal = persistence.findall();
        return animal;
    }
    
    /**
     * Metodo para obtener un Animal por Id
     * @param id
     * @return Animal encontrado
     */
    public AnimalEntity obtenerAnimalPorId(Long id){
        AnimalEntity animal = persistence.find(id);
        
        if(animal == null){
            throw new IllegalArgumentException("El animal solicitado no existe");
        }
        
        return animal;
    }
    
    /**
     * Metodo para Crear un Animal
     * @param entity
     * @return Animal creado
     */
    public AnimalEntity crearAnimal(AnimalEntity entity){
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar un Animal
     * @param entity
     * @param id
     * @return Anial Actualizado
     */
    public AnimalEntity actualizarAnimal(AnimalEntity entity, Long id){
        AnimalEntity animal = persistence.update(entity);
        return animal;
    }
    
    /**
     * Metodo para eliminar un animal
     * @param id 
     */
    public void eliminarAnimal(Long id){
        persistence.delete(id);
    }
}
