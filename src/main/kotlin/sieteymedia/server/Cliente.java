package sieteymedia.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

import java.util.Scanner;

public class Cliente {
    private static final int PUERTO = 9000;
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {

        System.out.print("Introduce tu nombre: ");
        try (Socket socket = new Socket(SERVER_IP, PUERTO)) {
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            Scanner sc = new Scanner(System.in);

            String nombreJugador = sc.nextLine();
            salida.writeUTF(nombreJugador);

            String mensajeBienvenida = entrada.readUTF();
            System.out.println();
            System.out.println("Servidor: " + mensajeBienvenida);
            System.out.println("Esperando al resto de jugadores...");

            while (!mensajeBienvenida.equals("Comenzando el juego...")) {
                mensajeBienvenida = entrada.readUTF();
                System.out.println("Servidor: " + mensajeBienvenida);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
