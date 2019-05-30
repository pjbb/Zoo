package co.edu.konradlorenz.zoo.entities;

import java.io.Serializable;
import java.sql.Time;
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
public class HorarioEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHorario;
    
    /**
     * Atributo dia
     */
    @JoinColumn(name = "dia")
    @ManyToOne
    private DiaEntity dia;

    /**
     * Atributo hora
     */
    @Column(name = "hora")
    private Time hora;
    
    /**
     * Constructor
     */
    public HorarioEntity() {
        
    }
    
    /**
     * getters
     */
    public Long getId() {
        return idHorario;
    }
    
    public DiaEntity getDia(){
        return dia;
    }
    
    public Time getHora(){
        return hora;
    }

    /**
     * setters
     */
    public void setId(Long idDia) {
        this.idHorario = idDia;
    }
    
    public void setDia(DiaEntity dia){
        this.dia = dia;
    }
    
    public void setHora(Time hora){
        this.hora = hora;
    }
    
}