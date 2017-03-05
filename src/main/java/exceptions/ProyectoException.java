/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;


public class ProyectoException extends Exception {

        public ProyectoException(String message) {
            super(message);
        }

    public static class InvalidCuatitiesMetas extends ProyectoException {

        public InvalidCuatitiesMetas(String message) {
            super(message);
        }
    }

    public static class DuplicateClaveMetaByProyecto extends ProyectoException {

        public DuplicateClaveMetaByProyecto(String message) {
            super(message);
        }
    }
        
        

    }
