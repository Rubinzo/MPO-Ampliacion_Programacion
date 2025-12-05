package gestion_inventario;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /*
    Alumno - Rubén Pariente
    DAW - Ampliacion de Programacion
    5/12/2025
 */
    private static final Scanner sc = new Scanner(System.in);
    private static Map<String, Double> productos = new HashMap<>();
    public static void main(String[] args) {

    menu();

    }

    /**
     * metodo para el menu con todas las opciones
     */
    public static void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("==== GESTIÓN DE INVENTARIO ==== \n1. Añadir producto \n2. Buscar producto\n3. Actualizar precio\n4. Mostrar inventario\n5. Salir\n");
                opcion = sc.nextInt();
                //limpiar el buffer
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        addProducto();
                        break;
                    case 2:
                        buscarProducto();
                        break;
                    case 3:
                        actualizarPrecio();
                        break;
                    case 4:
                        mostrarInventario();
                        break;
                }
            }catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Tienes que introducir un numero");
            }
        }while (opcion != 5);
        System.out.println("Saliendo del programa...");






    }

    /**
     * metodo para añadir los productos
     */
    public static void addProducto() {
        String codigo = "";
        double precio = 0;
        boolean correcto;


        do {
            try{
                System.out.println("Ingrese el código del producto que desea añadir: ");
                codigo = sc.nextLine();
                codigo = validarCodigo(codigo);
                correcto = true;
            }catch (CodigoInvalidoException e){
                System.out.println(e.getMessage());
                correcto = false;
            }
        }while (!correcto);


        do {
            try{
                System.out.println("Ingrese el precio del producto que desea añadir: ");
                precio = sc.nextDouble();
                precio = validarPrecio(precio);
                correcto = true;
            }catch (PrecioInvalidoException e){
                System.out.println(e.getMessage());
                correcto = false;
            }
        }while (!correcto);



        productos.put(codigo, precio);
        System.out.println("Producto registrado exitosamente");




        System.out.println(codigo + " " + precio);
    }

    /**
     * metodo para validar codigo
     * @param codigo
     * @return codigo
     * @throws CodigoInvalidoException
     */
    public static String validarCodigo(String codigo) throws CodigoInvalidoException {
        if (codigo.length() >= 3 && codigo.matches("[A-Za-z0-9]+")) {
            return codigo;
        }
        throw new CodigoInvalidoException("El código solo puede contener mayúsculas y numeros");
    }


    /**
     * metodo para validar precio
     * @param precio
     * @return precio
     * @throws PrecioInvalidoException
     */
    public static Double validarPrecio(Double precio) throws PrecioInvalidoException {
        if (precio >= 0) {
            return precio;
        }

        throw new PrecioInvalidoException("El precio tiene que ser un número positivo");
    }

    /**
     * metodo para buscar los productos
     */
    public static void buscarProducto() {
        System.out.println("Introduce el codigo del producto: ");
        String codigo = sc.nextLine();
        try {
            if (productos.containsKey(codigo)) {
                System.out.println("Producto "+ codigo + " encontrado. Cuesta " +productos.get(codigo) + " euros ");
            } else {
                throw new ProductoNoEncontradoException("Producto no encontrado!");
            }
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * metodo para actualizar precio
     */
    public static void actualizarPrecio() {
        System.out.println("Introduce el codigo del producto que quieres actualizar: ");
        String codigo = sc.nextLine();
        try {
            if (productos.containsKey(codigo)) {
                System.out.println("Producto "+ codigo + " encontrado. Cuesta " +productos.get(codigo) + " euros ");
                System.out.println("¿Que precio le quieres poner?");
                Double precio_actualizado = sc.nextDouble();
                sc.nextLine();
                boolean correcto;
                do {
                    try{
                        precio_actualizado = validarPrecio(precio_actualizado);
                        productos.put(codigo, precio_actualizado);
                        correcto = true;
                    }catch (PrecioInvalidoException e){
                        System.out.println(e.getMessage());
                        correcto = false;
                    }
                }while (!correcto);
            } else {
                throw new ProductoNoEncontradoException("Producto no encontrado!");
            }
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * metodo para mostrar el inventario
     */
    public static void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío");
        }else  {
            for (Map.Entry<String, Double> entry : productos.entrySet()) {
                System.out.println("Código: " + entry.getKey() + " | Precio: " + entry.getValue());
            }
        }
    }

}
