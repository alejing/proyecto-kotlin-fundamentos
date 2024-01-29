package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema2KtTest {

    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "10\n9\n-10\n9\n-3\n-8\n3\n-8\n"
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
    fun problema2_esCorrecto() {
        // Ejecutamos la función
        repeat(4) {
            problema2()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas
        val caso1 = "Ingresa a:"+ls+"Ingresa b:"+ls+"10 + 9 = 19"+ls
        val caso2 = "Ingresa a:"+ls+"Ingresa b:"+ls+"-10 + 9 = -1"+ls
        val caso3 = "Ingresa a:"+ls+"Ingresa b:"+ls+"-3 + -8 = -11"+ls
        val caso4 = "Ingresa a:"+ls+"Ingresa b:"+ls+"3 + -8 = -5"+ls
        val expectedOutput = caso1 + caso2 + caso3 + caso4

        assertEquals(expectedOutput, outContent.toString())
    }
}