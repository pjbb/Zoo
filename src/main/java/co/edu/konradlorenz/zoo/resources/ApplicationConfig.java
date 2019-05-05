package co.edu.konradlorenz.zoo.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Representa el registro de las clases que se personalizan como servicios REST
 * @author pjbb.
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;      
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(co.edu.konradlorenz.zoo.resources.AnimalResource.class);
        resources.add(co.edu.konradlorenz.zoo.resources.CargoResource.class);
        resources.add(co.edu.konradlorenz.zoo.resources.DiaResource.class);
        resources.add(co.edu.konradlorenz.zoo.resources.EvaluacionResource.class);
        resources.add(co.edu.konradlorenz.zoo.resources.HorarioAlimentacionResource.class);
        resources.add(co.edu.konradlorenz.zoo.resources.HorarioResource.class);
        resources.add(co.edu.konradlorenz.zoo.resources.LugarResource.class);
        resources.add(co.edu.konradlorenz.zoo.resources.PersonaResource.class);
        resources.add(co.edu.konradlorenz.zoo.resources.ShowResource.class);
        resources.add(co.edu.konradlorenz.zoo.resources.TipoAnimalResource.class);
        resources.add(co.edu.konradlorenz.zoo.resources.TipoDocumentoResource.class);
    }
}
