package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.AnimalEntity;
import co.edu.konradlorenz.zoo.entities.EvaluacionEntity;
import co.edu.konradlorenz.zoo.entities.HorarioEntity;
import co.edu.konradlorenz.zoo.entities.LugarEntity;
import co.edu.konradlorenz.zoo.entities.PersonaEntity;
import co.edu.konradlorenz.zoo.entities.ShowEntity;

/**
 *
 * @author pjbb
 */
public class ShowDTO {
    
    /**
     * Atributo id
     */
    private Long idShow;
    
    /**
     * Atributo animal
     */
    private AnimalEntity idAnimal;
    
    /**
     * Atributo horario
     */
    private HorarioEntity horario;
    
    /**
     * Atributo lugar
     */
    private LugarEntity lugar;
    
    /**
     * Atributo evalución
     */
    private EvaluacionEntity evaluacion;
    
    /**
     * Atributo encargado
     */
    private PersonaEntity encargado;
    
    /**
     * Atributo nombre del show
     */
    private String nombreShow;
    
     /**
      * Constructores
      */
    public ShowDTO(){
        
    }
    
    public ShowDTO(ShowEntity show){
        this.encargado = show.getEncargado();
        this.evaluacion = show.getEvaluacio();
        this.horario = show.getHorario();
        this.idAnimal = show.getIdAnimal();
        this.idShow = show.getIdSHow();
        this.lugar = show.getLugar();
        this.nombreShow = show.getNombreShow();
    }
}
