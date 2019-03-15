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
public class DiaEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDia;
    
    /**
     * Atributo nombreDia
     */
    @Column(name = "nombre_dia")
    private String nombreDia;

    /**
     * Constructor
     */
    public DiaEntity() {
        
    }
    
    /**
     * getters
     */
    public Long getId() {
        return idDia;
    }
    
    public String getNombre(){
        return nombreDia;
    }

    /**
     * setters
     */
    public void setId(Long idDia) {
        this.idDia = idDia;
    }
    
    public void setNombre(String nombre){
        this.nombreDia = nombre;
    }
    
}
