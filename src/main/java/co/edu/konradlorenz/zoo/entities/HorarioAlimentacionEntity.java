package co.edu.konradlorenz.zoo.entities;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Definición Tabla Dia
 * @author Benitez Paula, Mejia Carlos
 */

@Entity
public class HorarioAlimentacionEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHorarioAlimentacion;
    
    /**
     * Atributo hora inicio
     */
    @Column(name = "hora_inicio")
    private Time horaInicio;
    
    /**
     * Atributo hora final
     */
    @Column(name = "hora_final")
    private Time horaFinal;

    /**
     * Constructor
     */
    public HorarioAlimentacionEntity() {
        
    }
    
    /**
     * getters
     */
    public Long getId() {
        return idHorarioAlimentacion;
    }
    
    public Time getHoraInicio(){
        return horaInicio;
    }
    
    public Time getHorarioFinal(){
        return horaFinal;
    }

    /**
     * setters
     */
    public void setId(Long idHorarioAlimentacion) {
        this.idHorarioAlimentacion = idHorarioAlimentacion;
    }
    
    public void setHoraInicio(Time hora){
        this.horaInicio = hora;
    }
    
    public void setHorarioFinal(Time hora){
        this.horaFinal = hora;
    }
    
}
