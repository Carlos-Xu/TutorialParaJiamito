package sieteymedia.game.models;

import java.util.HashMap;

public class GameState {
    public final HashMap<Jugador, PlayerGameState> playerGameStates;
    public final Boolean gameEnded;

    public GameState(HashMap<Jugador, PlayerGameState> playerGameStates, Boolean gameEnded) {
        this.playerGameStates = playerGameStates;
        this.gameEnded = gameEnded;
    }
}
