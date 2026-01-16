package reservaBiblioteca;
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;


    /**
     * Constructor de libro
     * @param isbn
     * @param titulo
     * @param autor
     * @param anioPublicacion
     */
    public Libro(String isbn, String titulo, String autor, int anioPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    /**
     * Getter Isbn
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Setter isbn
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter titulo
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter titulo
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter autor
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Setter de autor
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Getter año de publicacion
     * @return
     */
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    /**
     * Setter año de publicacion
     * @param anioPublicacion
     */
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    /**
     * To string
     * @return
     */
    @Override
    public String toString() {
        return String.format("Isbn: %s | Título: %s | Autor: %s | Año publicación: %d", isbn, titulo, autor, anioPublicacion);
    }

    /**
     * Metodo equals modificado
     * @param o   the reference object with which to compare.
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;

        return this.isbn != null ? this.isbn.equals(libro.isbn) : libro.isbn == null;
    }

    /**
     * Metodo hashCode() modificado
     * @return
     */
    @Override
    public int hashCode() {
        return isbn != null ? isbn.hashCode() : 0;
    }

}
