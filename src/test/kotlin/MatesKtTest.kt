import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MatesKtTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun sumar() {
        

        val entradas = arrayOf(
            Pair(1, 4),
            Pair(9, 6),
            Pair(4,10)
        )

        val respuestasEsperadas = arrayOf(
            5,
            15,
            14
        )

        for (index in entradas.indices) {
            val entry = entradas[index]
            val respuestaEsperada = respuestasEsperadas[index]

            val respuestaGenerada = tutorial1.sumar(entry.first, entry.second)

            assertEquals(respuestaEsperada, respuestaGenerada)
        }
    }

    @Test
    fun dividir() {
    }

    @Test
    fun dividir_casosRaros() {

    }
}