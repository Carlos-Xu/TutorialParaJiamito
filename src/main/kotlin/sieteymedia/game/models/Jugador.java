package sieteymedia.game.models;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Jugador {

    private final String nombre;
    private final UUID id;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.id = UUID.randomUUID();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(id, jugador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
