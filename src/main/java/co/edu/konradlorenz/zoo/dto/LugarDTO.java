/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.LugarEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO lugar
 * @author carlosmejia
 */
public class LugarDTO {
    /**
     * Atributo id
     */
    private Long idLugar;
    
    /**
     * Atributo nombre
     */
    private String nombreLugar;
    
    /**
     * Constructores
     */
    public LugarDTO(){
        
    }

    public LugarDTO(LugarEntity lugar) {
        this.idLugar = lugar.getId();
        this.nombreLugar = lugar.getNombre();
    }
    
    /**
      * Método para conversión de lista DTO a lista Entidades
      * @param lugarList
      * @return 
      */
    public static List<LugarDTO> toLugarList(List<LugarEntity> lugarList){
        List<LugarDTO> listaLugares = new ArrayList<>();
        for (int i = 0; i < lugarList.size(); i++) {
            listaLugares.add(new LugarDTO(lugarList.get(i)));
        }
        return listaLugares;
    }
    
    /**
     * Coversion DTO - Entity
     * @return LugarEntity
     */
    public LugarEntity toEntity(){
        LugarEntity lugarEntity = new LugarEntity();
        lugarEntity.setId(this.idLugar);
        lugarEntity.setNombre(this.nombreLugar);
        
        return lugarEntity;
    }

    /**
     * Getters
     */
    public Long getIdLugar() {
        return idLugar;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    /**
     * Setters
     */
    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }
}
