package tutorial1

private const val MAX_TURNS = 10
private const val TIME_PER_TURN = 1_000L // millis
private const val TABLE_SIZE = 7
//private const val LUKE = -1
private const val CASILLA_VACIA = 0


fun main() {
    val table = initializeGame()

    // play game
    for (turnNumber in 0 until MAX_TURNS) {
        var readTable = clonarMatriz(table)
        var writeTable = clonarMatriz(table)



        playTurn(readTable, writeTable)
        printTurnReport(table)
        Thread.sleep(TIME_PER_TURN)
    }

    printFinalReport(table)
            printTurnReport(table)

}

private fun initializeGame(): Array<IntArray> {
    var table = Array(TABLE_SIZE) { IntArray(TABLE_SIZE) }

    var numEnemigos = pedirNumEnemigos()
    placeLuke(table)
    placeEnemies(table, numEnemigos)

    return table
}

private fun placeEnemies(table: Array<IntArray>, totalEnemigos: Int): Array<IntArray> {
    var yaColocados = 0
    var fila: Int
    var columna: Int

    do {
        var aColocar = (2..5).random()
        var pendientesDeColocar = totalEnemigos - yaColocados
        var restantesParaLaSiguiente = pendientesDeColocar - aColocar

        // ajustar el random
        if (aColocar > pendientesDeColocar) {
            aColocar = pendientesDeColocar
        }

        // despu'es de este punto aColocar nunca va a ser mayor que pendientesDeColocar
        if (restantesParaLaSiguiente == 1) {
            if (pendientesDeColocar == 3) {
                aColocar = 3
            } else {
                aColocar -= 1
            }
        }

        do {
            fila = (0 until TABLE_SIZE).random()
            columna = (0 until TABLE_SIZE).random()
        } while (table[fila][columna] != CASILLA_VACIA)

        table[fila][columna] = aColocar
        yaColocados += aColocar
    } while (yaColocados < totalEnemigos)

    return table

}

private fun pedirNumEnemigos(): Int {
    val regex = Regex("\\d+")
    var numEnemigos: String = ""
    do {
        println("Cuantos enemigos quieres? ")
        numEnemigos = readln()
        if (!regex.matches(numEnemigos) || (numEnemigos.toInt() !in 10..25)) {
            println("Debes introducir un número que esté entre 10 y 25 :)")
        }
    } while (!regex.matches(numEnemigos) || (numEnemigos.toInt() !in 10..25))
    return numEnemigos.toInt()
}

fun placeLuke(table: Array<IntArray>) {
    table[table.indices.random()][table.indices.random()] = LUKE
}


private fun playTurn(readTable: Array<IntArray>, writeTable: Array<IntArray>) {



}

private fun printTurnReport(currentTable: Array<IntArray>) {
    for (fila in currentTable.indices) {
        for (columna in currentTable[fila].indices) {
            if (columna == currentTable.size - 1) {
                println("${currentTable[fila][columna]} ")
            } else {
                print("${currentTable[fila][columna]} ")
            }
        }
    }

    // print separator
    println()
}


private fun printFinalReport(currentTable: Array<IntArray>) {

}

//fun clonarMatriz(matriz: Array<IntArray>): Array<IntArray> {
//    val clon = Array(matriz.size) { IntArray(matriz[0].size) }
//    for (i in matriz.indices) {
//        for (j in matriz[0].indices) {
//            clon[i][j] = matriz[i][j]
//        }
//    }
//    return clon
//}
