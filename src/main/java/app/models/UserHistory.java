package app.models;

/**
 *
 * @author erikzubia
 */
public class UserHistory {
    
    private String clave;
    private String nombre;
    private String descripcion;
    private GenericUser encargado;

    public UserHistory(String clave, String nombre, String descripcion, GenericUser encargado) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.encargado = encargado;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public GenericUser getEncargado() {
        return encargado;
    }

    public void setEncargado(GenericUser encargado) {
        this.encargado = encargado;
    }
       
}
