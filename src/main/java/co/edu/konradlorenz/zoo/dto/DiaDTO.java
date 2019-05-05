package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.DiaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO dia
 * @author carlosmejia
 */
public class DiaDTO {
    
    /**
     * Atributo idDia
     */
    private Long idDia;
    
    /**
     * Atributo nombre dia
     */
    private String nombreDia;
    
    /**
     * Constructores
     */
    public DiaDTO(){
        
    }

    public DiaDTO(DiaEntity dia) {
        this.idDia = dia.getId();
        this.nombreDia = dia.getNombre();
    }
    
    /**
     * Conversión DTO - Entity
     * @return ProductoEntity
     */
    public DiaEntity toEntity(){
        DiaEntity diaEntity = new DiaEntity();
        diaEntity.setId(this.idDia);
        diaEntity.setNombre(this.nombreDia);
        return diaEntity;
    }
    
    /**
      * Método para conversión de lista DTO a lista Entidades
      * @param diaList
      * @return 
      */
    public static List<DiaDTO> toDiaList(List<DiaEntity> diaList){
        List<DiaDTO> listaDias = new ArrayList<>();
        for (int i = 0; i < diaList.size(); i++) {
            listaDias.add(new DiaDTO(diaList.get(i)));
        }
        return listaDias;
    }
    
    /**
     * Getters
     */
    public Long getIdDia() {
        return idDia;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    /**
     * Setters
     */
    public void setIdDia(Long idDia) {
        this.idDia = idDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }
}
