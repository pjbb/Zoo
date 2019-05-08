package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.TipoDocumentoDTO;
import co.edu.konradlorenz.zoo.entities.TipoDocumentoEntity;
import co.edu.konradlorenz.zoo.logic.TipoDocumentoLogic;
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
 * Recurso de TipoDocumento
 * @author pjbb.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tipoDocumento")
public class TipoDocumentoResource {
    
    @EJB
    private TipoDocumentoLogic tipoDocumentoLogic;

    /**
     * Metodo que obtiene todos los datos de tipo documento
     * @return Lista TipoDocumentoDTO
     */
    @GET
    public List<TipoDocumentoDTO> getTipoDocumentoList(){
        List <TipoDocumentoEntity> tipoDocumento =  tipoDocumentoLogic.obtenerTipoDocumento();
        return TipoDocumentoDTO.toTipoDocumentoList(tipoDocumento);
    }
    
    /**
     * Obtener tipoDocumento por su id
     * @param id
     * @return TipoDocumentoEntity
     */
    @GET
    @Path("{id: \\d+}")
    public TipoDocumentoDTO getTipoDocumento(@PathParam("id") Long id){
        TipoDocumentoEntity tipoDocumento = tipoDocumentoLogic.obtenerTipoDocumentoPorId(id);
        if (tipoDocumento == null){
            throw new RuntimeException("El tipo de documento no existe");
        } 
        return new TipoDocumentoDTO(tipoDocumento);
    }
    
    @POST
    public TipoDocumentoDTO createTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO){
        return new TipoDocumentoDTO(tipoDocumentoLogic.crearTipoDocumento(tipoDocumentoDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un tipo de documento
     * @param id
     * @param tipoDocumentoDTO
     * @return TipoDocumentoDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public TipoDocumentoDTO updateTipoDocumento(@PathParam("id") Long id, TipoDocumentoDTO tipoDocumentoDTO){
        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoLogic.obtenerTipoDocumentoPorId(id);
        if(tipoDocumentoEntity == null){
            throw new RuntimeException("El tipo de documento no existe.");
        }
        return new TipoDocumentoDTO(tipoDocumentoLogic.actualizarTipoDocumento(tipoDocumentoDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{tipoDocumentoId: \\d+}")
    public void deleteTipoDocumento(@PathParam("tipoDocumentoId") Long id){
        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoLogic.obtenerTipoDocumentoPorId(id);
        if(tipoDocumentoEntity == null){
            throw new RuntimeException("El tipo de documento no existe.");
        }
        tipoDocumentoLogic.eliminarTipoDocumento(id);
    }
}
