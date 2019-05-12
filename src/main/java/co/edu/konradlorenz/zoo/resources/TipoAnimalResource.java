package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.PersonaDTO;
import co.edu.konradlorenz.zoo.dto.TipoAnimalDTO;
import co.edu.konradlorenz.zoo.entities.PersonaEntity;
import co.edu.konradlorenz.zoo.entities.TipoAnimalEntity;
import co.edu.konradlorenz.zoo.logic.PersonaLogic;
import co.edu.konradlorenz.zoo.logic.TipoAnimalLogic;
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
@Path("/tipoAnimal")
public class TipoAnimalResource {
    
    @EJB
    private TipoAnimalLogic tipoAnimalLogic;

    /**
     * Metodo que obtiene todos los datos de tipo animal
     * @return Lista TipoAnimalDTO
     */
    @GET
    public List<TipoAnimalDTO> getTipoAnimalList(){
        List <TipoAnimalEntity> tipoAnimal =  tipoAnimalLogic.obtenerTipoAnimal();
        return TipoAnimalDTO.toTipoAnimalList(tipoAnimal);
    }
    
    /**
     * Obtener tipo animal por su id
     * @param id
     * @return TipoAnimalEntity
     */
    @GET
    @Path("{id: \\d+}")
    public TipoAnimalDTO getTipoAnimal(@PathParam("id") Long id){
        TipoAnimalEntity tipoAnimal = tipoAnimalLogic.obtenerTipoAnimalPorId(id);
        if (tipoAnimal == null){
            throw new RuntimeException("El tipo de animal no existe");
        } 
        return new TipoAnimalDTO(tipoAnimal);
    }
    
    @POST
    public TipoAnimalDTO createTipoAnimal(TipoAnimalDTO tipoAnimalDTO){
        return new TipoAnimalDTO(tipoAnimalLogic.crearTipoAnimal(tipoAnimalDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un tipo de animal
     * @param id
     * @param tipoAnimalDTO
     * @return tipoAnimalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public TipoAnimalDTO updateTipoAnimal(@PathParam("id") Long id, TipoAnimalDTO tipoAnimalDTO){
        TipoAnimalEntity tipoAnimalEntity = tipoAnimalLogic.obtenerTipoAnimalPorId(id);
        if(tipoAnimalEntity == null){
            throw new RuntimeException("El tipo de animal no existe.");
        }
        return new TipoAnimalDTO(tipoAnimalLogic.actualizarTipoAnimal(tipoAnimalDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{tipoAnimalId: \\d+}")
    public void deleteTipoAnimal(@PathParam("tipoAnimalId") Long id){
        TipoAnimalEntity tipoAnimalEntity = tipoAnimalLogic.obtenerTipoAnimalPorId(id);
        if(tipoAnimalEntity == null){
            throw new RuntimeException("El tipo de animal no existe.");
        }
        tipoAnimalLogic.eliminarTipoAnimal(id);
    }
}
