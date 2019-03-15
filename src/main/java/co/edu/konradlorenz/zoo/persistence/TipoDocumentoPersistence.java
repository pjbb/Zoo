/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.persistence;

import co.edu.konradlorenz.zoo.entities.TipoDocumentoEntity;
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
public class TipoDocumentoPersistence {
    /**
     * Manejador
     */
    @PersistenceContext (unitName = "persistence")
    protected EntityManager em;
    
    /**
     * Metodo que trae todos los datos de la base de datos
     * @return Lista de TipoDocuemntoEntity
     */
    public List<TipoDocumentoEntity> findall(){
        Query q = em.createQuery("SELECT p FROM TipoDocumentoEntity p");
        return q.getResultList();
    }
    
    /**
     * Metodo para encontrar un dato por Id
     * @param id
     * @return Elemento de TipoDocumentoEntity
     */
    public TipoDocumentoEntity find(Long id){
        return em.find(TipoDocumentoEntity.class, id);
    }
    
    /**
     * Metodo para instertar un dato en la tabla TipoDocumento
     * @param p
     * @return 
     */
    public TipoDocumentoEntity create(TipoDocumentoEntity p){
        em.persist(p);
        return p;
    }
    
    /**
     * Metodo para actualizar un dato de la tabla cargo
     * @param p
     * @return TipoDocuemntoEntity actualizado
     */
    public TipoDocumentoEntity update(TipoDocumentoEntity p){
        return em.merge(p);
    }
    
    /**
     * Metodo para eliminar un dato por Id
     * @param id 
     */
    public void delete(Long id){
        TipoDocumentoEntity entity = em.find(TipoDocumentoEntity.class, id);
        em.remove(entity);
    }
}
