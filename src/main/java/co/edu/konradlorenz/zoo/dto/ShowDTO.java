package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.AnimalEntity;
import co.edu.konradlorenz.zoo.entities.EvaluacionEntity;
import co.edu.konradlorenz.zoo.entities.HorarioEntity;
import co.edu.konradlorenz.zoo.entities.LugarEntity;
import co.edu.konradlorenz.zoo.entities.PersonaEntity;
import co.edu.konradlorenz.zoo.entities.ShowEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO Show
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

    /**
     * Conversion DTO - Entity
     * @return showEntity
     */
    public ShowEntity toEntity(){
        ShowEntity showEntity = new ShowEntity();
        showEntity.setIdSHow(this.idShow);
        showEntity.setIdAnimal(this.idAnimal);
        showEntity.setHorario(this.horario);
        showEntity.setLugar(this.lugar);
        showEntity.setEvaluacio(this.evaluacion);
        showEntity.setEncargado(this.encargado);
        showEntity.setNombreShow(this.nombreShow);
        
        return showEntity;
    }
    /**
      * Método para conversión de lista DTO a lista Entidades
      * @param showList
      * @return 
      */
    public static List<ShowDTO> toShowList(List<ShowEntity> showList){
        List<ShowDTO> listaShows = new ArrayList<>();
        for (int i = 0; i < showList.size(); i++) {
            listaShows.add(new ShowDTO(showList.get(i)));
        }
        return listaShows;
    }
    /**
     * Getters
     */
    public Long getIdShow() {
        return idShow;
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

    public EvaluacionEntity getEvaluacion() {
        return evaluacion;
    }

    public PersonaEntity getEncargado() {
        return encargado;
    }

    public String getNombreShow() {
        return nombreShow;
    }

    /**
     * Setters
     */
    public void setIdShow(Long idShow) {
        this.idShow = idShow;
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

    public void setEvaluacion(EvaluacionEntity evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void setEncargado(PersonaEntity encargado) {
        this.encargado = encargado;
    }

    public void setNombreShow(String nombreShow) {
        this.nombreShow = nombreShow;
    }       
}
