package sieteymedia.server;



import sieteymedia.models.Carta;
import sieteymedia.models.Jugador;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sieteymedia.utils.Utils.barajar;
import static sieteymedia.utils.Utils.calcularPuntos;


public class Servidor implements Runnable {

    private final static int PUERTO = 9000;
    private static final int NUM_JUGADORES = 4;
    private final List<Jugador> jugadores;
    private boolean juegoAcabado = false;
    List<Carta> banca = generarBaraja();


    public Servidor() {
        jugadores = new ArrayList<>();
    }


    @Override
    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(PUERTO)) {

            System.out.println("Servidor iniciado. Esperando jugadores...\n" );

            while (jugadores.size() < NUM_JUGADORES) {
                System.out.println("Running while block...");

                Socket clienteSocket = serverSocket.accept();
                DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());
                Jugador jugador = new Jugador(clienteSocket, Collections.emptyList());
                jugadores.add(jugador);

                System.out.println("Jugador conectado: " + jugador.getNombre() +
                        " (IP: " + jugador.getIP() + ", Puerto: " + jugador.getPuerto() + ")\n");

                salida.writeUTF("Bienvenido al juego de las 7 y 1/2 " + jugador.getNombre()+"!!\n");

            }

            System.out.println();
            enviarMensajeATodos("Comenzando el juego...");
            System.out.println("Todos los jugadores han llegado. Comenzando el juego...\n");

            // Lógica del juego aquí
            barajar(banca);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enviarMensajeATodos(String mensaje) {
        for (Jugador jugador : jugadores) {
            try {
                DataOutputStream salida = new DataOutputStream(jugador.getSocket().getOutputStream());
                salida.writeUTF(mensaje);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Carta> generarBaraja() {

        List<Carta> cartas = new ArrayList<>();
        String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey"};

        for (String palo : palos) {
            for (String valor : valores) {
                double puntos = calcularPuntos(valor);
                cartas.add(new Carta(palo, valor, puntos));
            }
        }
        return cartas;

    }
}
