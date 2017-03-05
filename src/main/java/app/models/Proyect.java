package app.models;

import exceptions.ProyectoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Modelo que personifica un Proyecto real que se quiera hacer.
 * 
 * @since 04/Marzo/2017
 * @author Erik David Zubia Hernández
 */
public class Proyect {
    
    private String clave;
    private String name;
    private String description;
    private Date initialDate;
    private Date finishDate;
    private Boolean isActive;
    private List<Meta> metas;

    /**
     * 
     * @param name
     * @param description
     * @param initialDate
     * @param finishDate
     * @param isActive 
     */
    public Proyect(String name, String description, Date initialDate, Date finishDate, Boolean isActive) {
        this.name = name;
        this.description = description;
        this.initialDate = initialDate;
        this.finishDate = finishDate;
        this.isActive = isActive;
        this.metas = new ArrayList<>();
    }

    /**
     * 
     * @param name
     * @param description
     * @param finishDate 
     */
    public Proyect(String name, String description, Date finishDate) {
        this.name = name;
        this.description = description;
        this.finishDate = finishDate;
        this.initialDate = new Date();
        this.isActive = true;
        this.metas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public List<Meta> getMetasByProyecto(){
        return this.metas;
    }
    
    public Boolean addMeta(Meta m) throws ProyectoException.DuplicateClaveMetaByProyecto{       
        if(this.metas.stream().allMatch(me-> !me.getClaveMeta().equals(m.getClaveMeta())) || this.metas.isEmpty()){
            return this.metas.add(m);
        } else {
            throw new ProyectoException.DuplicateClaveMetaByProyecto("No se permiten metas con claves duplicadas");
        } 
        
    }
    
    public Boolean removeMeta(Meta m) throws ProyectoException.InvalidCuatitiesMetas{
        if(this.metas == null || this.metas.isEmpty()) throw new ProyectoException.InvalidCuatitiesMetas("No extisten mentas por agregar");
        Optional<Meta> metaToDelete = this.metas.stream().filter(me-> me.getClaveMeta().equals(m.getClaveMeta())).findFirst();
        if(metaToDelete.isPresent() && metaToDelete.get().canDeleteMeta()) return this.metas.remove(m);
        return false;
    }
    
    public Boolean canDeleteProyecto(){
        if(this.metas == null) return true;
        if(this.metas.isEmpty()) return true;
        return false;
    }
    
}

