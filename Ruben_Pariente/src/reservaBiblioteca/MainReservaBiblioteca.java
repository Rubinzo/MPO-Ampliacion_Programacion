package reservaBiblioteca;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
    /*
    Alumno - Rubén Pariente
    DAW - Ampliacion de Programacion
    16/1/2026
 */

public class MainReservaBiblioteca {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static Map<Libro, Integer> inventario = new LinkedHashMap<>();


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
                    gestionarEjemplares();
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
        boolean correcto;
        for (Libro libro: libros) {
            int cantidad = 0;
            do {
                correcto = true;
                try {
                    System.out.println(libro.toString());
                    cantidad = sc.pedirNumero("Introduce el cantidad del producto: ");
                    if (cantidad < 0) {
                        throw new CantidadInvalidaException("La cantidad en stock no puede ser negativa");
                    }
                } catch (CantidadInvalidaException e) {
                    System.out.println(e.getMessage());
                    correcto = false;
                }
            } while (!correcto);

            inventario.put(libro, cantidad);
        }

    }

}
