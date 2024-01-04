package tutorial1//const val LUKE = -1
//const val LIBRE = 0
//
//
//fun main() {
//    val MINSHIELDS = 0
//    val SHIELDS = 10
//    var size = 7
//
//    val TABLEROVACIO = Array(size) { IntArray(size) }
//    var TABLEROCONLUKE = Array(size) { IntArray(size) }
//    imprimirTableroVacio(TABLEROVACIO)
//    println()
//    imprimirTableroConLuke(TABLEROCONLUKE)
//    var numEnemigos = pedirNumEnemigos()
//    imprimirTableroFinal(TABLEROCONLUKE, numEnemigos)
//
////    imprimirTableronConEnemigos(TABLERO, numEnemigos)
//}
//
//fun imprimirTableroFinal(TABLEROCONLUKE: Array<IntArray>, numEnemigos: Int) {
//    var TABLEROFINAL = TABLEROCONLUKE
//    for (i in TABLEROFINAL.indices) {
//        for (j in TABLEROFINAL[i].indices) {
//            var contador = 0
//            var enemigo = (2..5).random()
//            while (contador < numEnemigos) {
//
//                if (TABLEROFINAL[(0..6).random()][(0..6).random()] != LUKE) {
//                    TABLEROFINAL[(0..6).random()][(0..6).random()] = enemigo
//                    contador = contador + enemigo
//                }
//            }
//
//            if (j == TABLEROFINAL.size - 1) {
//                println("${TABLEROFINAL[i][j]} ")
//            } else {
//                print("${TABLEROFINAL[i][j]} ")
//            }
//        }
//    }
//}
//
//fun imprimirTableroConLuke(TABLEROCONLUKE: Array<IntArray>): Array<IntArray> {
//    var lukePlaced = false
//
//    for (i in TABLEROCONLUKE.indices) {
//        for (j in TABLEROCONLUKE[i].indices) {
//            if (!lukePlaced) {
//                TABLEROCONLUKE[(0..6).random()][(0..6).random()] = LUKE
//                lukePlaced = true
//            }
//            if (j == TABLEROCONLUKE.size - 1) {
//                println("${TABLEROCONLUKE[i][j]} ")
//            } else {
//                print("${TABLEROCONLUKE[i][j]} ")
//            }
//        }
//    }
//    return TABLEROCONLUKE
//}
//
//
////fun imprimirTableronConEnemigos(TABLERO: Array<IntArray>, numEnemigos: Int) {
////    var e = numEnemigos
////    var enemigos = (2..5).random()
////    var contador = 0
////    for (fila in TABLERO.indices) {
////        for (columna in TABLERO[fila].indices) {
////            fila == (0..6).random()
////            columna == (0..6).random()
////            while (contador < numEnemigos){
////                TABLERO[fila][columna] = enemigos
////                contador = contador + enemigos
////                println(TABLERO[fila][columna])
////            }
////
////        }
////    }
////}
//
//private fun pedirNumEnemigos(): Int {
//    val regex = Regex("\\d+")
//    var numEnemigos: String = ""
//    do {
//        println("Cuantos enemigos quieres? ")
//        numEnemigos = readln()
//        if (!regex.matches(numEnemigos) || (numEnemigos.toInt() !in 10..25)) {
//            println("Debes introducir un número que esté entre 10 y 25 :)")
//        }
//    } while (!regex.matches(numEnemigos) || (numEnemigos.toInt() !in 10..25))
//    return numEnemigos.toInt()
//}
//
//
//fun imprimirTableroVacio(TABLEROVACIO: Array<IntArray>) {
//    for (fila in TABLEROVACIO.indices) {
//        for (columna in TABLEROVACIO[fila].indices) {
//            if (columna == TABLEROVACIO.size - 1) {
//                println("${TABLEROVACIO[fila][columna]} ")
//            } else {
//                print("${TABLEROVACIO[fila][columna]} ")
//            }
//        }
//
//    }
//}
//
//
