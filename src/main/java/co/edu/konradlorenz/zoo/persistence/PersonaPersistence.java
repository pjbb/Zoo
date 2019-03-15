/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.PersonaEntity;
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
public class PersonaPersistence {
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de PersonaEntity
     */
    public List<PersonaEntity> findall(){
        Query q = em.createQuery("SELECT p FROM PersonaEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para encontrar un dato por Id
     * @param id
     * @return Elemento de PersonaEntity
     */
    public PersonaEntity find(Long id){
        return em.find(PersonaEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla persona
     * @param p
     * @return 
     */
    public PersonaEntity create(PersonaEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato de la tabla persona
     * @param p
     * @return PersonaEntity actualizado
     */
    public PersonaEntity update(PersonaEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato por Id
     * @param id 
     */
    public void delete(Long id){
        PersonaEntity entity = em.find(PersonaEntity.class, id);
        em.remove(entity);
    }
}
