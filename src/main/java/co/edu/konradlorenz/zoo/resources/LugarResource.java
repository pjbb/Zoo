package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.LugarDTO;
import co.edu.konradlorenz.zoo.entities.LugarEntity;
import co.edu.konradlorenz.zoo.logic.LugarLogic;
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
@Path("/lugar")
public class LugarResource {
    
    @EJB
    private LugarLogic lugarLogic;

    /**
     * Metodo que obtiene todos los datos del lugar
     * @return Lista LugarDTO
     */
    @GET
    public List<LugarDTO> getLugarList(){
        List <LugarEntity> lugar =  lugarLogic.obtenerLugar();
        return LugarDTO.toLugarList(lugar);
    }
    
    /**
     * Obtener lugar por su id
     * @param id
     * @return LugarEntity
     */
    @GET
    @Path("{id: \\d+}")
    public LugarDTO getLugar(@PathParam("id") Long id){
        LugarEntity lugar = lugarLogic.obtenerLugarPorId(id);
        if (lugar == null){
            throw new RuntimeException("El lugar no existe");
        } 
        return new LugarDTO(lugar);
    }
    
    @POST
    public LugarDTO createLugar(LugarDTO lugarDTO){
        return new LugarDTO(lugarLogic.crearLugar(lugarDTO.toEntity()));
    }
    
    /**
     * Actualizar un lugar
     * @param id
     * @param lugarDTO
     * @return lugarDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public LugarDTO updateLugar(@PathParam("id") Long id, LugarDTO lugarDTO){
        LugarEntity lugarEntity = lugarLogic.obtenerLugarPorId(id);
        if(lugarEntity == null){
            throw new RuntimeException("El lugar no existe.");
        }
        return new LugarDTO(lugarLogic.actualizarLugar(lugarDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{lugarId: \\d+}")
    public void deleteLugar(@PathParam("lugarId") Long id){
        LugarEntity lugarEntity = lugarLogic.obtenerLugarPorId(id);
        if(lugarEntity == null){
            throw new RuntimeException("El lugar no existe.");
        }
        lugarLogic.eliminarLugar(id);
    }
}
