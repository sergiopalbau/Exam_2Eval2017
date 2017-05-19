/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodicoonline3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Your Name <Juan A. García Muelas (juangmuelas@hotmail.com)>
 */
public class myObjectOutputStream extends ObjectOutputStream {
    
    /** Constructor que recibe OutputStream
     * 
     * @param out
     * @throws IOException 
     */
    
    public myObjectOutputStream(OutputStream out)throws IOException{
        super();
    }
    
    /** Constructor sin parámetros
     * 
     * @throws IOException
     * @throws SecurityException 
     */
    
    protected myObjectOutputStream()throws IOException, SecurityException {
        super();
    }
    
    /** Redefinición del método de escribir la cabecera para que no haga nada.
     * 
     * @throws IOException 
     */
    // Idea tomada de http://www.chuidiang.org/java/ficehros/ObjetosFichero.php
    @Override
    
    protected void writeStreamHeader()throws IOException{
    }
    
}
