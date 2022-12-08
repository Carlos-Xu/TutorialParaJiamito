fun main() {
    val intentosMaximos = 5
    var juegoTerminado = false
    val numMIN = 1
    val numMAX = 100

    println("Inicia el juego")

    while (!juegoTerminado) {
        var continuar = jugarPartida(numMIN, numMAX, intentosMaximos)
        juegoTerminado = continuar == false
    }
}

private fun jugarPartida(numMIN: Int, numMAX: Int, intentosMaximos: Int): Boolean {
    val numRandom = numeroRandom(numMIN, numMAX)

    var adivinado = false
    var intentoActual = 0
    while (!adivinado && intentoActual < intentosMaximos) {
        // inicia un intento
        adivinado = probarIntento(numRandom, adivinado)

        intentoActual++
    }

    imprimirResultadosDeLaPartida(adivinado, intentoActual, intentosMaximos)

    // termina la partida

    var continuar = askForKeepPlaying("Quieres continuar? [S/n] ")
    return continuar
}

private fun imprimirResultadosDeLaPartida(adivinado: Boolean, intentoActual: Int, intentosMaximos: Int) {
    if (adivinado) {
        println("Has ganado en $intentoActual intentos.")
    } else {
        println("No conseguiste adivinarlo en $intentosMaximos intentos.")
    }
}

private fun probarIntento(numRandom: Int, adivinado: Boolean): Boolean {
    print("Introduce un num: ")
    var adivinado1 = adivinado
    val input = readln().toInt()
    if (input == numRandom) {
        adivinado1 = true
        println("Ganaste!!")
    } else {
        if (input > numRandom) {
            println("El numero que has puesto es demasiado grande")
        } else {
            println("El numero que has puesto es demasiado pequeño")
        }
        println("Intentalo otra vez!")
    }
    return adivinado1
}

fun numeroRandom(numMin: Int, numMax: Int): Int {
    return (numMin..numMax).random()
}

fun askForKeepPlaying(mensaje: String): Boolean {
    print(mensaje)
    val respuesta = readln().lowercase()
    return respuesta == "s"
}