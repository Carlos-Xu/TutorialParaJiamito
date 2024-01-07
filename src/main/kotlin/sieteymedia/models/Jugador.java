package sieteymedia.models;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class Jugador {

    private Socket socket;
    private String nombre;

    private List<Carta> cartas;

    public Jugador(Socket socket, List<Carta> cartas) {
        this.socket = socket;
        this.nombre = obtenerNombre();
        this.cartas = cartas;
    }



    public String getNombre() {
        return nombre;
    }

    public String getIP() {
        return socket.getInetAddress().getHostAddress();
    }

    public int getPuerto() {
        return socket.getPort();
    }

    public Socket getSocket(){
        return this.socket;
    }

    private String obtenerNombre() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            nombre = entrada.readUTF();
            return nombre;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
