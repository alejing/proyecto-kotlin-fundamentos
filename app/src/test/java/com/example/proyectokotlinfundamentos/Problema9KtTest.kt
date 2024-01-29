package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema9KtTest {
    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "10\n2\n10\n20\n5\n-5\n"
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
    fun problema9_esCorrecto() {
        // Ejecutamos la función
        repeat(3) {
            problema9()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas
        val caso1 = "Dame num1:"+ls+"Dame num2:"+ls+"Wow!"+ls
        val caso2 = "Dame num1:"+ls+"Dame num2:"+ls+"Aburrido!"+ls
        val caso3 = "Dame num1:"+ls+"Dame num2:"+ls+"Wow!"+ls

        val expectedOutput = caso1 + caso2 + caso3

        assertEquals(expectedOutput, outContent.toString())
    }
}