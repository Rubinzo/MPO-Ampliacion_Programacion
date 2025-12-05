package gestion_inventario;

public class ProductoNoEncontradoException extends Exception {
    public ProductoNoEncontradoException(String message) {
        super(message);
    }
}
