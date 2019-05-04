package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.HorarioEntity;
import co.edu.konradlorenz.zoo.persistence.HorarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic Horario
 * @author pjbb
 */

@Stateless
public class HorarioLogic {
    @Inject
    private HorarioPersistence persistence;
    
    /**
     * Metodo para obtener lista de los horarios
     * @return ListHorarioALimentacion
     */
    public List<HorarioEntity> obtenerHorario(){
        List<HorarioEntity> horario = persistence.findall();
        return horario;
    }
    
    /**
     * Metodo para obtener un horario
     * @param id
     * @return HorarioLAimentacion obtenido
     */
    public HorarioEntity obtenerHorarioPorId(Long id){
        HorarioEntity horario = persistence.find(id);
        
        if(horario == null){
            throw new IllegalArgumentException("El Horario seleccionado no existe.");
        }
        
        return horario;
    }
    
    /**
     * Metodo para crear un horario
     * @param entity
     * @return Horario creado
     */
    public HorarioEntity crearHorario(HorarioEntity entity){
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar un horario
     * @param entity
     * @param id
     * @return Horario actualizado
     */
    public HorarioEntity actualizarHorario(HorarioEntity entity, Long id){
        HorarioEntity horario = persistence.update(entity);
        return horario;
    }
    
    /**
     * Metodo para eliminar un horario
     * @param id 
     */
    public void eliminarHorario(Long id){
        persistence.delete(id);
    }
}
