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
public class MetaMockitoTest {
    
    private static Meta mockedMeta;
    private static UserHistory historia;
    private static UserHistory historia2;

    @BeforeClass
    public static void setUp(){
      //Create mock object of BookDAL
      mockedMeta = mock(Meta.class);
      historia = new UserHistory("1", "Nombre", "Descripcion", new GenericUser("testUser", "1234", "email@email.com"));     
      historia = new UserHistory("2", "Nombre", "Descripcion", new GenericUser("testUser", "1234", "email@email.com"));
    }
    
    /**
     * Test of addHistoria method, of class Meta.
     */
    @Test(expected = MetasException.DuplicateClaveHistoriaByProyecto.class)
    public void testThrowExceptionsWhenDuplicateKeyHistoria() throws Exception {
        Mockito.when(mockedMeta.addHistoria(Mockito.any())).thenReturn(true).thenCallRealMethod();
        mockedMeta.addHistoria(historia);
        mockedMeta.addHistoria(historia);
        Mockito.verify(mockedMeta, Mockito.times(2)).addHistoria(historia);
    }
    
    /**
     * Test of addHistoria method, of class Meta.
     */
    @Test(expected = MetasException.InvalidCantidadHistorias.class)
    public void testThrowExceptionsWhenRemoveHistoria() throws Exception {
        Mockito.when(mockedMeta.removeHistoria(Mockito.any())).thenReturn(true).thenCallRealMethod();
        mockedMeta.removeHistoria(historia);
        mockedMeta.removeHistoria(historia);
        Mockito.verify(mockedMeta, Mockito.times(2)).removeHistoria(historia);
    }
    
}
