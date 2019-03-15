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
public class TipoDocumentoEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTipoDocumento;
    
    /**
     * Atributo nombreTipoDocumento
     */
    @Column(name = "nombre_tipo_documento")
    private String nombreTipoDocumento;

    /**
     * Constructor
     */
    public TipoDocumentoEntity() {
        
    }
    
    /**
     * getters
     */
    public Long getId() {
        return idTipoDocumento;
    }
    
    public String getNombre(){
        return nombreTipoDocumento;
    }

    /**
     * setters
     */
    public void setId(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
    
    public void setNombre(String nombre){
        this.nombreTipoDocumento = nombre;
    }
    
}