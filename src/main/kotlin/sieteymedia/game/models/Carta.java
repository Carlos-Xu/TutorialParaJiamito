package sieteymedia.game.models;

public class Carta {
    Palo palo;
    Valor valor;

    public Carta(Palo palo, Valor valor) {
        this.palo = palo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "palo='" + palo + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

    public float getPoints() {
        return valor.points;
    }
}