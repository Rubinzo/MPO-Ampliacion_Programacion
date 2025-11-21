package Biblioteca;

import java.util.ArrayList;
import java.util.Objects;
/**
 * Clase Biblioteca
 *
 * @author Alumno - Rubén Pariente
 * @version 1.1
 */
public class Biblioteca {

    private ArrayList<Libro> libros;

    /**
     * Constructor principal de la clase Biblioteca
     *  Inicia la lista de libros
     *
     */
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    /**
     * Getter del Array list
     * @return
     */
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    /**
     * Setter del Array list
     * @param libros
     */
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Metodo de agregar libro, añade a la lista libros un libro
     * @param libro
     */

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    /**
     * Metodo de mostrar libros, muestra todos los libros que hay en la lista libros
     */

    public void mostrarLibros() {
        System.out.println("====== TODOS LOS LIBROS ======");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }


    /**
     * Metodo de mostrar por autor, muestra los libros que coincidan con el parámetro que le damos como autor
     * @param autor
     */
    public void mostrarPorAutor(String autor) {
        System.out.println("\n====== BUSQUEDA POR AUTOR: " + autor + " ======");
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                System.out.println(libro);
            }
        }
        System.out.println("========================================");
    }
}
