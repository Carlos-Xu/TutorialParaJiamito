package sieteymedia.game.models;

import java.util.ArrayList;
import java.util.List;

public class PlayerGameState {
    public final Jugador player;
    private final List<Carta> cards = new ArrayList<>();

    public PlayerGameState(Jugador player) {
        this.player = player;
    }

    public List<Carta> getCards() {
        return cards;
    }

    public void addCard(Carta card) {
        cards.add(card);
    }
}
