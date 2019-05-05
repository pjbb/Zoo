package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.ShowDTO;
import co.edu.konradlorenz.zoo.entities.ShowEntity;
import co.edu.konradlorenz.zoo.logic.ShowLogic;
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
@Path("/show")
public class ShowResource {
    
    @EJB
    private ShowLogic showLogic;

    /**
     * Metodo que obtiene todos los datos del show
     * @return Lista ShowDTO
     */
    @GET
    public List<ShowDTO> getShowList(){
        List <ShowEntity> show =  showLogic.obtenerShow();
        return ShowDTO.toShowList(show);
    }
    
    /**
     * Obtener show por su id
     * @param id
     * @return ShowEntity
     */
    @GET
    @Path("{id: \\d+}")
    public ShowDTO getShow(@PathParam("id") Long id){
        ShowEntity show = showLogic.obtenerShowPorId(id);
        if (show == null){
            throw new RuntimeException("El show no existe");
        } 
        return new ShowDTO(show);
    }
    
    @POST
    public ShowDTO createShow(ShowDTO showDTO){
        return new ShowDTO(showLogic.crearShow(showDTO.toEntity()));
    }
    
    /**
     * Actualizar un show
     * @param id
     * @param showDTO
     * @return showDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public ShowDTO updateShow(@PathParam("id") Long id, ShowDTO showDTO){
        ShowEntity showEntity = showLogic.obtenerShowPorId(id);
        if(showEntity == null){
            throw new RuntimeException("El show no existe.");
        }
        return new ShowDTO(showLogic.actualizarShow(showDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{showId: \\d+}")
    public void deleteShow(@PathParam("showId") Long id){
        ShowEntity showEntity = showLogic.obtenerShowPorId(id);
        if(showEntity == null){
            throw new RuntimeException("El show no existe.");
        }
        showLogic.eliminarShow(id);
    }
}
