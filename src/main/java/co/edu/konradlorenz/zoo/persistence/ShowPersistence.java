/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.ShowEntity;
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
public class ShowPersistence {
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de ShowEntity
     */
    public List<ShowEntity> findall(){
        Query q = em.createQuery("SELECT p FROM ShowEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para encontrar un dato por Id
     * @param id
     * @return Elemento de ShowEntity
     */
    public ShowEntity find(Long id){
        return em.find(ShowEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla Show
     * @param p
     * @return 
     */
    public ShowEntity create(ShowEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato de la tabla Show
     * @param p
     * @return ShowEntity actualizado
     */
    public ShowEntity update(ShowEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato por Id
     * @param id 
     */
    public void delete(Long id){
        ShowEntity entity = em.find(ShowEntity.class, id);
        em.remove(entity);
    }
}
