package app.models;

import exceptions.MetasException;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo que personifica una meta que se tiene dentro de un proyecto.
 * 
 * @since 04/Marzo/2017
 * @author Erik David Zubia Hernández
 */
public class Meta {
    
    private String claveMeta;
    private String descripcionMeta;
    private EPrioridad prioridad;
    private List<UserHistory> historias = new ArrayList<>();

    public Meta(String claveMeta, String descripcionMeta, EPrioridad prioridad) {
        this.claveMeta = claveMeta;
        this.descripcionMeta = descripcionMeta;
        this.prioridad = prioridad;
    }

    
    
    public String getClaveMeta() {
        return claveMeta;
    }

    public void setClaveMeta(String claveMeta) {
        this.claveMeta = claveMeta;
    }

    public String getDescripcionMeta() {
        return descripcionMeta;
    }

    public void setDescripcionMeta(String descripcionMeta) {
        this.descripcionMeta = descripcionMeta;
    }

    public EPrioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(EPrioridad prioridad) {
        this.prioridad = prioridad;
    }
    
    
    public List<UserHistory> getHistoriasByProyecto(){
        return this.historias;
    }
    
    public Boolean addHistoria(UserHistory u) throws MetasException.DuplicateClaveHistoriaByProyecto{             
        if (this.historias != null && (this.historias.stream().allMatch(h-> !h.getClave().equals(u.getClave())) || this.historias.isEmpty())) {
            return this.historias.add(u);
        } else {
            throw new MetasException.DuplicateClaveHistoriaByProyecto("No se permiten claves repetidas en las historias de la meta");
        }
    }
    
    public Boolean removeHistoria(UserHistory u) throws MetasException.InvalidCantidadHistorias{
        if(this.historias == null || this.historias.isEmpty()) throw new MetasException.InvalidCantidadHistorias("No extisten historias por remover");      
        return this.historias.remove(u);
       
    }
    
    public Boolean canDeleteMeta(){
        if(this.historias == null) return true;
        if(this.historias.isEmpty()) return true;
        return false;
    }
    
}
