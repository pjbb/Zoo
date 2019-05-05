package co.edu.konradlorenz.zoo.dto;

import co.edu.konradlorenz.zoo.entities.TipoDocumentoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlosmejia
 */
public class TipoDocumentoDTO {
    /**
     * Atributo Id
     */
    private Long idTipoDocumento;
    
    /**
     * Atributo nombreTipoDocumento
     */
    private String nombreTipoDocumento;
    
    /**
     * Constructores
     */
    public TipoDocumentoDTO(){
        
    }
    
    public TipoDocumentoDTO(TipoDocumentoEntity tipoDocumento){
        this.idTipoDocumento = tipoDocumento.getId();
        this.nombreTipoDocumento = tipoDocumento.getNombre();
    }
    
    /**
     * Conversion DTO - Entity
     * @return tipoDocumentoEntity
     */
    public TipoDocumentoEntity toEntity(){
        TipoDocumentoEntity tipoDocumentoEntity = new TipoDocumentoEntity();
        tipoDocumentoEntity.setId(this.idTipoDocumento);
        tipoDocumentoEntity.setNombre(this.nombreTipoDocumento);
        
        return tipoDocumentoEntity;
    }
    
    /**
     * Metodo de Conversion de Lista DTO a Lista Entity
     * @param tipoDocumentoList
     * @return listaTipoDoumento
     */
    public List<TipoDocumentoDTO> toTipoDocumentoList(List<TipoDocumentoEntity> tipoDocumentoList){
        List<TipoDocumentoDTO> listaTipoDocumento = new ArrayList<>();
        for(int i = 0; i < tipoDocumentoList.size(); i++){
            listaTipoDocumento.add(new TipoDocumentoDTO(tipoDocumentoList.get(i)));
        }
        return listaTipoDocumento;
    }

    /**
     * Getters
     */
    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public String getNombreTipoDocumento() {
        return nombreTipoDocumento;
    }

    /**
     * Setters
     */
    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }
}
