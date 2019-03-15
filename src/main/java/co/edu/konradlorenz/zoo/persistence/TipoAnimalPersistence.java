/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.TipoAnimalEntity;
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
public class TipoAnimalPersistence {
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de TipoAnimalEntity
     */
    public List<TipoAnimalEntity> findall(){
        Query q = em.createQuery("SELECT p FROM TipoAnimalEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para encontrar un dato por Id
     * @param id
     * @return Elemento de TipoAnimalEntity
     */
    public TipoAnimalEntity find(Long id){
        return em.find(TipoAnimalEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla TipoAnimal
     * @param p
     * @return 
     */
    public TipoAnimalEntity create(TipoAnimalEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato de la tabla TipoAnimal
     * @param p
     * @return TipoAnimalEntity actualizado
     */
    public TipoAnimalEntity update(TipoAnimalEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato por Id
     * @param id 
     */
    public void delete(Long id){
        TipoAnimalEntity entity = em.find(TipoAnimalEntity.class, id);
        em.remove(entity);
    }
}
