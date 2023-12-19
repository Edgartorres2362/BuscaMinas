import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int filas = 10;
        int columnas = 10;
        int minas = 10;

        int[][] tablero = new int[filas][columnas];
        boolean[][] tableroVisible = new boolean[filas][columnas];

        inicializarTablero(tablero, minas);

        inicializarTableroVisible(tableroVisible);

        int puntos = 0;
        boolean juegoTerminado = false;

        while (!juegoTerminado) {

            imprimirTablero(tableroVisible);
            System.out.print("Introduce la fila: ");
            int fila = scanner.nextInt();
            System.out.print("Introduce la columna: ");
            int columna = scanner.nextInt();

            if (tablero[fila][columna] == 1) {
                System.out.println("¡Has encontrado una mina! Fin del juego.");
                juegoTerminado = true;
            } else {
                System.out.println("¡Casilla correcta! Sumas 10 puntos.");
                puntos += 10;
                tableroVisible[fila][columna] = true;
                if (puntos == (filas * columnas - minas) * 10) {
                    System.out.println("¡Has ganado! Puntos totales: " + puntos);
                    juegoTerminado = true;
                }
            }
        }
        System.out.print("¿Quieres jugar de nuevo? (s/n): ");
        char respuesta = scanner.next().charAt(0);

        if (respuesta == 's' || respuesta == 'S') {
            main(args);
        } else {
            System.out.println("¡Gracias por jugar! Puntos totales: " + puntos);
        }

        scanner.close();
    }
    private static void inicializarTablero(int[][] tablero, int minas) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = 0;
            }
        }
        for (int k = 0; k < minas; k++) {
            int fila = (int) (Math.random() * tablero.length);
            int columna = (int) (Math.random() * tablero[0].length);
            if (tablero[fila][columna] == 0) {
                tablero[fila][columna] = 1; 
            } else {
                k--; 
            }
        }
    }
    private static void inicializarTableroVisible(boolean[][] tableroVisible) {
        for (int i = 0; i < tableroVisible.length; i++) {
            for (int j = 0; j < tableroVisible[i].length; j++) {
                tableroVisible[i][j] = false;
            }
        }
    }
    private static void imprimirTablero(boolean[][] tableroVisible) {
        // Mostrar el tablero visible
        System.out.println("Tablero:");
        for (int i = 0; i < tableroVisible.length; i++) {
            for (int j = 0; j < tableroVisible[i].length; j++) {
                if (tableroVisible[i][j]) {
                    System.out.print(" X "); 
                } else {
                    System.out.print(" O "); 
                }
            }
            System.out.println();
        }
    }
}
