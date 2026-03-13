package practica_06.models;

/**
 * Clase pedido con atributos de id nombre del cliente plato y precio
 */
public class Pedido {
    String id;
    String nombreCliente;
    String plato;
    Double precio;

    /**
     * Constructor de pedido
     * @param id id del plato
     * @param nombreCliente nombre del cliente que realiza el pedido
     * @param plato nombre del plato del pedido
     * @param precio precio con decimales del pedido
     */
    public Pedido(String id, String nombreCliente, String plato, Double precio) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.plato = plato;
        this.precio = precio;


    }

    /**
     * Getter del Id del pedido devuelve el id
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Getter del nombre del cliente que devuelve el nombre
     * @return
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Getter del plato devuelve el nombre de este
     * @return
     */
    public String getPlato() {
        return plato;
    }

    /**
     * Getter del precio devuelve el precio
     * @return
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * ToString de pedido para mostrar sus atributos
     * @return
     */
    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", plato='" + plato + '\'' +
                ", precio=" + precio +
                '}';
    }
}
