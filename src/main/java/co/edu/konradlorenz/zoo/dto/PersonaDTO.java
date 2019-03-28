package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.CargoEntity;
import co.edu.konradlorenz.zoo.entities.LugarEntity;
import co.edu.konradlorenz.zoo.entities.PersonaEntity;
import co.edu.konradlorenz.zoo.entities.TipoDocumentoEntity;
import java.sql.Date;
import javax.persistence.Column;

/**
 * DTO persona
 * @author pjbb
 */
public class PersonaDTO {
    /**
     * Atributo id
     */
    private Long numeroDocumento;
    
    /**
     * Atributo cargo
     */
    private CargoEntity cargo;
    
    /**
     * Atributo tipo de documento
     */
   private TipoDocumentoEntity tipoDocumento;
    
    /**
     * Atributo nombre
     */
    private String nombre;
    
    /**
     * Atributo fecha nacimiento
     */
    private Date fechaNacimiento;
    
    /**
     * Atributo teléfono
     */
    private String telefono;
    
    /**
     * Constructores
     */
    public PersonaDTO(){
        
    }

    public PersonaDTO(Long numeroDocumento, CargoEntity cargo, TipoDocumentoEntity tipoDocumento, String nombre, Date fechaNaicimiento, String telefono) {
        this.numeroDocumento = numeroDocumento;
        this.cargo = cargo;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNaicimiento;
        this.telefono = telefono;
    }
    
    /**
     * Coversion DTO - Entity
     * @return LugarEntity
     */
    public PersonaEntity toEntity(){
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(this.numeroDocumento);
        personaEntity.setNombre(this.nombre);
        return personaEntity;
    }

    /**
     * Getters
     */
    public Long getId() {
        return numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public CargoEntity getCargo() {
        return cargo;
    }

    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }
    
    

    /**
     * Setters
     */
    public void setId(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(CargoEntity cargo) {
        this.cargo = cargo;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}

