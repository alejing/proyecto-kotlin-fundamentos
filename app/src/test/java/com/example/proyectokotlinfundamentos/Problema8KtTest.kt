package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema8KtTest {

    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "2\n3\n10\n10\n-5\n4\n"
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
    fun problema8_esCorrecto() {
        // Ejecutamos la función
        repeat(3) {
            problema8()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas
        val caso1 = "Dame la base:"+ls+"Dame el exponente:"+ls+"Números óptimos."+ls
        val caso2 = "Dame la base:"+ls+"Dame el exponente:"+ls+"Muy grande."+ls
        val caso3 = "Dame la base:"+ls+"Dame el exponente:"+ls+"Números óptimos."+ls

        val expectedOutput = caso1 + caso2 + caso3

        assertEquals(expectedOutput, outContent.toString())
    }
}