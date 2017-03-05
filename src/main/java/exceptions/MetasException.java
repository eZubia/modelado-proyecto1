/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;


public class MetasException extends Exception {

        public MetasException(String message) {
            super(message);
        }

    public static class InvalidCantidadHistorias extends MetasException {

        public InvalidCantidadHistorias(String message) {
            super(message);
        }
    }

    public static class DuplicateClaveHistoriaByProyecto extends MetasException {

        public DuplicateClaveHistoriaByProyecto(String message) {
            super(message);
        }
    }
        
        

    }
