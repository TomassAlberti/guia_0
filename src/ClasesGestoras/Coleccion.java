package ClasesGestoras;

import Clases.Biblioteca;
import Clases.Expansion;
import Clases.Juego;
import Excepciones.EFechaDeLanzamientoNegativa;
import Excepciones.EIdentificadorDuplicadoException;
import Excepciones.EVersionNegativa;
import Excepciones.IErrorId;

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
    public String delete (int id) throws IErrorId{
        String msj = "El elemento se elimino con exito";
        if(juegosYexpansiones.containsKey(id)){
            juegosYexpansiones.remove(id);
        }else{
            throw new IErrorId("El elemento no se encuentra dentro de la collecion o el id ingresado es negativo");
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
    public String mostrarXgenero(String genero){
        StringBuilder xgenero = new StringBuilder();
        for(Biblioteca b : juegosYexpansiones.values()){
            if(b.getGenero().equals(genero)){
                xgenero.append(b);
            }
        }
        if(xgenero.length()<=0){
            return "No hay ningun elemento con ese genero";
        }
        return xgenero.toString();
    }
    public String modificarDatoString(int id, String tipoDeDato, String dato) throws EFechaDeLanzamientoNegativa,EVersionNegativa, IErrorId {
        String msj = "Modificado con exito!";
        if(juegosYexpansiones.containsKey(id)){
            Biblioteca b = juegosYexpansiones.get(id);
            if(tipoDeDato.equalsIgnoreCase("titulo")){
                b.setTitulo(dato);
            }else if(tipoDeDato.equalsIgnoreCase("genero")){
                b.setGenero(dato);
            }else if(tipoDeDato.equalsIgnoreCase("fechaDeLanzamiento")){
                Expansion j = (Expansion) b;
                int fecha = Integer.parseInt(dato);
                if(fecha<0){
                    throw new EFechaDeLanzamientoNegativa("La fecha de lanzamiento no puede ser negativa");
                }else{
                    ((Expansion) b).setFechaDeLanzamiento(fecha);
                }
            }else if(tipoDeDato.equalsIgnoreCase("creador")){
                b.setCreador(dato);
            }else if(tipoDeDato.equalsIgnoreCase("numero de version")){
                Juego j = (Juego) b;
                int version = Integer.parseInt(dato);
                if(version>=0){
                    ((Juego) b).setNroVersion(version);
                }else{
                    throw new EVersionNegativa("La version no puede ser negativa");
                }
            }
        }else{
            throw new IErrorId("La id no existe o es negativa");
        }
        return msj;
    }
}
