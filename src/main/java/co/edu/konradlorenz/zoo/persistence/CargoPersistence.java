/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.CargoEntity;
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
public class CargoPersistence {
    
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de CargoEntity
     */
    public List<CargoEntity> findall(){
        Query q = em.createQuery("SELECT p FROM CargoEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para encontrar un dato por Id
     * @param id
     * @return Elemento de CargoEntity
     */
    public CargoEntity find(Long id){
        return em.find(CargoEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla cargo
     * @param p
     * @return 
     */
    public CargoEntity create(CargoEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato de la tabla cargo
     * @param p
     * @return CargoEntity actualizado
     */
    public CargoEntity update(CargoEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato por Id
     * @param id 
     */
    public void delete(Long id){
        CargoEntity entity = em.find(CargoEntity.class, id);
        em.remove(entity);
    }
}
