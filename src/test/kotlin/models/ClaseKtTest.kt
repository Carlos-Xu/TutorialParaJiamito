package models

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import salirONo

internal class ClaseKtTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun test_salirONo() {
        val entradasYSalidas = mutableMapOf(
            "s" to true,
            "n" to false,
            "hola mundo" to false
        )

        for (item in entradasYSalidas) {
            val entrada = item.key
            val salidaEsperada = item.value
            val salidaReal = salirONo(entrada)
            assertEquals(salidaEsperada, salidaReal, "Expected $salidaEsperada for input $entrada")
        }
    }

    @Test
    fun validarConfirmacionSalir() {

    }
}