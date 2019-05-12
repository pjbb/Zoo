package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.DiaDTO;
import co.edu.konradlorenz.zoo.entities.DiaEntity;
import co.edu.konradlorenz.zoo.logic.DiaLogic;
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
public class DiaResource {
    
    @EJB
    private DiaLogic diaLogic;

    /**
     * Metodo que obtiene todos los datos de dia
     * @return Lista DiaDTO
     */
    @GET
    public List<DiaDTO> getDiaList(){
        List <DiaEntity> dia =  diaLogic.obtenerDia();
        return DiaDTO.toDiaList(dia);
    }
    
    /**
     * Obtener dia por su id
     * @param id
     * @return DiaEntity
     */
    @GET
    @Path("{id: \\d+}")
    public DiaDTO getDia(@PathParam("id") Long id){
        DiaEntity dia = diaLogic.obtenerDiaPorId(id);
        if (dia == null){
            throw new RuntimeException("El dia no existe");
        } 
        return new DiaDTO(dia);
    }
    
    @POST
    public DiaDTO createDia(DiaDTO diaDTO){
        return new DiaDTO(diaLogic.crearDia(diaDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un dia
     * @param id
     * @param diaDTO
     * @return diaDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public DiaDTO updateDia(@PathParam("id") Long id, DiaDTO diaDTO){
        DiaEntity diaEntity = diaLogic.obtenerDiaPorId(id);
        if(diaEntity == null){
            throw new RuntimeException("El dia no existe.");
        }
        return new DiaDTO(diaLogic.actualizarDia(diaDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{diaId: \\d+}")
    public void deleteDia(@PathParam("diaId") Long id){
        DiaEntity diaEntity = diaLogic.obtenerDiaPorId(id);
        if(diaEntity == null){
            throw new RuntimeException("El dia no existe.");
        }
        diaLogic.eliminarDia(id);
    }
}
