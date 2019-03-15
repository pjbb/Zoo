package co.edu.konradlorenz.zoo.entities;

import java.io.Serializable;
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
public class EvaluacionEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEvaluacion;
    
    /**
     * Atributo valor
     */
    @Column(name = "valor")
    private int valor;
    
    /**
     * Atributo observación
     */
    @Column(name = "observacion")
    private String observacion;

    /**
     * Constructor
     */
    public EvaluacionEntity() {
        
    }
    
    /**
     * getters
     */
    public Long getId() {
        return idEvaluacion;
    }
    
    public int getValor(){
        return valor;
    }
    
    public String getObservacion(){
        return observacion;
    }

    /**
     * setters
     */
    public void setId(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    
    public void setValor(int valor){
        this.valor = valor;
    }
    
    public void setObservacion(String observacion){
        this.observacion = observacion;
    }
    
}