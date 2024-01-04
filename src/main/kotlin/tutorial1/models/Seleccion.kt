package tutorial1.models


data class Seleccion(val name: String, val pais: Pais){

    val ID: Int = nextID()

    companion object{
        private var nextID = 0
        fun nextID(): Int{
            return nextID++
        }
    }

}

