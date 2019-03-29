package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.CargoEntity;
import co.edu.konradlorenz.zoo.entities.LugarEntity;
import co.edu.konradlorenz.zoo.entities.PersonaEntity;
import co.edu.konradlorenz.zoo.entities.TipoDocumentoEntity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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

    public PersonaDTO(PersonaEntity persona) {
        this.numeroDocumento = persona.getNumeroDocumento();
        this.cargo = persona.getCargo();
        this.tipoDocumento = persona.getTipoDocumento();
        this.nombre = persona.getNombre();
        this.fechaNacimiento = persona.getFechaNacimiento();
        this.telefono = persona.getTelefono();
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
      * Método para conversión de lista DTO a lista Entidades
      * @param personaList
      * @return 
      */
    public static List<PersonaDTO> toPersonaList(List<PersonaEntity> personaList){
        List<PersonaDTO> listaProductos = new ArrayList<>();
        for (int i = 0; i < personaList.size(); i++) {
            listaProductos.add(new PersonaDTO(personaList.get(i)));
        }
        return listaProductos;
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

