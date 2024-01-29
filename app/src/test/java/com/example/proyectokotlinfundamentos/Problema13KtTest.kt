package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema13KtTest {
    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "123\n321\n112\n211\n121\n"
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
    fun problema13_esCorrecto() {
        // Ejecutamos la función
        repeat(5) {
            problema13()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas
        val caso1 = "Dame un numero:"+ls+"SÍ"+ls
        val caso2 = "Dame un numero:"+ls+"NO"+ls
        val caso3 = "Dame un numero:"+ls+"NO"+ls
        val caso4 = "Dame un numero:"+ls+"NO"+ls
        val caso5 = "Dame un numero:"+ls+"NO"+ls

        val expectedOutput = caso1 + caso2 + caso3 + caso4 + caso5

        assertEquals(expectedOutput, outContent.toString())
    }
}