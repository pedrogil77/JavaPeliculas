package es.peliculas.datos;

import ExcepcionesCatalogoPeliculas.*;
import es.peliculas.domain.Pelicula;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        return archivo.exists();

    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
                

            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas " + ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas " + e.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Pelicula añadida: " + pelicula);

        } catch (IOException ex) {

            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al escribir pelicula" + ex.getMessage());
        }

    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {

        var archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(nombreRecurso));
            var linea = entrada.readLine();
            int indice = 1;

            while (linea != null) {

                if (buscar != null && buscar.equalsIgnoreCase(linea)) {

                    resultado = "Pelicula " + linea + " en pos " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {

            ex.printStackTrace();
            throw new LecturaDatosEx("Error al buscar pelicua");

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al buscar pelicula");

        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Fichero creado correctamente");
        } catch (IOException ex) {

            throw new AccesoDatosEx("Excepcion a crear el archivo" + ex.getMessage());
        }

    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {

        var archivo = new File(nombreRecurso);
        if (archivo.exists()) {

            archivo.deleteOnExit();
            System.out.println("Se ha borrado el archivo");
        } else {

            System.out.println("no se ha encontrado el fichero");
        }
    }

}
