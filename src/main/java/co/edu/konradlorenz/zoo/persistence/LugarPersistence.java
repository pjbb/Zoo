/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.LugarEntity;
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
public class LugarPersistence {
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de LugarEntity
     */
    public List<LugarEntity> findall(){
        Query q = em.createQuery("SELECT p FROM LugarEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para encontrar un dato por Id
     * @param id
     * @return Elemento de LugarEntity
     */
    public LugarEntity find(Long id){
        return em.find(LugarEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla lugar
     * @param p
     * @return 
     */
    public LugarEntity create(LugarEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato de la tabla lugar
     * @param p
     * @return LugarEntity actualizado
     */
    public LugarEntity update(LugarEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato por Id
     * @param id 
     */
    public void delete(Long id){
        LugarEntity entity = em.find(LugarEntity.class, id);
        em.remove(entity);
    }
}
