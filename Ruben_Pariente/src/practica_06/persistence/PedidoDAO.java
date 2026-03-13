package practica_06.persistence;

import practica_06.models.Pedido;
import recursos.Utilidades;

import java.io.*;
import java.util.ArrayList;

public class PedidoDAO {


    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Practica_06";
    private final File FILE = new File(RUTA + File.separator + "pedidos.txt");

    public void guardar(ArrayList<Pedido> pedidos) {
        if (comprobarDirectorio(RUTA)) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
                for (Pedido pedido : pedidos) {
                    String linea =
                            pedido.getId() + ";" +
                                    pedido.getNombreCliente() + ";" +
                                    pedido.getPlato() + ";" +
                                    pedido.getPrecio();
                    bw.write(linea);
                    bw.newLine();
                }
                System.out.println("Biblioteca guardada exitosamente");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public ArrayList<Pedido> cargar() {
        ArrayList<Pedido> libros = new ArrayList<>();
        if (FILE.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(";");
                    String id = datos[0];
                    String cliente = datos[1];
                    String plato = datos[2];
                    Double precio = Double.valueOf(datos[3]);
                    libros.add(new Pedido(id, cliente, plato, precio));
                }
                System.out.println("Biblioteca cargada exitosamente");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return libros;
    }
    private static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }
}
