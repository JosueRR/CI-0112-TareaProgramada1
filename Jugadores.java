
/**
 * Clase Jugadores: contiene distintos métodos relacionados a los jugadores (cantidad, turno, representación)
 * 
 * @author Josué RR
 * @version 1
 */

public class Jugadores {
    static String jugadorUno = "X";
    static String jugadorDos = "O";
    
    /**
     * Método que cálcula a quién pertece el turno actual
     * @return Retorna el jugador al cuál pertenece el turno
     */
    public String turnoActualJugador(int contadorTurnos){
        if (contadorTurnos %2 == 0){
            return jugadorDos;
        }
        else {
            return jugadorUno;
        }
    }
    
    /**
     * Método que almacena cuántos usuarios están utilizando el programa
     * @return Retorna un int con la cantidad de jugadores seleccionados
     */
    public static int calcularCantidadJugadores(String entrada) {
        int cantidadJugadores = 2;
        switch (entrada) {
            case "A":
                    cantidadJugadores = 2;
                    break;
            case "B":
                    cantidadJugadores = 1;
                    break;
        }
        return cantidadJugadores;
    }
}
