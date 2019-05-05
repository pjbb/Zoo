package co.edu.konradlorenz.zoo.resources;


import co.edu.konradlorenz.zoo.dto.AnimalDTO;
import co.edu.konradlorenz.zoo.dto.CargoDTO;
import co.edu.konradlorenz.zoo.entities.AnimalEntity;
import co.edu.konradlorenz.zoo.entities.CargoEntity;
import co.edu.konradlorenz.zoo.logic.AnimalLogic;
import co.edu.konradlorenz.zoo.logic.CargoLogic;
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
@Path("/cargo")
public class CargoResource {
    
    @EJB
    private CargoLogic cargoLogic;

    /**
     * Metodo que obtiene todos los datos de cargo
     * @return Lista CargoDTO
     */
    @GET
    public List<CargoDTO> getCargoList(){
        List <CargoEntity> cargo =  cargoLogic.obtenerCargo();
        return CargoDTO.toCargoList(cargo);
    }
    
    /**
     * Obtener cargo por su id
     * @param id
     * @return CargoEntity
     */
    @GET
    @Path("{id: \\d+}")
    public CargoDTO getCargo(@PathParam("id") Long id){
        CargoEntity cargo = cargoLogic.obtenerCargoPorId(id);
        if (cargo == null){
            throw new RuntimeException("El cargo no existe");
        } 
        return new CargoDTO(cargo);
    }
    
    @POST
    public CargoDTO createCargo(CargoDTO cargoDTO){
        return new CargoDTO(cargoLogic.crearCargo(cargoDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un cargo
     * @param id
     * @param cargoDTO
     * @return cargoDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public CargoDTO updateCargo(@PathParam("id") Long id, CargoDTO cargoDTO){
        CargoEntity cargoEntity = cargoLogic.obtenerCargoPorId(id);
        if(cargoEntity == null){
            throw new RuntimeException("El cargo no existe.");
        }
        return new CargoDTO(cargoLogic.actualizarCargo(cargoDTO.toEntity(), id));
    }
    
    @DELETE
    @Path("{cargoId: \\d+}")
    public void deleteCargo(@PathParam("cargoId") Long id){
        CargoEntity cargoEntity = cargoLogic.obtenerCargoPorId(id);
        if(cargoEntity == null){
            throw new RuntimeException("El cargo no existe.");
        }
        cargoLogic.eliminarCargo(id);
    }
}
