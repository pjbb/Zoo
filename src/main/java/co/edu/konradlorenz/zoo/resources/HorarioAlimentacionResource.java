package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.HorarioAlimentacionDTO;
import co.edu.konradlorenz.zoo.entities.HorarioAlimentacionEntity;
import co.edu.konradlorenz.zoo.logic.HorarioAlimentacionLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Recurso de Cargo
 * @author pjbb.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/horarioAlimentacion")
public class HorarioAlimentacionResource {
    
    @EJB
    private HorarioAlimentacionLogic horarioAlimentacionLogic;

    /**
     * Metodo que obtiene todos los datos del horario de alimentacion
     * @return Lista HorarioAlimentacionDTO
     */
    @GET
    public List<HorarioAlimentacionDTO> getHorarioAlimentacionList(){
        List <HorarioAlimentacionEntity> horarioAlimentacion =  horarioAlimentacionLogic.obtenerHorarioAlimentacion();
        return HorarioAlimentacionDTO.toHorarioAlimentacionList(horarioAlimentacion);
    }
    
    /**
     * Obtener horario de alimentacion por su id
     * @param id
     * @return HorarioAlimentacionEntity
     */
    @GET
    @Path("{id: \\d+}")
    public HorarioAlimentacionDTO getHorarioAlimentacion(@PathParam("id") Long id){
        HorarioAlimentacionEntity horarioAlimentacion = horarioAlimentacionLogic.obtenerHorarioAlimentacionPorId(id);
        if (horarioAlimentacion == null){
            throw new RuntimeException("El horario de alimentación no existe");
        } 
        return new HorarioAlimentacionDTO(horarioAlimentacion);
    }
    
    @POST
    public HorarioAlimentacionDTO createHorarioAlimentacion(HorarioAlimentacionDTO horarioAlimentacionDTO){
        return new HorarioAlimentacionDTO(horarioAlimentacionLogic.crearHorarioAlimentacion(horarioAlimentacionDTO.toEntity()));
    }
    
    /**
     * Actualizar una horario de alimentacion
     * @param id
     * @param horarioAlimentacionDTO
     * @return horarioAlimentacionDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public HorarioAlimentacionDTO updateHorarioAlimentacion(@PathParam("id") Long id, HorarioAlimentacionDTO horarioAlimentacionDTO){
        HorarioAlimentacionEntity horarioAlimentacionEntity = horarioAlimentacionLogic.obtenerHorarioAlimentacionPorId(id);
        if(horarioAlimentacionEntity == null){
            throw new RuntimeException("El horario de alimentación no existe.");
        }
        return new HorarioAlimentacionDTO(horarioAlimentacionLogic.actualizarHorarioAlimentacion(horarioAlimentacionDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{horarioAlimentacionId: \\d+}")
    public void deleteHorarioAlimentacion(@PathParam("horarioAlimentacionId") Long id){
        HorarioAlimentacionEntity horarioAlimentacionEntity = horarioAlimentacionLogic.obtenerHorarioAlimentacionPorId(id);
        if(horarioAlimentacionEntity == null){
            throw new RuntimeException("El horario de alimentación no existe.");
        }
        horarioAlimentacionLogic.eliminarHorarioAlimentacion(id);
    }
}
