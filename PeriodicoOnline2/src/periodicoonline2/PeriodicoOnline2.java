/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodicoonline2;

/**
 *
 * @author Juan A. García Muelas <juangmuelas@hotmail.com>
 */
public class PeriodicoOnline2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // una forma de hacer que arranque el formulario desde el main es haciendo una instancia a tu formulario
        
        Usuarios us = new Usuarios ();              // instancia a tu formulario, es como si crearas un objeto de esa clase.
        us.setVisible(true);                        // le decimos que sea visible la ventana poniendola a true
        
        
    }
    
}
