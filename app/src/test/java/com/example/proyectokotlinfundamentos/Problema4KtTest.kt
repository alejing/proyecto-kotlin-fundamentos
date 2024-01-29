package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema4KtTest {

    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "100\n125\n354\n122\n32\n14\n"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))

        // Capturamos las salidas del sistema
        outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
    }

    @After
    fun restoreStreams() {
        // restaura System.in y System.out a sus estados originales después de cada prueba.
        System.setIn(originalIn)
        System.setOut(originalOut)
    }

    @Test
    fun problema4_esCorrecto() {
        // Ejecutamos la función
        repeat(2) {
            problema4()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas

        val caso1 = "Ingresa valor artículo 1:"+ls+"Ingresa valor artículo 2:"+ls+"Ingresa valor artículo 3:"+ls+"Valor neto: 579.0"+ls+"Valor total: 683.2199999999999"+ls
        val caso2 = "Ingresa valor artículo 1:"+ls+"Ingresa valor artículo 2:"+ls+"Ingresa valor artículo 3:"+ls+"Valor neto: 168.0"+ls+"Valor total: 198.23999999999998"+ls

        val expectedOutput = caso1 + caso2

        assertEquals(expectedOutput, outContent.toString())
    }
}