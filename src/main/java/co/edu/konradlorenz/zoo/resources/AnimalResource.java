package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.AnimalDTO;
import co.edu.konradlorenz.zoo.entities.AnimalEntity;
import co.edu.konradlorenz.zoo.logic.AnimalLogic;
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
 * Recurso de Producto
 * @author pjbb.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/animal")
public class AnimalResource {
    
    @EJB
    private AnimalLogic animalLogic;

    /**
     * Metodo que obtiene todos los datos de animal
     * @return Lista AnimalDTO
     */
    @GET
    @Consumes
    public List<AnimalDTO> getAnimalList(){
        List <AnimalEntity> animal = animalLogic.obtenerAnimal();
        return AnimalDTO.toAnimalList(animal);
    }
    
    /**
     * Obtener animal por su id
     * @param id
     * @return AnimalEntity
     */
    @GET
    @Path("{id: \\d+}")
    public AnimalDTO getAnimal(@PathParam("id") Long id){
        AnimalEntity animal = animalLogic.obtenerAnimalPorId(id);
        if (animal == null){
            throw new RuntimeException("El animal no existe");
        } 
        return new AnimalDTO(animal);
    }
    
    @POST
    public AnimalDTO createAnimal(AnimalDTO animalDTO){
        return new AnimalDTO(animalLogic.crearAnimal(animalDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un animal
     * @param id
     * @param animalDTO
     * @return animalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public AnimalDTO updateAnimal(@PathParam("id") Long id, AnimalDTO animalDTO){
        AnimalEntity animalEntity = animalLogic.obtenerAnimalPorId(id);
        if(animalEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        return new AnimalDTO(animalLogic.actualizarAnimal(animalDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{animalId: \\d+}")
    public void deleteAnimal(@PathParam("animalId") Long id){
        AnimalEntity animalEntity = animalLogic.obtenerAnimalPorId(id);
        if(animalEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        animalLogic.eliminarAnimal(id);
    }
}
