/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author administrador1
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
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
