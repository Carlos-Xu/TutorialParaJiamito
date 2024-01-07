package sieteymedia.game.models;

import java.util.HashMap;

public class GameState {
    public final HashMap<Jugador, PlayerGameState> playerGameStates;
    public final Boolean hasReminingCards;
    public final Boolean gameEnded;

    public GameState(HashMap<Jugador, PlayerGameState> playerGameStates, Boolean hasReminingCards, Boolean gameEnded) {
        this.playerGameStates = playerGameStates;
        this.hasReminingCards = hasReminingCards;
        this.gameEnded = gameEnded;
    }
}
