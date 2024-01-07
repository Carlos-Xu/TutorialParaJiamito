package sieteymedia.server;


import sieteymedia.game.Game;
import sieteymedia.game.models.Jugador;
import sieteymedia.server.models.Connection;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Servidor implements Runnable {

    private final static int PUERTO = 9000;
    private static final int NUM_JUGADORES = 4;

    private final HashMap<Jugador, Connection> playerConnections = new HashMap<>(NUM_JUGADORES);

    public Servidor() {
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {

            System.out.println("Servidor iniciado. Esperando jugadores...\n");

            List<Jugador> jugadores = new ArrayList<>();

            while (jugadores.size() < NUM_JUGADORES) {
                Socket clienteSocket = serverSocket.accept();
                Connection connection = new Connection(clienteSocket);
                String name = connection.readFromInput();
                Jugador jugador = new Jugador(name);

                playerConnections.put(jugador, connection);
                jugadores.add(jugador);

                connection.writeToOutput("Bienvenido al juego de las 7 y 1/2 " + jugador.getNombre() + "!!\n");

                System.out.println("Jugador conectado: " + jugador.getNombre() +
                        " (IP: " + connection.getIP() + ", Puerto: " + connection.getPuerto() + ")\n");
            }

            System.out.println();
            enviarMensajeATodos("Comenzando el juego...");
            System.out.println("Todos los jugadores han llegado. Comenzando el juego...\n");

            // Lógica del juego aquí
            Game game = new Game(jugadores);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enviarMensajeATodos(String mensaje) {
        for (Connection conn : playerConnections.values()) {
            conn.writeToOutput(mensaje);
        }
    }
}
