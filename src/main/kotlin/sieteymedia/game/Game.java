package sieteymedia.game;

import sieteymedia.game.models.Carta;
import sieteymedia.game.models.GameState;
import sieteymedia.game.models.Jugador;
import sieteymedia.game.models.PlayerGameState;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static sieteymedia.utils.Utils.generarBaraja;

public class Game {

    private final List<Jugador> players;

    private final List<Carta> banca = generarBaraja();

    private final HashMap<Jugador, PlayerGameState> playerGameStates;

    public Game(List<Jugador> players) {
        this.players = players;
        playerGameStates = new HashMap<>(players.size());
        for (Jugador player : players) {
            playerGameStates.put(player, new PlayerGameState(player));
        }
    }

    public GameState playInitialRound() {
        Collections.shuffle(banca);

        for (Jugador player : players) {
            Carta newCard = banca.remove(0);
            PlayerGameState playerGameState = playerGameStates.get(player);
            if (playerGameState != null) {
                playerGameState.addCard(newCard);
            }
        }

        return collectState();
    }

    public GameState playRound(HashMap<Jugador, StopOrTakeMore> selectedOptions) {
        for (Jugador player : players) {
            StopOrTakeMore option = selectedOptions.get(player);
            PlayerGameState playerGameState = playerGameStates.get(player);
            if (option == null) {
                continue;
            }
            if (playerGameState == null) {
                continue;
            }
            if (banca.isEmpty()) {
                break;
            }

            switch (option) {
                case STOP -> {
                }
                case TAKE_MORE -> {

                    Carta newCard = banca.remove(1);
                    playerGameState.addCard(newCard);
                }
            }
        }

        return collectState();
    }

    private GameState collectState() {
        return new GameState(playerGameStates, !banca.isEmpty());
    }
}
