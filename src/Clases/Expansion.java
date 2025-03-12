package Clases;

public class Expansion extends Biblioteca{
    public int fechaDeLanzamiento;

    public Expansion(String titulo, String creador, String genero, int id, int fechaDeLanzamiento) {
        super(titulo, creador, genero, id);
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }
    public Expansion() {}


    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }
}
