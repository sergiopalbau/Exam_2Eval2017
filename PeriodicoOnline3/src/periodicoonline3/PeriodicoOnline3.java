/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodicoonline3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Juan A. García Muelas <juangmuelas@hotmail.com>
 */
public class PeriodicoOnline3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        // diseñamos el menú, mostrando las opciones para elegir.
    char opción;
    Scanner teclado=new Scanner(System.in);
    //dependiendo de la letra escogida, se invoca un método. 
    // para leer la letra usamos next().charAt(0), que lee la letra y se queda 
    //con el caracter que ocupa la posición cero (el primero).
    //Incluimos un bucle para ejecutar las accciones, más de una vez.
    do{
            System.out.println("Menú Anunciante.");
            System.out.println("Para añadir un anunciante, pulsa A o a.");
            System.out.println("Para buscar un anunciante, pulsa B o b.");
            System.out.println("Para calcular ingresos totales, pulsa T o t.");
            System.out.println("Para salir, pulsa S o s.");
            opción=teclado.next().charAt(0);
            switch(opción){
                case'A':case'a'://añadir anunciantes
                    añadirAnunciante();break;
                case'B':case'b'://buscar anunciantes
                    buscarAnunciante();break;
                case'T':case't'://ingresos Totales
                    totalAnunciante();break;    
                case'S':case's'://salir
                   System.out.println("Saliendo del programa");break;
                default:
                    System.out.println("Opción incorrecta.");break;
            
            }
    
    
    }while(opción !='S'&& opción !='s');
}
    //creamos los métodos del switch.
    public static void añadirAnunciante() throws IOException{
        //creamos las variables.
        String email, contraseña;
        int numAnuncios=0;
        double descuento=0;
        boolean correcto=true;//por si hay errores.
        
        //Creamos el flujo de fichero
        ObjectOutputStream salida= null;
        
        // pedir datos.
        
        Scanner teclado= new Scanner(System.in);
        System.out.println("Nuevo Anunciante");
        System.out.println("IDENTIFICADOR(email)");
        email= teclado.nextLine();
        
        System.out.println("Contraseña: ");
        contraseña=teclado.nextLine();
        System.out.println("Anuncios: ");
        //Para capturar la excepción de no insertar un entero, usamos InputMismatchException.
        try {
            numAnuncios=teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Introduzca el número de anuncios como entero.");
            
            correcto=false;
        }
        
        //comprobar email antes de guardar el fichero.
        
        if (!Pattern.matches("([\\w-]+\\.)*?[\\w-]+@[\\w-]+\\.([\\w-]+\\.)*?[\\w]+$", email)){
            System.out.println("El formato del email no es el correcto.");
            correcto=false;
            
        } else {
            if (correcto) {
                //creamos un nuevo objeto de tipo fichero con esos datos.
                System.out.println("Guardando datos");
                
                try {
                    Anunciante1 a=new Anunciante1(email, contraseña, descuento, numAnuncios);
                    File fichero=new File("anunciantes");
                    
                    if (!fichero.exists()) {
                        //se crea ael fichero puesto que aún no existe.
                        salida= new ObjectOutputStream(new FileOutputStream("anunciantes"));
                        
                    } else {
                        //se añade sin que sobreescriba registros.
                        salida= new myObjectOutputStream(new FileOutputStream("anunciantes", true));     
                    }
                    
                    //Añadimos los datos al fichero.
                    
                    salida.writeObject(a);
                    salida.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Fichero no encontrado");
                }catch(IOException e){
                    System.out.println("Fichero con errores");
                
                if(salida!=null)
                    salida.close();}
            } else {
                System.out.println("No se añadió el anunciante al fichero.");
            }
        }   
    
    }
   
    public static void buscarAnunciante() throws IOException {
        
        //variables
        String email;
        Scanner teclado= new Scanner(System.in);
        boolean encontrado=false; 
        
        ObjectInputStream entrada=null;
        
        
        //Anunciante a buscar
        System.out.println(" Introduzca el email del anunciante a buscar:");
        email=teclado.nextLine();
        
        try {
            entrada=new ObjectInputStream(new FileInputStream("anunciantes"));
            // casteamos el flujo de bytes para pasarlo al objeto anunciante.
            Anunciante1 a=(Anunciante1)entrada.readObject();
            
            //cada alumno que leamos se compara su atributo dni con la búsqueda con equalsIgnoreCase.
            while(a!=null&&!encontrado){
                if(a.getEmail().equalsIgnoreCase(email)){
                    encontrado=true;
                    System.out.println(a.getEmail()+"-"+a.getContraseña()+"-"+a.getDescuento());
                }
                a=(Anunciante1)entrada.readObject();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
            if(entrada!=null)
                    entrada.close();
        }catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada.");
            if(entrada!=null)
                    entrada.close();
        }if(!encontrado)
                   System.out.println("No se encuentra el alumno con el email: "+email);
    }
    
     public static void totalAnunciante() throws IOException {
        ObjectInputStream entrada=null;
        
         try {
             entrada= new ObjectInputStream(new FileInputStream("anunciantes"));
             Anunciante1 a= (Anunciante1)entrada.readObject();
             while(a!=null){
                 System.out.println(a.getEmail()+"-"+a.getContraseña()+"-"+ a.getDescuento());
                 a=(Anunciante1)entrada.readObject();
                 
                double totalAnunciante=(60.3-a.getDescuento())* a.getNumAnuncios();
                System.out.println("Ingresos totales del anunciante: "+a.getEmail()+" = "+ totalAnunciante);
             
             }
         } catch (FileNotFoundException e) {
             System.out.println("Fichero no encontrado");
             if(entrada!=null)
                    entrada.close();
         } catch (ClassNotFoundException ex) {
             System.out.println("Clase no encontrada");
             if(entrada!=null)
                    entrada.close();
         }catch (IOException e) {
             System.out.println("Final del fichero");
             if(entrada!=null)
                    entrada.close();
         }
    }
        
    
    
}
