/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import exceptions.MetasException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

/**
 *
 * @author erikzubia
 */
public class MetaTest {
    
   @Test
    public void testProyecto() {
        
        //Se debe de probar la construccion correcta el proyecto
        Meta m = new Meta("1", "Descripcion", EPrioridad.ALTA);
        assertTrue(m!= null);
        
        //Se deben de poder agregar metas al proyecto si sus claves no estan duplicadas
        UserHistory u = new UserHistory("1", "Nombre", "Descripcion", new GenericUser("userName", "1234", "email@email.com"));
        try {
            m.addHistoria(u);
            assertTrue(m.getHistoriasByProyecto().size() ==1);
        } catch (MetasException.DuplicateClaveHistoriaByProyecto ex) {
            assertTrue(false);
        }
        
        //No debe de poder ser seguro borrar el proyecto si tienes metas dentro
        assertFalse(m.canDeleteMeta());
        
        try {
            //No se debe de borrar una meta si esta no existe dentro de las metas del proyecto
            UserHistory u2 = new UserHistory("2", "Nombre", "Desss", new GenericUser("user2", "4321", "email2@email.com"));
            m.removeHistoria(u2);
            assertTrue(m.getHistoriasByProyecto().size() ==1);
            //Se debe de poder sacar una meta dentro del proyecto
            m.removeHistoria(u);
            assertTrue(m.getHistoriasByProyecto().size()==0);
        } catch (MetasException.InvalidCantidadHistorias ex) {
            assertTrue(false);
        }
        
        //Debe de poder ser seguro borrar el proyecto si este no tiene ninguna meta dentro de el
        assertTrue(m.canDeleteMeta());
    }
    
}
