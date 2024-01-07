package sieteymedia.models;

public class Carta {
    String palo;
    String valor;
    double puntos;

    public Carta(String palo, String valor, double puntos) {
        this.palo = palo;
        this.valor = valor;
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "palo='" + palo + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}