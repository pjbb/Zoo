/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.HorarioEntity;
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
public class HorarioPersistence {
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de HorarioEntity
     */
    public List<HorarioEntity> findall(){
        Query q = em.createQuery("SELECT p FROM HorarioEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para encontrar un dato por Id
     * @param id
     * @return Elemento de horarioEntity
     */
    public HorarioEntity find(Long id){
        return em.find(HorarioEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla horario
     * @param p
     * @return 
     */
    public HorarioEntity create(HorarioEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato de la tabla horario
     * @param p
     * @return HorarioEntity actualizado
     */
    public HorarioEntity update(HorarioEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato por Id
     * @param id 
     */
    public void delete(Long id){
        HorarioEntity entity = em.find(HorarioEntity.class, id);
        em.remove(entity);
    }
}
