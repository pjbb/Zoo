package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.LugarEntity;
import co.edu.konradlorenz.zoo.persistence.LugarPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic Lugar
 * @author pjbb
 */

@Stateless
public class LugarLogic {
    @Inject
    private LugarPersistence persistence;
    
    /**
     * Metodo para obtener lista de los lugares
     * @return ListLugar
     */
    public List<LugarEntity> obtenerLugar(){
        List<LugarEntity> lugar = persistence.findall();
        return lugar;
    }
    
    /**
     * Metodo para obtener un lugar
     * @param id
     * @return Lugar obtenido
     */
    public LugarEntity obtenerLugarPorId(Long id){
        LugarEntity lugar = persistence.find(id);
        
        if(lugar == null){
            throw new IllegalArgumentException("El lugar seleccionado no existe.");
        }
        
        return lugar;
    }
    
    /**
     * Metodo para crear un lugar
     * @param entity
     * @return Lugar creado
     */
    public LugarEntity crearLugar(LugarEntity entity){
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar un lugar
     * @param entity
     * @param id
     * @return Lugar actualizado
     */
    public LugarEntity actualizarLugar(LugarEntity entity, Long id){
        LugarEntity lugar = persistence.update(entity);
        return lugar;
    }
    
    /**
     * Metodo para eliminar un lugar
     * @param id 
     */
    public void eliminarLugar(Long id){
        persistence.delete(id);
    }
}
