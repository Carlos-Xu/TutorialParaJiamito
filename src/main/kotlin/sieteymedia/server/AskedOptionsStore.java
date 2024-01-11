package sieteymedia.server;

import sieteymedia.game.models.Jugador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AskedOptionsStore {

    private final int playersAsked;
    private final HashMap<Jugador, Boolean> wantToContinueResponse;

    public AskedOptionsStore(int playersAsked) {
        this.playersAsked = playersAsked;
        wantToContinueResponse = new HashMap<>(playersAsked);
    }

    public void setDesiredOption(Jugador player, boolean option) {
        wantToContinueResponse.put(player, option);
    }

    public boolean hasAllPlayersResponded() {
        return wantToContinueResponse.size() >= playersAsked;
    }

    public List<Jugador> playersWhoWantToPause() {
        return wantToContinueResponse
                .entrySet()
                .stream()
                .filter(entry -> !entry.getValue()) // only keep negative responses(they mean pause)
                .map(Map.Entry::getKey)
                .toList();
    }
}
