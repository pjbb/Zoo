/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.AnimalEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * 
 * @author Benitez Paula, Mejia Carlos
 */
@Stateless
public class AnimalPersistence {
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de AnimalEntity
     */
    public List<AnimalEntity> findall(){
        Query q = em.createQuery("SELECT p FROM AnimalEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para buscar un elemento por Id
     * @param id
     * @return Elemento de AnimalEntity 
     */
    public AnimalEntity find(Long id){
        return em.find(AnimalEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla animal
     * @param p
     * @return 
     */
    public AnimalEntity create(AnimalEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato en la tabla animal
     * @param p
     * @return AnimalEntity actualizado
     */
    public  AnimalEntity update(AnimalEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato de la tabla Animal
     * @param id 
     */
    public void delete(Long id){
        AnimalEntity entity = em.find(AnimalEntity.class, id);
        em.remove(entity);
    }
}
