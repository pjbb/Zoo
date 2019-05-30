package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.EvaluacionDTO;
import co.edu.konradlorenz.zoo.entities.EvaluacionEntity;
import co.edu.konradlorenz.zoo.logic.EvaluacionLogic;
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
@Path("/dia")
public class EvaluacionResource {
    
    @EJB
    private EvaluacionLogic evLogic;

    /**
     * Metodo que obtiene todos los datos de la evaluacion
     * @return Lista EvaluacionDTO
     */
    @GET
    @Consumes
    @Produces
    public List<EvaluacionDTO> getEvaluacionList(){
        List <EvaluacionEntity> ev =  evLogic.obtenerEvaluacion();
        return EvaluacionDTO.toEvaluacionList(ev);
    }
    
    /**
     * Obtener evaluacion por su id
     * @param id
     * @return EvaluacionEntity
     */
    @GET
    @Path("{id: \\d+}")
    public EvaluacionDTO getEvaluacion(@PathParam("id") Long id){
        EvaluacionEntity ev = evLogic.obtenerEvaluacionPorId(id);
        if (ev == null){
            throw new RuntimeException("La evaluación no existe");
        } 
        return new EvaluacionDTO(ev);
    }
    
    @POST
    public EvaluacionDTO createEvaluacion(EvaluacionDTO evDTO){
        return new EvaluacionDTO(evLogic.crearEvaluacion(evDTO.toEntity()));
    }
    
    
    /**
     * Actualizar una evaluacion
     * @param id
     * @param evaluacionDTO
     * @return evaluacionDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public EvaluacionDTO updateEvaluacion(@PathParam("id") Long id, EvaluacionDTO evaluacionDTO){
        EvaluacionEntity evaluacionEntity = evLogic.obtenerEvaluacionPorId(id);
        if(evaluacionEntity == null){
            throw new RuntimeException("La evaluación no existe.");
        }
        return new EvaluacionDTO(evLogic.actualizarEvaluacion(evaluacionDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{evaluacionId: \\d+}")
    public void deleteEvaluacion(@PathParam("evaluacionId") Long id){
        EvaluacionEntity evEntity = evLogic.obtenerEvaluacionPorId(id);
        if(evEntity == null){
            throw new RuntimeException("La evaluación no existe.");
        }
        evLogic.eliminarEvaluacion(id);
    }
}
