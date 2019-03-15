package co.edu.konradlorenz.zoo.entities;

import java.io.Serializable;
import java.sql.Date;
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
public class PersonaEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroDocumento;
    
    /**
     * Atributo cargo
     */
    @JoinColumn(name = "cargo_persona")
    @ManyToOne
    private CargoEntity cargo;
    
    /**
     * Atributo tipo documento
     */
    @JoinColumn(name = "tipo_documento")
    @ManyToOne
    private TipoDocumentoEntity tipoDocumento;
    
    /**
     * Atributo nombre
     */
    @Column(name = "nombre_persona")
    private String nombre;
    
    /**
     * Atributo fecha nacimiento
     */
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    /**
     * Atributo teléfono
     */
    @Column(name = "telefono")
    private String telefono;

    /**
     * Constructor
     */
    public PersonaEntity() {
        
    }
    
    /**
     * getters
     */
    public Long getNumeroDocumento() {
        return numeroDocumento;
    }
    
    public CargoEntity getCargo(){
        return cargo;
    }
    
    public TipoDocumentoEntity getTipoDocumento(){
        return tipoDocumento;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Date getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    public String getTelefono(){
        return telefono;
    }

    /**
     * setters
     */
    public void setId(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    public void setCargo(CargoEntity cargo){
        this.cargo = cargo;
    }
    
    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
}
