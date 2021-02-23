
package es.peliculas.datos;
import ExcepcionesCatalogoPeliculas.*;
import es.peliculas.domain.Pelicula;
import java.util.List;

public interface IAccesoDatos {
    
    
    boolean existe (String nombreRecurso) throws AccesoDatosEx;
    
    List <Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
    
    void escribir (Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    
    String buscar (String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    void crear (String nombreArchivo) throws AccesoDatosEx;
    
    void borrar (String nombreArchivo) throws AccesoDatosEx;
          
}
