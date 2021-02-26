
package es.peliculas.presentacion;

import ExcepcionesCatalogoPeliculas.EscrituraDatosEx;
import es.peliculas.negocio.CatalogoPeliculasImpl;
import es.peliculas.negocio.ICatalogoPeliculas;
import java.util.Scanner;

public class CataloloPeliclasPresentacion {
    
    
    public static void main(String[] args) throws EscrituraDatosEx {
        
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        //final ICatalogoPeliculas catalogoPeliculas;
        //catalogoPeliculas = new CatalogoPeliculasImpl();
        final ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
        final String nombreArchivo = CatalogoPeliculasImpl.NOMBRE_RECURSO;
        
        
        do {
            String Pelicula;
            System.out.println("1.Iniciar Catalogo Pelicuas");
            System.out.println("2.Agregar Película");
            System.out.println("3.Listar Peliculas");
            System.out.println("4.Buscar Película");
            System.out.println("0. Salir");
            System.out.println("Introduzca una opción:");
            opcion = Integer.parseInt(sc.nextLine());
            
        
            switch (opcion){

                case 1:
                    catalogoPeliculas.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    //sc.nextLine();
                    System.out.println("Indroduce nombre de la Pelicula");
                    String pelicula = sc.nextLine();
                    
                    catalogoPeliculas.agregarPelicula(pelicula, nombreArchivo);
                    
                    break;

                case 3:
                    catalogoPeliculas.listarPeliculas();
                    break;
                case 4:
                    //sc.nextLine();
                    System.out.println("Introduzca pelicula a buscar");
                    String peliculaBuscar =sc.nextLine();
                    catalogoPeliculas.buscarPelicula(peliculaBuscar);
                    break;

                case 0:
                    System.out.println("Bye");
                    break;
                    
                default:
                    System.out.println("Opcion incorrecta");
                    
           
            }
        } while (opcion !=0);
        
                
    }
}
