package ec.edu.ejercicios.encapsulamiento;

import java.util.Objects;

public class Libro {
    private final String titulo;
    private final String autor;
    private final String isbn;
    private final int totalPaginas;
    private int paginaActual;
    private int paginaMarcada;
    private boolean abierto;

    public Libro(String titulo, String autor, String isbn, int totalPaginas) {
        this.titulo = Objects.requireNonNull(titulo).trim();
        this.autor = Objects.requireNonNull(autor).trim();
        this.isbn = Objects.requireNonNull(isbn).trim();
        if (totalPaginas <= 0) {
            throw new IllegalArgumentException("El total de páginas debe ser mayor que cero");
        }
        this.totalPaginas = totalPaginas;
        this.paginaActual = 1;
    }

    public void abrir() {
        abierto = true;
    }

    public void cerrar() {
        abierto = false;
    }

    public void avanzarPaginas(int cantidad) {
        verificarAbierto();
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        paginaActual = Math.min(totalPaginas, paginaActual + cantidad);
    }

    public void retrocederPaginas(int cantidad) {
        verificarAbierto();
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        paginaActual = Math.max(1, paginaActual - cantidad);
    }

    public void marcarPagina() {
        verificarAbierto();
        paginaMarcada = paginaActual;
    }

    private void verificarAbierto() {
        if (!abierto) {
            throw new IllegalStateException("El libro está cerrado");
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", totalPaginas=" + totalPaginas +
                ", paginaActual=" + paginaActual +
                ", paginaMarcada=" + paginaMarcada +
                ", abierto=" + abierto +
                '}';
    }
}
