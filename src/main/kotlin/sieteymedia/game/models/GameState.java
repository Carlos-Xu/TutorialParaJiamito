package sieteymedia.game.models;

import java.util.HashMap;

public class GameState {
    public final HashMap<Jugador, PlayerGameState> playerGameStates;
    public final Boolean hasReminingCards;

    public GameState(HashMap<Jugador, PlayerGameState> playerGameStates, Boolean hasReminingCards) {
        this.playerGameStates = playerGameStates;
        this.hasReminingCards = hasReminingCards;
    }
}
