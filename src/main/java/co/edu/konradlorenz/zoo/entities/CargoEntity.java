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
public class CargoEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCargo;
    
    /**
     * Atributo nombreCargo
     */
    @Column(name = "nombre_cargo")
    private String nombreCargo;

    /**
     * Constructor
     */
    public CargoEntity() {
        
    }
    
    /**
     * getters
     */
    public Long getId() {
        return idCargo;
    }
    
    public String getNombre(){
        return nombreCargo;
    }

    /**
     * setters
     */
    public void setId(Long idCargo) {
        this.idCargo = idCargo;
    }
    
    public void setNombre(String nombre){
        this.nombreCargo = nombre;
    }
    
}