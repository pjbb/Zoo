package co.edu.konradlorenz.zoo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Definición Tabla Dia
 * @author Benitez Paula, Mejia Carlos
 */

@Entity
public class AnimalEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnimal;
    
    /**
     * Atributo evaluacion
     */
    @JoinColumn(name = "evaluacion")
    @OneToMany
    private EvaluacionEntity evaluacion;
    
    /**
     * Atributo cuidador
     */
    @JoinColumn(name = "numero_documento_cuidador")
    @ManyToOne
    private PersonaEntity cuidador;
    
    /**
     * Atributo tipo animal
     */
    @JoinColumn(name = "tipo_animal")
    @ManyToOne
    private TipoAnimalEntity tipoAnimal;
    
    /**
     * Atributo nombre
     */
    @Column(name = "nombre_animal")
    private String nombre;
    
    /**
     * Atributo numbre cientifico
     */
    @Column(name = "nombre_cientifico")
    private String nombreCientifico;
    
    /**
     * Atributo descripcion
     */
    @Column(name = "descripcion")
    private String descripcion;
    
    /**
     * Atributo especie
     */
    @Column(name = "especie")
    private String especie;

    /**
     * Constructor
     */
    public AnimalEntity() {
        
    }
    
    /**
     * getters
     */
    public Long getId() {
        return idAnimal;
    }
    
    public EvaluacionEntity getEvaluacion(){
        return evaluacion;
    }
    
    public PersonaEntity getCuidador(){
        return cuidador;
    }
    
    public TipoAnimalEntity getTipoAnimal(){
        return tipoAnimal;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getNombreCientifico(){
        return nombreCientifico;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getEspecie(){
        return especie;
    }

    /**
     * setters
     */
    public void setId(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setEvaluacion(EvaluacionEntity evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void setCuidador(PersonaEntity cuidador) {
        this.cuidador = cuidador;
    }

    public void setTipoAnimal(TipoAnimalEntity tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
}
