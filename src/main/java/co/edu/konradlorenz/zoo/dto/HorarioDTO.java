/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.DiaEntity;
import co.edu.konradlorenz.zoo.entities.HorarioEntity;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO horario
 * @author carlosmejia
 */
public class HorarioDTO {
    /**
     * Atributo id horario
     */
    private Long idHorario;
    
    /**
     * Atributi dia
     */
    private DiaEntity dia;
    
    /**
     * Atrubuto hora
     */
    private Time hora;
    
    /**
     * Constructores
     */
    public HorarioDTO(){
        
    }

    public HorarioDTO(HorarioEntity horario) {
        this.idHorario = horario.getId();
        this.dia = horario.getDia();
        this.hora = horario.getHora();
    }
    
    /**
     * Conversion DTO - Entity
     * @return HorarioEntity
     */
    public HorarioEntity toEntity(){
        HorarioEntity horarioEntity = new HorarioEntity();
        horarioEntity.setId(this.idHorario);
        horarioEntity.setDia(this.dia);
        horarioEntity.setHora(this.hora);
        
        return horarioEntity;
    }
    
    /**
      * Método para conversión de lista DTO a lista Entidades
      * @param horarioList
      * @return 
      */
    public static List<HorarioDTO> toHorarioList(List<HorarioEntity> horarioList){
        List<HorarioDTO> listaHorarios = new ArrayList<>();
        for (int i = 0; i < horarioList.size(); i++) {
            listaHorarios.add(new HorarioDTO(horarioList.get(i)));
        }
        return listaHorarios;
    }

    /**
     * Getters
     */
    public Long getIdHorario() {
        return idHorario;
    }

    public DiaEntity getDia() {
        return dia;
    }

    public Time getHora() {
        return hora;
    }

    /**
     * Setters
     */
    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public void setDia(DiaEntity dia) {
        this.dia = dia;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}
