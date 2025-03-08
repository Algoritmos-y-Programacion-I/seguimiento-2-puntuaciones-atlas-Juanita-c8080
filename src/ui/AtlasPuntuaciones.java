// Análisis
// Descripción del programa: Este programa diseñador para Atlas busca crear un juego con puntajes, de los cuales se da la suma, el promedio y el ganador del juego
// Entradas: int opcion, n, m, puntaje, j, i, puntajeMasAlto; boolean ingresado; 
// Salidas: String mensaje;
// Ejemplo:
/**
 * 
 */


package ui; // No olvidar especificar el paquete/carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

    // Declaración del Escaner que nos ayudará en todo el programa
	private Scanner escaner;

    // Declaración de nuestras constantes a utilizar

	private AtlasPuntuaciones() {
		escaner = new Scanner(System.in);
	}

    public void run(){

        // Declaracion de todas las variables a usar en el programa
        int opcion, n, m, puntaje;

        // Notificacion al usuario de la solicitud de dato
		// Capturamos el dato con nuestro Scanner (que se llama, escaner)
        // Realizamos los cálculos delegandolos a los métodos
		// Notificación al usuario de los resultados
        //Esta todo junto porque todo esta dentro de ciclos y para mi es mas facil verlo asi :)

        System.out.println("Ingrese la cantidad de jugadores");
        do {
            n = escaner.nextInt();
            if(n < 1 || n > 10) {
                System.out.println("Error entrada invalida, intente nuevamente");
            }
        } while (n < 1 || n > 10);
        int[] jugadores = new int[n];

        
        System.out.println("Ingrese la cantidad de rondas");
        do {
            m= escaner.nextInt();
            if (m < 1 || m > 5) {
                System.out.println("Error entrada invalida, intente nuevamente");
            }
        } while (m < 1 || m > 5);

        do {
            System.out.println("Que deseas hacer con los jugadores?: \n1.Registrar puntajes " +
                    "\n2.Mostrar puntuacion promedio de los jugadores " +
                    "\n3.Mostrar jugador con la puntuacion mas alta " +
                    "\n0.Salir");
            opcion = escaner.nextInt();
            switch (opcion) {
                case 1 -> {
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            boolean ingresado = false;
                            System.out.println("Ingresa el puntaje del jugador " + (j + 1) + " en la ronda " + (i + 1));
                            do {
                                puntaje = escaner.nextInt();
                                ingresado = calcularSumaTotal(puntaje, jugadores, j);
                                if (!ingresado) { //bono
                                    System.out.println("Error entrada invalida, intente nuevamente");
                                } else {
                                    System.out.println("Puntaje ingresado correctamente");
                                }
                            } while (!ingresado);
                        }
                    }
                    System.out.println("\nPuntajes finales:");
                    for (int j = 0; j < n; j++) {
                        System.out.println("El total del jugador " + (j + 1) + " es " + jugadores[j]);
                    }
                }
                case 2 -> {
                    System.out.println(calcularPromedio(jugadores, m));
                }
                case 3 -> {
                    System.out.println(encontrarMayor(jugadores));
                } 
                case 0 -> {
                    System.out.println("Hasta luego");
                }
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
		AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
		mainApp.run();
	}
    /**
     * Descripción: suma el puntaje de cada jugador y se asegura de verificar que el valor del puntaje es valido
     * @param puntaje el puntaje obtenido en una ronda (debe estar entre 0 y 100 inclusivamente)
     * @param jugadores un array que representa las puntuaciones acumuladas de cada jugador
     * @param j el índice en el arreglo que indica el lugar del puntaje requerido
     * @return true si el puntaje fue evaluado y sumado; false si el puntaje es inválido
     */
    // esto incluye una parte del bono
    public static boolean calcularSumaTotal(int puntaje, int[] jugadores, int j){
    if(puntaje >= 0 && puntaje <= 100) {
        jugadores[j] += puntaje;
        return true;
    }
    return false;
    }

    /**
     * Descripción: Calcula y devuelve el promedio de los puntajes de cada jugador.
     * @param jugadores un array que representa las puntuaciones acumuladas de cada jugador
     * @return un mensaje que indica la puntuación promedio de los jugadores
     */
    public static String calcularPromedio(int[] jugadores, int m) {
        String mensaje = "";
        for(int i = 0; i < jugadores.length; i++) {
            mensaje += "El promedio del jugador " + (i+1) + " de todas las rondas fue de " + (jugadores[i] / m) + "\n";
        }
        return mensaje;
    }

    /**
     * Descripción: Indica cual es el jugador con el puntaje más alto.
     * @param jugadores un array que representa las puntuaciones acumuladas de cada jugador
     * @return un mensaje que dice cual es el jugador con el puntaje más alto
     */
    public static String encontrarMayor(int[] jugadores) {
        String mensaje = "";
        int puntajeMasAlto = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] > puntajeMasAlto) {
                puntajeMasAlto = jugadores[i];
                mensaje = "La puntuacion mas alta le pertene al jugador " + (i + 1) + " con " + puntajeMasAlto;
            }
        }
        return mensaje;
    }
}
    