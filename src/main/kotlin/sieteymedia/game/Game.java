package sieteymedia.game;

import sieteymedia.game.models.Carta;
import sieteymedia.game.models.GameState;
import sieteymedia.game.models.Jugador;
import sieteymedia.game.models.PlayerGameState;
import sieteymedia.utils.Utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Game {

    private final List<Jugador> players;

    private final List<Carta> banca = Utils.generarBaraja();

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

    public GameState playRound(List<Jugador> jugadoresQueSeHanPlantado) {
        for (Jugador jugador : jugadoresQueSeHanPlantado) {
            PlayerGameState playerGameState = playerGameStates.get(jugador);
            playerGameState.setSeHaPlantado();
        }

        for (Jugador player : players) {
            PlayerGameState playerGameState = playerGameStates.get(player);

            if (playerGameState == null) {
                continue;
            }
            if (banca.isEmpty()) {
                break;
            }

            if (playerGameState.canContinue()) {
                Carta newCard = banca.remove(1);
                playerGameState.addCard(newCard);
            }
        }

        return collectState();
    }

    private GameState collectState() {
        return new GameState(playerGameStates, isGameFinished());
    }

    // Helper functions

    private boolean isGameFinished() {
        if (banca.isEmpty()) {
            return true;
        }

        Stream<PlayerGameState> playerStates = players
                .stream()
                .map(playerGameStates::get);

        List<PlayerGameState> notElimintedPlayers = playerStates
                .filter(playerGameState -> !playerGameState.isEliminated())
                .toList();
        if (notElimintedPlayers.size() <= 1) {
            return true;
        }

        List<PlayerGameState> remainingPlayers = notElimintedPlayers
                .stream()
                .filter(playerGameState -> !playerGameState.isSeHaPlantado())
                .toList();

        if (remainingPlayers.isEmpty()) {
            return true;
        }

        return false;
    }
}
