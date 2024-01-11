package sieteymedia.server;

import sieteymedia.game.models.Jugador;
import sieteymedia.server.models.Connection;

public class OptionAsker implements Runnable {

    private final Connection connection;
    private final Jugador player;

    private final AskedOptionsStore askedOptionsStore;

    public OptionAsker(Connection connection, Jugador player, AskedOptionsStore askedOptionsStore) {
        this.connection = connection;
        this.player = player;
        this.askedOptionsStore = askedOptionsStore;
    }

    @Override
    public void run() {
        imprimirMenuDeOpciones();
        boolean continuar = leerSiContinua();
        synchronized (askedOptionsStore) {
            askedOptionsStore.setDesiredOption(player, continuar);
            askedOptionsStore.notify();
        }
    }

    private boolean leerSiContinua() {
        String optionStr = connection.readFromInput();

        try {
            int intOption = Integer.parseInt(optionStr);
            return switch (intOption) {
                case 1 -> true; // continuar
                case 2 -> false; // parar
                default -> false;
            };
        } catch (Exception e) {
            return false;
        }
    }

    private void imprimirMenuDeOpciones() {
        connection.writeToOutput("Oye, que quieres?");
    }
}
