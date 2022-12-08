package dao

import models.Jugador

class JugadorCRUD {

    fun createJugador(nombre: String, dorsal: Int, demarcacion: Jugador.Demarcaciones, idSeleccion: Int): Jugador? {
        val newJugador = Jugador(nombre = nombre, dorsal = dorsal, demarcacion = demarcacion, idSeleccion = idSeleccion)

        val seleccionExists = simulatedSeleccionDatabase.any { it.ID == idSeleccion }

        if (!seleccionExists) {
            return null
        }

        simulatedJugadorDatabase.add(newJugador)

        return newJugador
    }

    fun getJugador(id: Int): Jugador? {
        return simulatedJugadorDatabase.first { it.ID == id }
    }

    fun getJugadores(): Array<Jugador> {
        return simulatedJugadorDatabase.toTypedArray()
    }

    fun updateJugador(id: Int, updatedData: Jugador): Boolean {
        if (updatedData.ID != id) {
            return false
        }

        val targetIndex = simulatedJugadorDatabase.indexOfFirst { it.ID == id }
        if (targetIndex < 0) {
            return false
        }

        simulatedJugadorDatabase[targetIndex] = updatedData

        return true
    }

    fun updateJugador(id: Int, updateBlock: (Jugador) -> Jugador): Boolean {
        val targetIndex = simulatedJugadorDatabase.indexOfFirst { it.ID == id }
        if (targetIndex < 0) {
            return false
        }

        val oldData = simulatedJugadorDatabase[targetIndex]
        val newData = updateBlock(oldData)

        if (newData.ID != oldData.ID) {
            return false
        }

        simulatedJugadorDatabase[targetIndex] = newData

        return true
    }

    fun delete(id: Int): Boolean {
        val targetIndex = simulatedJugadorDatabase.indexOfFirst { it.ID == id }
        if (targetIndex < 0) {
            return false
        }

        simulatedJugadorDatabase.removeAt(targetIndex)
        return true
    }

}