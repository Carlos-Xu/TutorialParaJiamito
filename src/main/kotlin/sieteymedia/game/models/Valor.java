package sieteymedia.game.models;

public enum Valor {
    AS(1f),
    Carta_2(2f),
    Carta_3(3f),
    Carta_4(4f),
    Carta_5(5f),
    Carta_6(6f),
    Carta_7(7f),
    Sota(0.5f),
    Caballo(0.5f),
    Rey(0.5f);

    public final float points;

    Valor(float points) {
        this.points = points;
    }
}
