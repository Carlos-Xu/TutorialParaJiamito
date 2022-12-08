package dao

import models.Pais
import models.Seleccion

class SeleccionCRUD {


    fun createSeleccion(name: String, pais: Pais): Seleccion {
        val newSeleccion = Seleccion(name, pais)

        simulatedSeleccionDatabase.add(newSeleccion)

        return newSeleccion
    }

    fun getSeleccion(id: Int): Seleccion? {
        return simulatedSeleccionDatabase.first { it.ID == id }
    }

    fun listSelecciones(): Array<Seleccion> {
        return simulatedSeleccionDatabase.toTypedArray()
    }

    fun updateSeleccion(id: Int, updatedData: Seleccion): Boolean {
        if (updatedData.ID != id) {
            return false
        }

        val targetIndex = simulatedSeleccionDatabase.indexOfFirst { it.ID == id }
        if (targetIndex < 0) {
            return false
        }

        simulatedSeleccionDatabase[targetIndex] = updatedData

        return true
    }

    fun updateSeleccion(id: Int, updateBlock: (Seleccion) -> Seleccion): Boolean {
        val targetIndex = simulatedSeleccionDatabase.indexOfFirst { it.ID == id }
        if (targetIndex < 0) {
            return false
        }

        val oldData = simulatedSeleccionDatabase[targetIndex]
        val newData = updateBlock(oldData)

        if (newData.ID != oldData.ID) {
            return false
        }

        simulatedSeleccionDatabase[targetIndex] = newData

        return true
    }

    fun delete(id: Int): Boolean {
        val targetIndex = simulatedSeleccionDatabase.indexOfFirst { it.ID == id }
        if (targetIndex < 0) {
            return false
        }

        simulatedSeleccionDatabase.removeAt(targetIndex)
        return true
    }

}



