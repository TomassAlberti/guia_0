package Menu;

import Clases.Juego;
import ClasesGestoras.Coleccion;
import Excepciones.EIdentificadorDuplicadoException;

public class Menuu {
    public String menu(){
        Juego Juego1 = new Juego("Rapidos y Furiosos","Tomas Alberti","Accion",1,1);
        Juego Juego2 = new Juego("Hogwarts Legacy","Tomas Alberti","Aventura",2,3);
        Juego Juego3 = new Juego("Fornite","Tomas Alberti","Accion",1,3);

        Coleccion cole = new Coleccion();
     try {
     System.out.println(cole.add(Juego1));
     System.out.println(cole.add(Juego2));
     System.out.println(cole.add(Juego3));
      }catch (EIdentificadorDuplicadoException e){
         System.out.println(e.getMessage());
     }


        return "";
    }
}
