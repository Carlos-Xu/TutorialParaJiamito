package sieteymedia;


import sieteymedia.server.Servidor;

public class Main {
    public static void main(String[] args){
        Servidor servidor = new Servidor();
        Thread serverThread = new Thread(servidor);
        serverThread.start();
    }
}
