/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.DiaEntity;
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
public class DiaPersistence {
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de DiaEntity
     */
    public List<DiaEntity> findall(){
        Query q = em.createQuery("SELECT p FROM DiaEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para encontrar un dato por Id
     * @param id
     * @return Elemento de DiaEntity
     */
    public DiaEntity find(Long id){
        return em.find(DiaEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla dia
     * @param p
     * @return 
     */
    public DiaEntity create(DiaEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato de la tabla dia
     * @param p
     * @return DiaEntity actualizado
     */
    public DiaEntity update(DiaEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato por Id
     * @param id 
     */
    public void delete(Long id){
        DiaEntity entity = em.find(DiaEntity.class, id);
        em.remove(entity);
    }
}
