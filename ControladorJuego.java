
/**
 * Clase ControladorJuego: es el contralador del programa, comunica las clases 
 * del modelo con las clases de la vista y realiza llamados 
 * 
 * @author Josué RR
 * @version 1
 */

public class ControladorJuego {
    VistaTablero llamadaVistaTablero = new VistaTablero();                           //Llama métodos de la clase VistaTablero
    VistaMenusVentanas llamadaVistaMenusVentanas = new VistaMenusVentanas();         //Llama métodos de la clase VistaMenusVentanas
    Jugadores llamadaJugadores = new Jugadores();                                    //Llama métodos de la clase Jugadores
    Tablero llamadaTablero = new Tablero();                                          //Llama métodos de la clase Tablero
    JugadorVirtual llamadaJugadorVirtual = new JugadorVirtual();                     //Llama métodos de la clase JugadorVirtual
    CondicionesDeVictoria llamadaCondicionesDeVictoria = new CondicionesDeVictoria();//Llama métodos de la clase CondicionesDeVictoria
    
    //Variable tipo matriz que almacena el contenido del tablero
    String matrizTablero[][];
    //Variable tipo booleana que indica si existe una victoria
    boolean victoria = false;
    //Variable tipo String que almacena el jugador con el turno actual
    String jugadorActual = "";
    //Variable tipo int que almacena el turno actual del juego
    int contadorTurnos;
    //Variable tipo String que almacena entradas del usuario
    String entrada = "";
    //Variable tipo int que almacena la cantidad de jugadores
    int cantidadJugadores;
   
    /**
     * Método que se encarga de realizar todos los llamados 
     */
    public void ControladorJuego() {
        //Despliegue ventana preguntando si desea instrucciones
        entrada = llamadaVistaMenusVentanas.deseaInstrucciones();
       
        //Condicional en caso de querer leer las instrucciones
        if (entrada.equals("A")){
            llamadaVistaMenusVentanas.imprimirInstrucciones();
        }
        
        //Despliegue menu cantidad de jugadores: asignación de cantidad de jugadores
        entrada = llamadaVistaMenusVentanas.menuCantidadJugadores();
        cantidadJugadores = llamadaJugadores.calcularCantidadJugadores(entrada);
        
        //Inicialización y despligue de la matriz que representa el tablero
        matrizTablero = llamadaTablero.inicializaciónTablero();
        llamadaVistaTablero.imprimirTablero(matrizTablero);
        
        
        //Ciclo que se repita mientras no haya un ganador o queden espacios
        while (victoria == false) {
           contadorTurnos  = contadorTurnos  + 1;  
            
           //Condicional que verifica si aún existen espacios
           if (llamadaTablero.verificarEspacio(matrizTablero) == false) {
               llamadaVistaMenusVentanas.ventanaEmpate();
               System.exit(0);
           }
           
           
           //Ciclo que se repite hasta que el jugador actual coincida con la elección de jugador del usuario
           do { 
               entrada = llamadaVistaMenusVentanas.menuEleccionTurno();
               jugadorActual = llamadaJugadores.turnoActualJugador(contadorTurnos);
               //Condicional que llama un método que imprime una ventana indicando si no es el turno del jugador
               if (!entrada.equals(jugadorActual)){
                   llamadaVistaMenusVentanas.ventanaNoEsTurno();
               }
           }
           while (!entrada.equals(jugadorActual));

           
           //Condicional de selección según cuántos usuarios están utilizando el programa
           switch (cantidadJugadores) {
               case 1:
                     if (jugadorActual.equals("O")) {
                         int columnaDeseada = llamadaJugadorVirtual.eleccionColumna(matrizTablero);
                         
                         //Ciclo en caso de ingresar fichas en una columna llena
                         while (llamadaTablero.verificarEspacioColumna(matrizTablero, columnaDeseada) == false) {
                             columnaDeseada = llamadaJugadorVirtual.eleccionColumna(matrizTablero);
                         }
                         llamadaTablero.agregarFichaTablero(matrizTablero,columnaDeseada,jugadorActual);
                         
                        }
                     else {
                         entrada = VistaMenusVentanas.menuEleccionColumna();
                         int columnaDeseada = Integer.parseInt(entrada);
                         
                         //Ciclo en caso de ingresar fichas en una columna llena
                         while (llamadaTablero.verificarEspacioColumna(matrizTablero, columnaDeseada) == false) {
                               VistaMenusVentanas.ventanaColumnaLlena();
                               entrada = VistaMenusVentanas.menuEleccionColumna();
                               columnaDeseada = Integer.parseInt(entrada);
                         }
                         
                         llamadaTablero.agregarFichaTablero(matrizTablero,columnaDeseada,jugadorActual);
                     }
                     break;
                     
               case 2:
                     entrada = VistaMenusVentanas.menuEleccionColumna();
                     int columnaDeseada = Integer.parseInt(entrada);
                     //Ciclo en caso de ingresar fichas en una columna llena
                     while (llamadaTablero.verificarEspacioColumna(matrizTablero, columnaDeseada) == false) {
                           VistaMenusVentanas.ventanaColumnaLlena();
                           entrada = VistaMenusVentanas.menuEleccionColumna();
                           columnaDeseada = Integer.parseInt(entrada);
                     }
                     llamadaTablero.agregarFichaTablero(matrizTablero,columnaDeseada,jugadorActual);
                     break;
           }
           
           //Llama método que despliga la matriz que representa el tablero
           llamadaVistaTablero.imprimirTablero(matrizTablero);
            
           //Llama método que vefica si hay algún ganador y se asigna el valor booleano
           victoria = llamadaCondicionesDeVictoria.revisionGeneral(matrizTablero, jugadorActual);
        }
        
        //Despliegue de mensaje cuando se detecte algún ganador
        llamadaVistaMenusVentanas.ventanaMensajeGanador(jugadorActual);
        
    }
}
