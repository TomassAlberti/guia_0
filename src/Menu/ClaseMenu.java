package Menu;

import Clases.Expansion;
import Clases.Juego;
import ClasesGestoras.Coleccion;
import Excepciones.EFechaDeLanzamientoNegativa;
import Excepciones.EIdentificadorDuplicadoException;
import Excepciones.EVersionNegativa;
import Excepciones.IErrorId;

import java.util.Scanner;

public class ClaseMenu {
    public boolean mostrarMenu() {
        int opcion = 0;
        Juego juego1 = new Juego("Rapidos y Furiosos", "Tomas Alberti", "Accion", 20, 1);
        Juego juego2 = new Juego("Hogwarts Legacy", "Tomas Alberti", "Aventura", 2, 3);
        Juego juego3 = new Juego("Fornite", "Tomas Alberti", "Accion", 1, 3);
        Expansion exp1 = new Expansion("Superman", "El master", "Accion", 23, 23 / 02 / 24);
        Expansion exp2 = new Expansion("Indiana Jonees", "El master", "Aventura", 4, 01 / 01 / 23);
        Expansion exp3 = new Expansion("Pac Man", "El master", "Puzzle", 5, 31 / 05 / 26);

        Coleccion cole = new Coleccion();
        Scanner sn = new Scanner(System.in);

        do {
            System.out.println("Ingrese 1 si desea aniadir las expansiones a la collecion");
            System.out.println("Ingrese 2 si desea aniadir los juegos a la collecion");
            System.out.println("Ingrese 3 si desea eliminar un elemento por su id");
            System.out.println("Ingrese 4 si desea mostrar por titulo");
            System.out.println("Ingrese 5 para modificar un atributo de un objeto ");
            System.out.println("Ingrese 6 si desea filtrar los objetos por genero");
            System.out.println("Ingrese 7 para mostrar todo lo ingresado");
            System.out.println("Ingrese 0 para salir");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1: {
                    try {
                        System.out.println(cole.addExpansion(exp1));
                        System.out.println(cole.addExpansion(exp2));
                        System.out.println(cole.addExpansion(exp3));
                    } catch (EIdentificadorDuplicadoException | EFechaDeLanzamientoNegativa e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.println(cole.addJuego(juego3));
                        System.out.println(cole.addJuego(juego2));
                        System.out.println(cole.addJuego(juego1));
                    } catch (EIdentificadorDuplicadoException | EVersionNegativa e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 3: {
                    int idAux;
                    System.out.println("Ingrese el id del elemento a eliminar: ");
                    idAux = sn.nextInt();
                    sn.nextLine();

                    try {
                        System.out.println(cole.delete(idAux));
                    } catch (IErrorId e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 4: {
                    System.out.println(cole.mostrarXtitulo());
                    break;
                }
                case 5: {
                                int idAux;
                                String dato;
                                String datoAmodificar;


                                System.out.println("Ingrese el id de el elemento a modificar");
                                idAux = sn.nextInt();
                                sn.nextLine();

                                System.out.println("Ingrese el dato que quiera modificar");
                                dato = sn.nextLine();
                                sn.nextLine();

                                System.out.println("Ingrese el dato");
                                datoAmodificar = sn.nextLine();
                                sn.nextLine();

                                System.out.println(cole.modificarDatoString(idAux, dato, datoAmodificar));


                            }
                case 6: {
                    String generoAux = " ";
                    System.out.println("Ingrese el genero que desea ver");
                    generoAux = sn.next();
                    sn.nextLine();

                    System.out.println(cole.mostrarXgenero(generoAux));
                    break;
                }
                case 7:{
                    System.out.println(cole.mostrarTodo());
                }
            }

        } while (opcion != 0);
        return false;
    }
}
