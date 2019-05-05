package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.TipoAnimalEntity;
import co.edu.konradlorenz.zoo.persistence.TipoAnimalPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic Tipo Animal
 * @author pjbb
 */

@Stateless
public class TipoAnimalLogic {
    @Inject
    private TipoAnimalPersistence persistence;
    
    /**
     * Metodo para obtener lista de los TipoAnimal
     * @return ListLugar
     */
    public List<TipoAnimalEntity> obtenerTipoAnimal(){
        List<TipoAnimalEntity> tipoAnimal = persistence.findall();
        return tipoAnimal;
    }
    
    /**
     * Metodo para obtener un TipoAnimal
     * @param id
     * @return TipoAnimal obtenido
     */
    public TipoAnimalEntity obtenerTipoAnimalPorId(Long id){
        TipoAnimalEntity tipoAnimal = persistence.find(id);
        
        if(tipoAnimal == null){
            throw new IllegalArgumentException("El tipo de animal no existe.");
        }
        
        return tipoAnimal;
    }
    
    /**
     * Metodo para crear un TipoAnimal
     * @param entity
     * @return TipoAnimal creado
     */
    public TipoAnimalEntity crearTipoAnimal(TipoAnimalEntity entity){
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar un TipoAnimal
     * @param entity
     * @param id
     * @return TipoAnimal actualizado
     */
    public TipoAnimalEntity actualizarTipoAnimal(TipoAnimalEntity entity, Long id){
        TipoAnimalEntity tipoAnimal = persistence.update(entity);
        return tipoAnimal;
    }
    
    /**
     * Metodo para eliminar un TipoAnimal
     * @param id 
     */
    public void eliminarTipoAnimal(Long id){
        persistence.delete(id);
    }
}
