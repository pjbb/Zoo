package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.HorarioDTO;
import co.edu.konradlorenz.zoo.entities.HorarioEntity;
import co.edu.konradlorenz.zoo.logic.HorarioLogic;
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
@Path("/horario")
public class HorarioResource {
    
    @EJB
    private HorarioLogic horarioLogic;

    /**
     * Metodo que obtiene todos los datos del horario
     * @return Lista HorarioDTO
     */
    @GET
    public List<HorarioDTO> getHorarioList(){
        List <HorarioEntity> horario =  horarioLogic.obtenerHorario();
        return HorarioDTO.toHorarioList(horario);
    }
    
    /**
     * Obtener horario por su id
     * @param id
     * @return HorarioEntity
     */
    @GET
    @Path("{id: \\d+}")
    public HorarioDTO getHorario(@PathParam("id") Long id){
        HorarioEntity horario = horarioLogic.obtenerHorarioPorId(id);
        if (horario == null){
            throw new RuntimeException("El horario no existe");
        } 
        return new HorarioDTO(horario);
    }
    
    @POST
    public HorarioDTO createHorario(HorarioDTO horarioDTO){
        return new HorarioDTO(horarioLogic.crearHorario(horarioDTO.toEntity()));
    }
    
    /**
     * Actualizar una horario
     * @param id
     * @param horarioDTO
     * @return horarioDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public HorarioDTO updateHorario(@PathParam("id") Long id, HorarioDTO horarioDTO){
        HorarioEntity horarioEntity = horarioLogic.obtenerHorarioPorId(id);
        if(horarioEntity == null){
            throw new RuntimeException("El horario no existe.");
        }
        return new HorarioDTO(horarioLogic.actualizarHorario(horarioDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{horarioId: \\d+}")
    public void deleteHorario(@PathParam("horarioId") Long id){
        HorarioEntity horarioEntity = horarioLogic.obtenerHorarioPorId(id);
        if(horarioEntity == null){
            throw new RuntimeException("El horario no existe.");
        }
        horarioLogic.eliminarHorario(id);
    }
}
