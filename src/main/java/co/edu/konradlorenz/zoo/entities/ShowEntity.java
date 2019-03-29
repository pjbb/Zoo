package co.edu.konradlorenz.zoo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Definición Tabla Dia
 * @author Benitez Paula, Mejia Carlos
 */

@Entity
public class ShowEntity implements Serializable{

    /**
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSHow;
    
    /**
     * Atributo Animal
     */
    @JoinColumn(name = "animal")
    @ManyToMany
    private AnimalEntity idAnimal;
    
    /**
     * Atributo Horario
     */
    @Id
    @JoinColumn(name = "horario")
    @OneToMany
    private HorarioEntity horario;
    
    /**
     * Artibuto Lugar
     */
    @Id
    @JoinColumn(name = "lugar")
    @ManyToOne
    private LugarEntity lugar;
    
    /**
     * Atributo Encargado
     */
    @Id
    @JoinColumn(name = "numero_documento_encargado")
    @ManyToOne
    private PersonaEntity encargado;
    
    /**
     * Atributo Evaluacion
     */
    @Id
    @JoinColumn(name = "evaluacion")
    @ManyToOne
    private EvaluacionEntity evaluacion;
    
    /**
     * Atributo Nombre
     */
    @Column(name = "nombre_show")
    private String nombreShow;

    /**
     * Constructor
     */
    public ShowEntity() {
    }
    
    /**
     * getters
     */
    public Long getIdSHow() {
        return idSHow;
    }

    public AnimalEntity getIdAnimal() {
        return idAnimal;
    }

    public HorarioEntity getHorario() {
        return horario;
    }

    public LugarEntity getLugar() {
        return lugar;
    }

    public PersonaEntity getEncargado() {
        return encargado;
    }

    public EvaluacionEntity getEvaluacio() {
        return evaluacion;
    }

    /**
     * setters
     */
    public String getNombreShow() {    
        return nombreShow;
    }

    public void setIdSHow(Long idSHow) {
        this.idSHow = idSHow;
    }

    public void setIdAnimal(AnimalEntity idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setHorario(HorarioEntity horario) {
        this.horario = horario;
    }

    public void setLugar(LugarEntity lugar) {
        this.lugar = lugar;
    }

    public void setEncargado(PersonaEntity encargado) {
        this.encargado = encargado;
    }

    public void setEvaluacio(EvaluacionEntity evaluacio) {
        this.evaluacion = evaluacio;
    }

    public void setNombreShow(String nombreShow) {
        this.nombreShow = nombreShow;
    }
}