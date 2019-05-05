package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.ShowEntity;
import co.edu.konradlorenz.zoo.persistence.ShowPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic Persona
 * @author pjbb
 */

@Stateless
public class ShowLogic {
    @Inject
    private ShowPersistence persistence;
    
    /**
     * Metodo para obtener lista de los shows
     * @return ListLugar
     */
    public List<ShowEntity> obtenerShow(){
        List<ShowEntity> show = persistence.findall();
        return show;
    }
    
    /**
     * Metodo para obtener un show
     * @param id
     * @return Show obtenido
     */
    public ShowEntity obtenerShowPorId(Long id){
        ShowEntity show = persistence.find(id);
        
        if(show == null){
            throw new IllegalArgumentException("El show seleccionado no existe.");
        }
        
        return show;
    }
    
    /**
     * Metodo para crear un show
     * @param entity
     * @return Show creado
     */
    public ShowEntity crearShow(ShowEntity entity){
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar un show
     * @param entity
     * @param id
     * @return Show actualizado
     */
    public ShowEntity actualizarShow(ShowEntity entity, Long id){
        ShowEntity show = persistence.update(entity);
        return show;
    }
    
    /**
     * Metodo para eliminar un show
     * @param id 
     */
    public void eliminarShow(Long id){
        persistence.delete(id);
    }
}
