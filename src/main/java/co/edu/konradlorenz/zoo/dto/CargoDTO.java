/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.CargoEntity;

/**
 *
 * @author carlosmejia
 */
public class CargoDTO {
    /**
     * Atributo id del cargo
     */
    private Long idCargo;
    
    /**
     * atributo nombre del cargo
     */
    private String nombreCargo;
    
    /**
     * Constructores
     */
    public CargoDTO(){
        
    }

    public CargoDTO(Long idCargo, String nombreCargo) {
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
    }
    
    public CargoEntity toEntity(){
        CargoEntity cargoEntity = new CargoEntity();
        cargoEntity.setId(this.idCargo);
        cargoEntity.setNombre(this.nombreCargo);
        
        return cargoEntity;
    }

    /**
     * Getters
     */
    public Long getIdCargo() {
        return idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }
    
    /**
     * Setters
     */
    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
}
