/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.DiaEntity;

/**
 * DTO dia
 * @author carlosmejia
 */
public class DiaDTO {
    
    /**
     * Atributo id Dia
     */
    private Long idDia;
    
    /**
     * Atributo nombre dia
     */
    private String nombreDia;
    
    /**
     * Constructores
     */
    public DiaDTO(){
        
    }

    public DiaDTO(Long idDia, String nombreDia) {
        this.idDia = idDia;
        this.nombreDia = nombreDia;
    }
    
    /**
     * Conversion DTO - Entity
     * @return DiaEntity
     */
    public DiaEntity toEntity(){
        DiaEntity diaEntity = new DiaEntity();
        diaEntity.setId(this.idDia);
        diaEntity.setNombre(this.nombreDia);
        
        return diaEntity;
    }
    
    /**
     * Getters
     */
    public Long getIdDia() {
        return idDia;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    /**
     * Setters
     */
    public void setIdDia(Long idDia) {
        this.idDia = idDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }
}
