package sieteymedia.server.models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {

    private final Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
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

    public String readFromInput() {
        try(DataInputStream entrada = new DataInputStream(socket.getInputStream())) {
            return entrada.readUTF().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void writeToOutput(String msg) {
        try(DataOutputStream salida = new DataOutputStream(socket.getOutputStream())) {
            salida.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
