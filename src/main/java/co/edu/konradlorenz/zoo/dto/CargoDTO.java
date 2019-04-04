/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.CargoEntity;
import java.util.ArrayList;
import java.util.List;

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

    public CargoDTO(CargoEntity cargo) {
        this.idCargo = cargo.getId();
        this.nombreCargo = cargo.getNombre();
    }
    
    /**
     * Conversio DTO -Entity
     * @return cargoEntity
     */
    public CargoEntity toEntity(){
        CargoEntity cargoEntity = new CargoEntity();
        cargoEntity.setId(this.idCargo);
        cargoEntity.setNombre(this.nombreCargo);
        
        return cargoEntity;
    }
    
    /**
      * Método para conversión de lista DTO a lista Entidades
      * @param cargoList
      * @return 
      */
    public static List<CargoDTO> toCargoList(List<CargoEntity> cargoList){
        List<CargoDTO> listaCargos = new ArrayList<>();
        for (int i = 0; i < cargoList.size(); i++) {
            listaCargos.add(new CargoDTO(cargoList.get(i)));
        }
        return listaCargos;
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
