package sieteymedia.game.models;

import sieteymedia.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class PlayerGameState {
    public final Jugador player;
    private final List<Carta> cards = new ArrayList<>();
    private boolean seHaPlantado = false;

    public PlayerGameState(Jugador player) {
        this.player = player;
    }

    public List<Carta> getCards() {
        return cards;
    }

    public void addCard(Carta card) {
        cards.add(card);
    }

    public void setSeHaPlantado() {
        seHaPlantado = true;
    }

    public boolean isSeHaPlantado() {
        return seHaPlantado;
    }

    public float currentPoints() {
        float score = 0;
        for (Carta card : cards) {
            score += card.getPoints();
        }
        return score;
    }

    public boolean isEliminated() {
        return currentPoints() > Constants.TARGET_POINTS;
    }

    public boolean canContinue() {
        return !isSeHaPlantado() && !isEliminated();
    }

}
