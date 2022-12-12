import models.Alumno



fun main() {

    //5 alumnos
    val a1 = Alumno(ID = 4, nombre = "Antonio", calificacion = 2.255446545)
    val a2 = Alumno(ID = 1, nombre = "Juan", calificacion = 4.15155465)
    val a3 = Alumno(ID = 3, nombre = "Pepito", calificacion = 7.656454654)
    val a4 = Alumno(ID = 5, nombre = "Laura", calificacion = 6.2549874)
    val a5 = Alumno(ID = 2, nombre = "Carlos", calificacion = 10.0000000000)

    val clase = Array<Alumno?>(30) { null }

    clase[0] = a1
    clase[1] = a2
    clase[2] = a3
    clase[3] = a4
    clase[4] = a5

    do {
        when (seleccionarOpcion()) {
            1 -> ordenarAlumnosPorNotaDesc(clase)
            2 -> obtenerAlumnoPorID(clase)
            3 -> crearAlumnoNuevo(clase)
            4 -> salir()
        }
    } while (!salir())

//    ordenarAlumnosPorNotaDesc(clase)
//    println()
//    obtenerAlumnoPorID(clase)
//    println()
//    // para crear, buscamos en el array el primer null, y creamos ahí el nuevo alumno.
//    crearAlumnoNuevo(clase)
//    ordenarAlumnosPorNotaDesc(clase)ZZ

}

fun salir(): Boolean {
    when (confirmacion()) {
        "s" -> return true
        "n" -> return false
    }
    return true
}

fun confirmacion(): String {
    var regex = """[s]||[n]""".toRegex()
    do {
        println("¿REALMENTE QUIERES SALIR? s/n")
        var respuesta = readln()
        if (!regex.matches(respuesta)) {
            println("Introduce S o N")
        } else {
            return respuesta
        }
    } while (!regex.matches(respuesta))
    return "0"
}

fun seleccionarOpcion(): Int {

    println()
    println("*** SELECCIONA UNA OPCION ***")
    println()
    println("1 -> ordenarAlumnosPorNotaDesc(clase)")
    println("2 -> obtenerAlumnoPorID(clase)")
    println("3 -> crearAlumnoNuevo(clase)")
    println("4 -> salir()")

    do {
        print("Opción seleccionada: ")
        var opcion = readln().toInt()
        if (opcion > 4 || opcion < 1) {
            println("Opción no valida")
        } else {
            return opcion
        }
    } while (opcion > 4 || opcion < 1)
    return 0
}


private fun crearAlumnoNuevo(clase: Array<Alumno?>) {

    val regex = """[0-9]+[.]+[0-9]+""".toRegex()
    var i = 0
    var IDNuevo: Int = filtrarIDNuevo(clase)
    var nombreNuevo = getNombreNuevo()
    var calificacionNuevo: Double = filtrarCalificacionNueva(regex)

    val alumnoNuevo = Alumno(ID = IDNuevo, nombre = nombreNuevo, calificacion = calificacionNuevo)
    do {
        i++
    } while (clase[i] != null)

    if (clase[i] == null) {
        clase[i] = alumnoNuevo
    }
}

private fun getNombreNuevo(): String {
    println("Introduce el nombre del alumno nuevo: ")
    var nombreNuevo = readln()
    return nombreNuevo
}

private fun filtrarCalificacionNueva(regex: Regex): Double {
    do {
        println("Introduce la calificacion del alumno nuevo: ")
        var calificacionNuevo = readln().toDouble()
        if (!regex.matches(calificacionNuevo.toString()) || (calificacionNuevo > 10) || (calificacionNuevo < 1)) {
            println("La calificacion introducida es invalida")
        } else {
            return calificacionNuevo
        }
    } while (!regex.matches(calificacionNuevo.toString()) || (calificacionNuevo > 10) || (calificacionNuevo < 1))
    return 0.0
}

private fun filtrarIDNuevo(clase: Array<Alumno?>): Int {
    do {
        println("Introduce el ID del alummno nuevo que vas a crear: ")
        var IDNuevo = readln().toInt()
        comprobarIDNoUsado(clase, IDNuevo)
        if (!comprobarIDNoUsado(clase, IDNuevo)) {
            println("Ese ID ya ha sido utilizado, elige otro")
        } else {
            return IDNuevo
        }
    } while (!comprobarIDNoUsado(clase, IDNuevo))
    return 0
}

private fun comprobarIDNoUsado(clase: Array<Alumno?>, IDNuevo: Int): Boolean {
    var i = 0
    for (j in clase.indices) {

        if (clase[i]?.ID == IDNuevo) {
            return false
        } else {
            i++
        }
    }
    return true
}


private fun obtenerAlumnoPorID(clase: Array<Alumno?>): Array<Alumno?> {

    println("*** OBTENER ALUMNO POR ID ***")
    println("Dí el ID del alumno que quieres buscar: ")
    val idBuscado = readln().toInt()

    var i = 0
    do {
        if (clase[i]?.ID == idBuscado) {
            println("El alumno buscado es ${clase[i]}")
            return clase
        } else {
            i++
        }
    } while (i < 30)
    println("El alumno buscado no existe")
    return clase
}


private fun ordenarAlumnosPorNotaDesc(clase: Array<Alumno?>): Array<Alumno?> {
    println("Alumnos ordenados por nota: ")
    var aux: Alumno?
    for (i in clase.indices) {
        for (j in clase.indices) {
            if (clase[j] != null && clase[j + 1] != null) {
                if ((clase[j + 1]?.calificacionRedondeada ?: 0.0) > (clase[j]?.calificacionRedondeada ?: 0.0)) {
                    aux = clase[j]
                    clase[j] = clase[j + 1]
                    clase[j + 1] = aux
                }
            }
        }
    }
    for (i in clase.indices) {
        if (clase[i] != null) {
            println(clase[i])
        }
    }
    return clase
}


