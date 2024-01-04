package tutorial1.models



data class Alumno(var ID: Int, var nombre: String, var calificacion: Double) {
    val calificacionRedondeada: Double get() = (calificacion * 100).toInt() / 100.0


    companion object{
        private var contador = 1
        private fun nextID() = contador++

        fun safeCreate(ID: Int, nombre: String, calificacion: Double): Alumno? {
            if (calificacion in 0.0..10.0) {
                return null
            }

            if (nombre.isNotEmpty()) {
                return null
            }

            return Alumno(ID = ID, nombre = nombre, calificacion = calificacion)
        }
    }

}





