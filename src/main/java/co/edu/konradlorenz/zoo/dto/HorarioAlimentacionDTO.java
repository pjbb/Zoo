/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.HorarioAlimentacionEntity;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO Horario Alimentacion
 * @author carlosmejia
 */
public class HorarioAlimentacionDTO {
    /**
     * Atributo id horario alimentacion
     */
    private Long idHorarioAlimentacion;
    
    /**
     * Atributo hora inicio
     */
    private Time horaInicio;
    
    /**
     * Atributo hora final
     */
    private Time horaFinal;
    
    /**
     * Constructores
     */
    public HorarioAlimentacionDTO(){
        
    }

    public HorarioAlimentacionDTO(HorarioAlimentacionEntity horarioAlimentacion) {
        this.idHorarioAlimentacion = horarioAlimentacion.getId();
        this.horaInicio = horarioAlimentacion.getHoraInicio();
        this.horaFinal = horarioAlimentacion.getHorarioFinal();
    }
    
    /**
      * Método para conversión de lista DTO a lista Entidades
      * @param horarioAlimentacionList
      * @return 
      */
    public static List<HorarioAlimentacionDTO> toHorarioAlimentacionList(List<HorarioAlimentacionEntity> horarioAlimentacionList){
        List<HorarioAlimentacionDTO> listaHorariosAlimentacion = new ArrayList<>();
        for (int i = 0; i < horarioAlimentacionList.size(); i++) {
            listaHorariosAlimentacion.add(new HorarioAlimentacionDTO(horarioAlimentacionList.get(i)));
        }
        return listaHorariosAlimentacion;
    }
    
    
    /**
     * Conversion DTO - Entity
     * @return 
     */
    public HorarioAlimentacionEntity toEntity(){
        HorarioAlimentacionEntity horarioAlimentacionEntity = new HorarioAlimentacionEntity();
        horarioAlimentacionEntity.setId(this.idHorarioAlimentacion);
        horarioAlimentacionEntity.setHoraInicio(this.horaInicio);
        horarioAlimentacionEntity.setHorarioFinal(this.horaFinal);
        
        return horarioAlimentacionEntity;
    }

    /**
     * Getters
     */
    public Long getIdHorarioAlimentacion() {
        return idHorarioAlimentacion;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    /**
     * Setters
     */
    public void setIdHorarioAlimentacion(Long idHorarioAlimentacion) {
        this.idHorarioAlimentacion = idHorarioAlimentacion;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }
}
