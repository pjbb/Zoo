/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.HorarioAlimentacionEntity;
import co.edu.konradlorenz.zoo.entities.TipoAnimalEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO TipoAnimal
 * @author carlosmejia
 */
public class TipoAnimalDTO {
    /**
     * Atributo id
     */
    private Long idTipoAnimal;
    
    /**
     * Atributo nombre
     */    
    private String nombreTipoAnimal;
    
    /**
     * Atributo horario
     */
    private HorarioAlimentacionEntity idHorarioAlimentacion;
    
    /**
     * Constructores
     */
    public TipoAnimalDTO(){
        
    }

    public TipoAnimalDTO(TipoAnimalEntity tipoAnimal) {
        this.idTipoAnimal = tipoAnimal.getId();
        this.nombreTipoAnimal = tipoAnimal.getNombre();
        this.idHorarioAlimentacion = tipoAnimal.getHorarioAlimentacion();
    }
    
    /**
     * Coversion DTO - Entity
     * @return tipoAnimalEntity
     */
    public TipoAnimalEntity toEntity(){
        TipoAnimalEntity tipoAnimalEntity = new TipoAnimalEntity();
        tipoAnimalEntity.setId(this.idTipoAnimal);
        tipoAnimalEntity.setNombre(this.nombreTipoAnimal);
        tipoAnimalEntity.setHorarioAlimentacion(this.idHorarioAlimentacion);
        
        return tipoAnimalEntity;
    }
    
    /**
      * Método para conversión de lista DTO a lista Entidades
      * @param tipoAnimalList
      * @return listaTipoANimal
      */
    public static List<TipoAnimalDTO> toTipoAnimalList(List<TipoAnimalEntity> tipoAnimalList){
        List<TipoAnimalDTO> listaTipoAnimal = new ArrayList<>();
        for(int i = 0; i < tipoAnimalList.size(); i++){
            listaTipoAnimal.add(new TipoAnimalDTO(tipoAnimalList.get(i)));
        }
        return listaTipoAnimal;
    }

    /**
     * Getters 
     */
    public Long getIdTipoAnimal() {
        return idTipoAnimal;
    }

    public String getNombreTipoAnimal() {
        return nombreTipoAnimal;
    }

    public HorarioAlimentacionEntity getIdHorarioAlimentacion() {
        return idHorarioAlimentacion;
    }

    /**
     * Setters
     */
    public void setIdTipoAnimal(Long idTipoAnimal) {
        this.idTipoAnimal = idTipoAnimal;
    }

    public void setNombreTipoAnimal(String nombreTipoAnimal) {
        this.nombreTipoAnimal = nombreTipoAnimal;
    }

    public void setIdHorarioAlimentacion(HorarioAlimentacionEntity idHorarioAlimentacion) {
        this.idHorarioAlimentacion = idHorarioAlimentacion;
    }
}
