package sieteymedia.utils;

import sieteymedia.models.Carta;

import java.util.Collections;
import java.util.List;

public class Utils {
    public static double calcularPuntos(String valor) {
        // Lógica para calcular los puntos según el valor de la carta
        return switch (valor) {
            case "As" -> 1.0;
            case "2" -> 2.0;
            case "3" -> 3.0;
            case "4" -> 4.0;
            case "5" -> 5.0;
            case "6" -> 6.0;
            case "7" -> 7.0;
            case "Sota", "Caballo", "Rey" -> 0.5; // Sota, Caballo y Rey valen medio punto
            default -> 0.0;
        };
    }

    public static void barajar(List<Carta> cartas) {
        Collections.shuffle(cartas);
    }
}
