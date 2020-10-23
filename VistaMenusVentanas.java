
/**
 * Clase VistaMenusVentanas: contiene métodos que despliegan menús y ventanas emergentes
 * 
 * @author Josué RR
 * @version 1
 */

import javax.swing.JOptionPane;


public class VistaMenusVentanas {
    /**
     * Método que despliega un menú con dos opciones: elegir dos jugadores o elegir solo un jugador.
     * @return Retorna la entrada del usuario
     */
    public String menuCantidadJugadores() {
        String entrada = ""; 
        while (!"A".equals(entrada) && !"B".equals(entrada)) {
            entrada = JOptionPane.showInputDialog ("Digite la opción con el número de jugadores deseados\n"
                                                     + "A. Modo dos jugadores\n"
                                                     + "B. Modo un jugador\n");                 
        }
        return entrada;
    }
    
    /**
     * Método que despliega las intrucciones del programa
     */
    public static void imprimirInstrucciones() {
            JOptionPane.showMessageDialog(null, 
            "                                                        ¡BIENVENIDO!\n\n" +

                                          "                                             ASPECTOS GENERALES\n\n"
            
            + "1. Existen dos tipos de jugadores que representan una ficha X (jugador uno)\n" 
            + "y O (jugador dos)\n\n" 
            + "2. El jugador con la ficha X siempre empezará primero.\n\n"
            + "3. El programa solo detectará sus entradas cuando las ingresa en el formato\n"
            + "requerido.\n\n"
            + "4. El tablero se desplegará automáticamente después de cada jugada.\n\n"
            + "5. En cada turno el programa le preguntará cuál ficha desea ingresar, en\n"
            + "caso de que la ficha no coincida con el jugador actual, el programa se lo\n" 
            + "informará y deberá ingresar una ficha válidad.\n\n"
            + "6. Gana el primer jugador con cuatro fichas en raya \n"
            + "(vertical-horizontal-diagonal).\n\n"
            + "7. En caso del tablero estar lleno y no tener aún un ganador será un empate.\n\n");
            
            JOptionPane.showMessageDialog(null,"                                                        PASOS A SEGUIR\n\n"
                                                + "1. Después de leer las instrucciones se le preguntará el número de jugadores \n"
                                                + "deseados, deberá seleccionar entre:\n\n" 	
                                                + "                              A) En caso de querer dos jugadores\n"
                                                + "                              B) En caso de querer jugar contra la maquina\n\n"
                                                + "Ingresa la letra correspondiente a su elección.\n\n"

                                                + "2. A cada jugador se le preguntará en qué columna desea ingresar la ficha (X o O), \n"
                                                + "estas se enumeran del 0 al 6.\n\n"
                                                + "En caso de jugar solo una persona funcionará igual, pero el turno del segundo\n"
                                                +"jugador será automático.\n");
        
    }
    
    /**
     * Método que despliega un menú preguntando qué se desea ingresar el siguiente movimiento.
     * @return Retorna la entrada del usuario 
     */
    public String menuEleccionTurno() {
        String entrada = ""; 
        while (!"X".equals(entrada) && !"O".equals(entrada)) {
            entrada = JOptionPane.showInputDialog ("        Elección de ficha\n"
                                                     + "X. Jugador uno (X)\n" 
                                                     + "O. Jugador dos (O)\n");                                         
        }
        return entrada;
    }
    
    /**
     * Método que despliega un menú preguntando en qué columna desea ingresar la ficha
     * @return Retorna la entrada del usuario
     */
    public static String menuEleccionColumna() {
       String entrada = ""; 
       while (!"0".equals(entrada) && !"1".equals(entrada) && !"2".equals(entrada) && !"3".equals(entrada)
             && !"4".equals(entrada) && !"5".equals(entrada) && !"6".equals(entrada)) {
           
            entrada = JOptionPane.showInputDialog ("¿En cuál columna desea ingresar la ficha?\n");                                      
       }
       return entrada; 
    }
    
    /**
     * Método que despliega una ventana anunciando que el juego terminó, y el resultado es un empate
     */
    public void ventanaEmpate() {
        JOptionPane.showMessageDialog(null, "       ¡El juego ha finalizado!\n" + 
                                            "       ¡Es un empate!");
    } 
    
    /**
     * Método que despliega una ventana anunciando que aún no es el turno del jugador seleccionado
     */
    public void ventanaNoEsTurno() {
        JOptionPane.showMessageDialog(null, "El turno actual no corresponde al jugador seleccionado");
    }
    
    /**
     * Método que despliega una ventana anunciando que el juego terminó, y algún jugador ganó
     * Resive un parámetro que identifica al jugador ganador
     */
    public void ventanaMensajeGanador(String jugadorActual) {
        JOptionPane.showMessageDialog(null, "       ¡El juego ha finalizado!\n" + 
                                       "¡Ganó el jugador con la ficha " + jugadorActual + "!");
    }
    
    /**
     * Método que despliega una ventana preguntando si el usuario desea leer las instrucciones
     * @return Retorna la entrada del usuario
     */
    public String deseaInstrucciones() {
        String entrada = "";
        while (!"A".equals(entrada) && !"B".equals(entrada)) {
            entrada = JOptionPane.showInputDialog (null, "      ¿Desea leer las instrucciones?\n"
                                                      + "A. Sí \n"
                                                      + "B. No \n");
        }
        return entrada;
    }
    
    /**
     * Método que despliega una ventana indicando que la columna seleccionada se encuentra llena 
     */
    public static void ventanaColumnaLlena() {
        JOptionPane.showMessageDialog(null, "¡La columna seleccionada se encuentra llena, seleccione otra por favor!");
    }
}
