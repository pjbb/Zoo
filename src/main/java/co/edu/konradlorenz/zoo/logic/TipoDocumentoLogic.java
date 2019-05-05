package co.edu.konradlorenz.zoo.logic;

import co.edu.konradlorenz.zoo.entities.TipoDocumentoEntity;
import co.edu.konradlorenz.zoo.persistence.TipoDocumentoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic Tipo Animal
 * @author pjbb
 */

@Stateless
public class TipoDocumentoLogic {
    @Inject
    private TipoDocumentoPersistence persistence;
    
    /**
     * Metodo para obtener lista de los TipoDocumento
     * @return ListDocumento
     */
    public List<TipoDocumentoEntity> obtenerTipoDocumento(){
        List<TipoDocumentoEntity> tipoDocumento = persistence.findall();
        return tipoDocumento;
    }
    
    /**
     * Metodo para obtener un TipoDocumento
     * @param id
     * @return TipoDocumento obtenido
     */
    public TipoDocumentoEntity obtenerTipoDocumentoPorId(Long id){
        TipoDocumentoEntity tipoDocumento = persistence.find(id);
        
        if(tipoDocumento == null){
            throw new IllegalArgumentException("El tipo de documento no existe.");
        }
        
        return tipoDocumento;
    }
    
    /**
     * Metodo para crear un TipoDocumento
     * @param entity
     * @return TipoDocumento creado
     */
    public TipoDocumentoEntity crearTipoDocumento(TipoDocumentoEntity entity){
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Metodo para actualizar un TipoDocumento
     * @param entity
     * @param id
     * @return TipoDocumento actualizado
     */
    public TipoDocumentoEntity actualizarTipoDocumento(TipoDocumentoEntity entity, Long id){
        TipoDocumentoEntity tipoDocumento = persistence.update(entity);
        return tipoDocumento;
    }
    
    /**
     * Metodo para eliminar un TipoDocumento
     * @param id 
     */
    public void eliminarTipoDocumento(Long id){
        persistence.delete(id);
    }
}
