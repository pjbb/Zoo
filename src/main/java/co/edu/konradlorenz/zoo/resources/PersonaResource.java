package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.PersonaDTO;
import co.edu.konradlorenz.zoo.entities.PersonaEntity;
import co.edu.konradlorenz.zoo.logic.PersonaLogic;
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
@Path("/persona")
public class PersonaResource {
    
    @EJB
    private PersonaLogic personaLogic;

    /**
     * Metodo que obtiene todos los datos de persona
     * @return Lista PersonaDTO
     */
    @GET
    public List<PersonaDTO> getPersonaList(){
        List <PersonaEntity> persona =  personaLogic.obtenerPersona();
        return PersonaDTO.toPersonaList(persona);
    }
    
    /**
     * Obtener dia por su persona
     * @param id
     * @return PersonaEntity
     */
    @GET
    @Path("{id: \\d+}")
    public PersonaDTO getPersona(@PathParam("id") Long id){
        PersonaEntity persona = personaLogic.obtenerPersonaPorId(id);
        if (persona == null){
            throw new RuntimeException("La persona no existe");
        } 
        return new PersonaDTO(persona);
    }
    
    @POST
    public PersonaDTO createPersona(PersonaDTO personaDTO){
        return new PersonaDTO(personaLogic.crearPersona(personaDTO.toEntity()));
    }
    
    
    /**
     * Actualizar una persona
     * @param id
     * @param personaDTO
     * @return personaDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public PersonaDTO updatePersona(@PathParam("id") Long id, PersonaDTO personaDTO){
        PersonaEntity personaEntity = personaLogic.obtenerPersonaPorId(id);
        if(personaEntity == null){
            throw new RuntimeException("La persona no existe.");
        }
        return new PersonaDTO(personaLogic.actualizarPersona(personaDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{personaId: \\d+}")
    public void deletePersona(@PathParam("personaId") Long id){
        PersonaEntity personaEntity = personaLogic.obtenerPersonaPorId(id);
        if(personaEntity == null){
            throw new RuntimeException("La persona no existe.");
        }
        personaLogic.eliminarPersona(id);
    }
}
