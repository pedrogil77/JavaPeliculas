
package es.peliculas.negocio;

import ExcepcionesCatalogoPeliculas.*;
import es.peliculas.datos.AccesoDatosImpl;
import es.peliculas.domain.Pelicula;
import es.peliculas.datos.IAccesoDatos;


public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
    
    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }
        
    

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreRecurso) throws EscrituraDatosEx{
        
        try {
            Pelicula pelicula = new Pelicula(nombrePelicula);
            boolean anexar;
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
            
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");    
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas() {
        
        try {
            
            var  peliculas = datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                
                System.out.println("pelicula = " + pelicula);
                
            }            
        } catch (LecturaDatosEx ex) {
            
            System.out.println("No se pueden listar peliculas");
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        
        try {
            String resultado = null;
            resultado = datos.buscar(NOMBRE_RECURSO, buscar);
            System.out.println("resultado = " + resultado);
            
            
        } catch (LecturaDatosEx ex) {
            
            System.out.println("Error al buscar pelicula");
            ex.printStackTrace();
        }
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                
                this.datos.borrar(NOMBRE_RECURSO);
                this.datos.crear(NOMBRE_RECURSO);
            }
            
            else{
                this.datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            
            System.out.println("Error al iniciar el catalogo");
            ex.printStackTrace();
        }
    }
    
}
