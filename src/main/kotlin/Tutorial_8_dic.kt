

class Coche {

    val id: Int = createId()

    fun arrancar() {

    }

    companion object {
        private var nextId = 0

        fun createId(): Int {
            return nextId++
        }
    }

}

fun main() {
    val coches = (0 until 10).map { Coche() }

    coches.forEach {
        println(it.id)
    }
}