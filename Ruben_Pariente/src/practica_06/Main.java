package practica_06;


import practica_06.controller.PedidoController;
import recursos.MyScanner;
/*
Alumno - Rubén Pariente
DAW - Ampliacion de Programacion
13/03/2026
*/
public class Main {
    private static final MyScanner sc = new MyScanner();
    private static final PedidoController controller = new PedidoController();



    public static void main(String[] args) {
        menu();
    }


    private static void menu() {
        int opcion;
        do {
            opcion = sc.pedirNumero("==== Biblioteca ====" +
                    "\n1. Registrar pedido" +
                    "\n2. Mostrar pedidos" +
                    "\n3. Guardar en fichero" +
                    "\n4. Cargar desde fichero" +
                    "\n5. Salir" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    controller.addPedido();
                    break;
                case 2:
                    controller.mostrarPedidos();
                    break;
                case 3:
                    controller.guardar();
                    break;
                case 4:
                    controller.cargar();
                    break;
                case 5:
                    System.out.println("Saliendo ...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 5);
    }
}
