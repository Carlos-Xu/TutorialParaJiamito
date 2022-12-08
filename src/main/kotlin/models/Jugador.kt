package models

data class Jugador(val nombre: String, val dorsal: Int, val demarcacion: Demarcaciones, val idSeleccion: Int){

    val ID: Int = nextID()

    companion object{
        private var nextID = 0
        fun nextID(): Int{
            return nextID++
        }
    }

    enum class Demarcaciones{
        Delantero, Portero, Defensa, CentroCampista
    }

}