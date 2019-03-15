package co.edu.konradlorenz.zoo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Definición Tabla Dia
 * @author Benitez Paula, Mejia Carlos
 */

@Entity
public class TipoAnimalEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTipoAnimal;
    
    /**
     * Atributo nombreTipoAnimal
     */
    @Column(name = "nombre_tipo_animal")
    private String nombreTipoAnimal;
    
    /**
     * Atributo id horario alimentación
     */
    @JoinColumn(name = "horario_alimentacion")
    @ManyToOne
    private HorarioAlimentacionEntity idHorarioAlimentacion;

    /**
     * Constructor
     */
    public TipoAnimalEntity() {
        
    }
    
    /**
     * getters
     */
    public Long getId() {
        return idTipoAnimal;
    }
    
    public String getNombre(){
        return nombreTipoAnimal;
    }
    
    public HorarioAlimentacionEntity getHorarioAlimentacion(){
        return idHorarioAlimentacion;
    }

    /**
     * setters
     */
    public void setId(Long idTipoAnimal) {
        this.idTipoAnimal = idTipoAnimal;
    }
    
    public void setNombre(String nombre){
        this.nombreTipoAnimal = nombre;
    }
    
    public void setHorarioAlimentacion(HorarioAlimentacionEntity horarioAlimentacion){
        this.idHorarioAlimentacion = horarioAlimentacion;
    }
    
}