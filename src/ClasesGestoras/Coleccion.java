package ClasesGestoras;

import Clases.Biblioteca;
import Clases.Expansion;
import Clases.Juego;
import Excepciones.EFechaDeLanzamientoNegativa;
import Excepciones.EIdentificadorDuplicadoException;
import Excepciones.EVersionNegativa;

import java.util.*;

public class Coleccion {
    public HashMap<Integer, Biblioteca> juegosYexpansiones;

    public Coleccion() {this.juegosYexpansiones = new HashMap<>();}

    public String addJuego(Juego b)throws EIdentificadorDuplicadoException, EVersionNegativa {
        if(juegosYexpansiones.containsKey(b.id)){
            throw new  EIdentificadorDuplicadoException("El elemento se encuentra dentro de la collecion");
        }if(b.getNroVersion()<0){
            throw new EVersionNegativa("La version del juego no puede ser negativa");
        }
                else{
            juegosYexpansiones.put(b.id,b);
        }
        return "El elemento fue aniadido con exito!";
    }
    public String addExpansion(Expansion b)throws EIdentificadorDuplicadoException, EFechaDeLanzamientoNegativa {
        if(juegosYexpansiones.containsKey(b.id)){
            throw new  EIdentificadorDuplicadoException("El elemento se encuentra dentro de la collecion");
        }if(b.getFechaDeLanzamiento()<0){
            throw new EFechaDeLanzamientoNegativa("La fecha de lanzamiento no puede ser negativa");
        }
        else{
            juegosYexpansiones.put(b.id,b);
        }
        return "El elemento fue aniadido con exito!";
    }
    public String delete (int id){
        String msj = "El elemento se elimino con exito";
        if(juegosYexpansiones.containsKey(id)){
            juegosYexpansiones.remove(id);
            return msj;
        }else{
            msj ="El elemento no se encuentra dentro de la collecion";
        }
        return msj;
    }
    public String mostrarXtitulo(){
        StringBuilder xtitulo = new StringBuilder();
        List<Map.Entry<Integer, Biblioteca>> lista = new ArrayList<>(juegosYexpansiones.entrySet());
        lista.sort(Comparator.comparing(entry -> entry.getValue().getTitulo()));

        for(Map.Entry<Integer, Biblioteca> entry : lista){
            xtitulo.append(entry.getKey());
        }
        return xtitulo.toString();
    }
}
