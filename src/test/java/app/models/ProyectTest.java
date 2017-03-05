package app.models;

import exceptions.ProyectoException;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erikzubia
 */
public class ProyectTest {
    
    @Test
    public void testProyecto() {
        
        //Se debe de probar la construccion correcta el proyecto
        Proyect p = new Proyect("Proyecto de prueba", "Este es un proyecto creado por meritos de prueba", new Date());
        assertTrue(p!= null);
        
        //Se deben de poder agregar metas al proyecto si sus claves no estan duplicadas
        Meta m = new Meta("1", "Esta es una meta de prueba", EPrioridad.BAJA);
        try {
            p.addMeta(m);
            assertTrue(p.getMetasByProyecto().size() ==1);
        } catch (ProyectoException.DuplicateClaveMetaByProyecto ex) {
            assertTrue(false);
        }
        
        //No debe de poder ser seguro borrar el proyecto si tienes metas dentro
        assertFalse(p.canDeleteProyecto());
        
        try {
            //No se debe de borrar una meta si esta no existe dentro de las metas del proyecto
            Meta meta2 = new Meta("2", "Des", EPrioridad.ALTA);
            p.removeMeta(meta2);
            assertTrue(p.getMetasByProyecto().size()==1);
            //Se debe de poder sacar una meta dentro del proyecto
            p.removeMeta(m);
            assertTrue(p.getMetasByProyecto().size()==0);
        } catch (ProyectoException.InvalidCuatitiesMetas ex) {
            assertTrue(false);
        }
        
        //Debe de poder ser seguro borrar el proyecto si este no tiene ninguna meta dentro de el
        assertTrue(p.canDeleteProyecto());
    }
    
    /**
     * Debe de lanzar una excepción cuando se trata de agregar una {@link Meta}
     * con la misma clave que una que ya existe.
     * @throws exceptions.ProyectoException.DuplicateClaveMetaByProyecto 
     */
    @Test(expected=ProyectoException.DuplicateClaveMetaByProyecto.class)
    public void testDuplicateKeyInProyectoThrowsException() throws ProyectoException.DuplicateClaveMetaByProyecto{
        Proyect p = new Proyect("Proyecto de prueba", "Este es un proyecto creado por meritos de prueba", new Date());  
        Meta m = new Meta("1", "Esta es una meta de prueba", EPrioridad.BAJA);
        p.addMeta(m);
        p.addMeta(m);
    }
    
    /**
     * Debe de lanzar una excepción cuando se trata de eliminar una meta si no existen
     * metas a eliminar dentro del proyecto.
     * @throws exceptions.ProyectoException.InvalidCuatitiesMetas 
     */
    @Test(expected=ProyectoException.InvalidCuatitiesMetas.class)
    public void testEmptyMetasToRemoveProyectoThrowsException() throws ProyectoException.InvalidCuatitiesMetas{
        Proyect p = new Proyect("Proyecto de prueba", "Este es un proyecto creado por meritos de prueba", new Date());  
        p.removeMeta(new Meta("1", "Meta fallo", EPrioridad.ALTA));
    }
    
}
