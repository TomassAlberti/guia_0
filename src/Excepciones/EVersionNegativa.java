package Excepciones;

public class EVersionNegativa extends RuntimeException {
    public EVersionNegativa(String message) {
        super(message);
    }
}
