package reservaBiblioteca;

import java.util.ArrayList;
    /*
    Alumno - Rubén Pariente
    DAW - Ampliacion de Programacion
    16/1/2026
 */

public class MainReservaBiblioteca {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Libro> libros = new ArrayList<>();

    public static void main(String[] args)  {
        menu();

    }


    public static void menu()  {

        boolean flag = true;
        do {
            int opcion = sc.pedirNumero("==== GESTIÓN BIBLIOTECA ====\n1. Registrar libro\n2. Mostrar catálogo\n3. Gestionar ejemplares\n4. Salir");
            switch (opcion){
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    mostrarCatalogo();
                    break;

                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    flag = false;
                    break;
                default:
                    System.out.println("Introduce un número entre 1-4");
                    break;
            }
        }while(flag);
    }


    public static void registrarLibro() {

        String isbn = "";
        String nombre = "";
        String autor = "";
        int anioPublicacion = 0;
        boolean correcto = true;
        do {
            correcto = true;
            try {
                isbn = sc.pedirSoloTexto("Introduce el ISBN del libro");
                if (isbn.length() < 5) {
                    throw new IsbnInvalidoException("El isbn tiene que tener mínimo 5 caracteres");
                }
            }catch (IsbnInvalidoException e){
                System.out.println(e.getMessage());
                correcto = false;
            }
            nombre = sc.pideTexto("Introduce el nombre del libro");
            autor = sc.pideTexto("Introduce el autor del libro");
            try {
                anioPublicacion = sc.pedirNumero("Introduce el año de publicación");
                if(anioPublicacion < 0){
                    throw new AnioInvalidoException("El año tiene que ser mayor que cero");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                correcto = false;
            }


        }while(!correcto);
        System.out.println("Biblioteca registrado correctamente");
        Libro libro = new Libro(isbn, nombre, autor, anioPublicacion);
        libros.add(libro);
    }

    public static void mostrarCatalogo() {
        for(Libro libro: libros) {
            System.out.println(libro.toString());
        }

    }

    public static void gestionarEjemplares() {
        ArrayList<String> listaEjemplares = new ArrayList<>();

    }

}
