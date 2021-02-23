package es.peliculas.negocio;

import ExcepcionesCatalogoPeliculas.EscrituraDatosEx;

public interface ICatalogoPeliculas {

    String NOMBRE_RECURSO = "peliculas.txt";
    
    
    void agregarPelicula(String nombrePelicula, String nombreArchivo) throws EscrituraDatosEx;

    void listarPeliculas();

    void buscarPelicula(String buscar);

    void iniciarCatalogoPeliculas();


}
