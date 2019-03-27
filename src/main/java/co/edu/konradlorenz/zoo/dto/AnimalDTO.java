package co.edu.konradlorenz.zoo.dto;


import co.edu.konradlorenz.zoo.entities.AnimalEntity;
import co.edu.konradlorenz.zoo.entities.EvaluacionEntity;
import co.edu.konradlorenz.zoo.entities.PersonaEntity;
import co.edu.konradlorenz.zoo.entities.TipoAnimalEntity;

/**
 * DTO Animal
 * @author pjbb
 */
public class AnimalDTO {
    
    /**
     * Llave primaria
     */
    private Long idAnimal;
    
    /**
     * Atributo evaluacion
     */
    private EvaluacionEntity evaluacion;
    
    /**
     * Atributo cuidador
     */
    private PersonaEntity cuidador;
    
    /**
     * Atributo tipo animal
     */
    private TipoAnimalEntity tipoAnimal;
    
    /**
     * Atributo nombre
     */
    private String nombre;
    
    /**
     * Atributo numbre cientifico
     */
    private String nombreCientifico;
    
    /**
     * Atributo descripcion
     */
    private String descripcion;
    
    /**
     * Atributo especie
     */
    private String especie;

    /**
     * Constructores
     */
    public AnimalDTO(){
        
    }
    
    public AnimalDTO(AnimalEntity animal){
        this.idAnimal = animal.getId();
        this.evaluacion = animal.getEvaluacion();
        this.cuidador = animal.getCuidador();
        this.tipoAnimal = animal.getTipoAnimal();
        this.nombre = animal.getNombre();
        this.nombreCientifico = animal.getNombreCientifico();
        this.descripcion = animal.getDescripcion();
        this.especie = animal.getEspecie();
    }
    
    /**
     * Conversión DTO - Entity
     * @return AnimalEntity
     */
    public AnimalEntity toEntity(){
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setId(this.idAnimal);
        animalEntity.setEvaluacion(this.evaluacion);
        animalEntity.setCuidador(this.cuidador);
        animalEntity.setTipoAnimal(this.tipoAnimal);
        animalEntity.setNombre(this.nombre);
        animalEntity.setNombreCientifico(this.nombreCientifico);
        animalEntity.setDescripcion(this.descripcion);
        animalEntity.setEspecie(this.especie);
        return animalEntity;
    }
    
    /**
     * Getters
     */
    public Long getId() {
        return idAnimal;
    }

    public EvaluacionEntity getEvaluacion(){
        return evaluacion;
    }

    public PersonaEntity getCuidador() {
        return cuidador;
    }

    public TipoAnimalEntity getTipoAnimal() {
        return tipoAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEspecie() {
        return especie;
    }

    /**
     * Setters 
     */
    public void setId(Long id) {
        this.idAnimal = id;
    }

    public void setEvaluacion(EvaluacionEntity evaluacion){
        this.evaluacion = evaluacion;
    }

    public void setCuidador(PersonaEntity cuidador) {
        this.cuidador = cuidador;
    }

    public void setTipoAnimal(TipoAnimalEntity tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
}