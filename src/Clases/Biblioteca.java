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

    public String getGenero() {
        return Genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    @Override
    public int compareTo(Biblioteca o) {
        return this.titulo.compareTo(o.getGenero());
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
