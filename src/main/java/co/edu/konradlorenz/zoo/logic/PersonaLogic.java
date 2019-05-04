package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.PersonaEntity;
import co.edu.konradlorenz.zoo.persistence.PersonaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic Persona
 * @author pjbb
 */

@Stateless
public class PersonaLogic {
    @Inject
    private PersonaPersistence persistence;
    
    /**
     * Metodo para obtener lista de las personas
     * @return ListLugar
     */
    public List<PersonaEntity> obtenerLugar(){
        List<PersonaEntity> persona = persistence.findall();
        return persona;
    }
    
    /**
     * Metodo para obtener una persona
     * @param id
     * @return Persona obtenido
     */
    public PersonaEntity obtenerPersonaPorId(Long id){
        PersonaEntity persona = persistence.find(id);
        
        if(persona == null){
            throw new IllegalArgumentException("La persona seleccionada no existe.");
        }
        
        return persona;
    }
    
    /**
     * Metodo para crear una persona
     * @param entity
     * @return Persona creado
     */
    public PersonaEntity crearPersona(PersonaEntity entity){
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar una persona
     * @param entity
     * @param id
     * @return Persona actualizado
     */
    public PersonaEntity actualizarPersona(PersonaEntity entity, Long id){
        PersonaEntity lugar = persistence.update(entity);
        return lugar;
    }
    
    /**
     * Metodo para eliminar un persona
     * @param id 
     */
    public void eliminarPersona(Long id){
        persistence.delete(id);
    }
}
