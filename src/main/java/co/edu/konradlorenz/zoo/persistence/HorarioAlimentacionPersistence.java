/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.HorarioAlimentacionEntity;
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
public class HorarioAlimentacionPersistence {
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de HorarioAlimentacionEntity
     */
    public List<HorarioAlimentacionEntity> findall(){
        Query q = em.createQuery("SELECT p FROM HorarioAlimentacionEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para encontrar un dato por Id
     * @param id
     * @return Elemento de HorarioAlimentacionEntity
     */
    public HorarioAlimentacionEntity find(Long id){
        return em.find(HorarioAlimentacionEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla horarioAlimentacion
     * @param p
     * @return 
     */
    public HorarioAlimentacionEntity create(HorarioAlimentacionEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato de la tabla cargo
     * @param p
     * @return HorarioAlimentacionEntity actualizado
     */
    public HorarioAlimentacionEntity update(HorarioAlimentacionEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato por Id
     * @param id 
     */
    public void delete(Long id){
        HorarioAlimentacionEntity entity = em.find(HorarioAlimentacionEntity.class, id);
        em.remove(entity);
    }
}
