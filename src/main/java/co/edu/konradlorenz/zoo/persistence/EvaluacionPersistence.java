/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.EvaluacionEntity;
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
public class EvaluacionPersistence {
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de EvaluacionEntity
     */
    public List<EvaluacionEntity> findall(){
        Query q = em.createQuery("SELECT p FROM EvaluacionEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para encontrar un dato por Id
     * @param id
     * @return Elemento de EvaluacionEntity
     */
    public EvaluacionEntity find(Long id){
        return em.find(EvaluacionEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla evaluacion
     * @param p
     * @return 
     */
    public EvaluacionEntity create(EvaluacionEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato de la tabla evaluacion
     * @param p
     * @return EvaluacionEntity actualizado
     */
    public EvaluacionEntity update(EvaluacionEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato por Id
     * @param id 
     */
    public void delete(Long id){
        EvaluacionEntity entity = em.find(EvaluacionEntity.class, id);
        em.remove(entity);
    }
}
