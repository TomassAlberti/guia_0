package Clases;

public abstract class Biblioteca implements Comparable<Biblioteca> {
    public String titulo;
    public String creador;
    public String Genero;
    public int id;

    public Biblioteca(String titulo, String creador, String genero, int id) {
        this.titulo = titulo;
        this.creador = creador;
        Genero = genero;
        this.id = id;
    }

    public Biblioteca() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int compareTo(Biblioteca o) {
        return this.titulo.compareTo(o.getTitulo());
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", Genero='" + Genero + '\'' +
                ", id=" + id +
                '}';
    }
}
