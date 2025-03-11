package Clases;

public class Juego extends Biblioteca {
    public int nroVersion;

    public Juego(String titulo, String creador, String genero, int id, int nroVersion) {
        super(titulo, creador, genero, id);
        this.nroVersion = nroVersion;
    }
    public Juego() {}

    public int getNroVersion() {
        return nroVersion;
    }

    public void setNroVersion(int nroVersion) {
        this.nroVersion = nroVersion;
    }

}
