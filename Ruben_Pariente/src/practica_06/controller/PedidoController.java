package practica_06.controller;

import practica_06.models.Pedido;
import practica_06.service.PedidoService;
import recursos.MyScanner;

public class PedidoController {

    private static final MyScanner sc = new MyScanner();
    private static final PedidoService service = new PedidoService();

    public void addPedido() {
        boolean correcto;
        do {
            correcto = true;
            String id = getId();
            Pedido pedido = service.getPedido(id);
            if (pedido != null) {
                System.out.println("El id ya está asociado a un pedido.");
                correcto = false;
            } else {
                String cliente = sc.pideTexto("Introudce el nombre del cliente: ");
                String plato = sc.pideTexto("Introudce el nombre del plato: ");
                boolean flag = false;
                Double precio = 0.0;
                while (!flag) {
                    precio = sc.pedirDecimal("Introudce el precio del plato: ");
                    if (precio > 0) {

                        flag = true;
                    }
                    System.out.println("El precio no puede ser negativo");
                }

                service.addPedido(new Pedido(id, cliente, plato, precio));
                System.out.println("Pedido registrado correctamente.");
            }
        } while (!correcto);
    }

    public void mostrarPedidos() {
        for (Pedido pedido : service.getPedidos()) {
            System.out.println(pedido);
        }
    }


    public void cargar() {
        service.cargar();
    }

    public void guardar() {
        service.guardar();
    }

    private String getId() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código, 3 letras y 2 números: ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
    }
}
