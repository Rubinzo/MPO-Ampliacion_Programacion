package Biblioteca;

public class Libreria {
/*
    Alumno - Rubén Pariente
    DAW - Ampliacion de Programacion
    21/11/2025
 */

public static  void main(String[] args) {

    Biblioteca biblioteca = new Biblioteca();
    Libro libro1 = new Libro("El señor de los anillos","Tolkien");
    Libro libro2 = new Libro("Don Quijote","Cervantes");
    Libro libro3 = new Libro("El principito","Antoine");

    biblioteca.agregarLibro(libro1);
    biblioteca.agregarLibro(libro2);
    biblioteca.agregarLibro(libro3);
    biblioteca.mostrarLibros();
    biblioteca.mostrarPorAutor("Antoine");

}

}
