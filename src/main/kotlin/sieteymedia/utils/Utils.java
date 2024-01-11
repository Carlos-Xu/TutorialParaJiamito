package sieteymedia.utils;

import sieteymedia.game.models.Carta;
import sieteymedia.game.models.Palo;
import sieteymedia.game.models.Valor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    public static void barajar(List<Carta> cartas) {
        Collections.shuffle(cartas);
    }

    public static List<Carta> generarBaraja() {
        List<Carta> cartas = new ArrayList<>();

        for (Palo palo : Palo.values()) {
            for (Valor valor : Valor.values()) {
                cartas.add(new Carta(palo, valor));
            }
        }
        return cartas;
    }
}
