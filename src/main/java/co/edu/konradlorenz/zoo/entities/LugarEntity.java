package co.edu.konradlorenz.zoo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Definición Tabla Lugar
 * @author Benitez Paula, Mejia Carlos
 */

@Entity
public class LugarEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLugar;
    
    /**
     * Atributo nombre
     */
    @Column(name = "nombre_lugar")
    private String nombreLugar;

    /**
     * Constructor
     */
    public LugarEntity() {
        
    }
    
    /**
     * getters
     */
    public Long getId() {
        return idLugar;
    }
    
    public String getNombre(){
        return nombreLugar;
    }

    /**
     * setters
     */
    public void setId(Long idLugar) {
        this.idLugar = idLugar;
    }
    
    public void setNombre(String nombre){
        this.nombreLugar = nombre;
    }
    
}
