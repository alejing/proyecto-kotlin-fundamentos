package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema5KtTest {

    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "6\n50\n1\n10\n5\n25\n4\n2\n"
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
    fun problema5_esCorrecto() {
        // Ejecutamos la función
        repeat(4) {
            problema5()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas

        val caso1 = "e:"+ls+"m:"+ls+"Cada estudiante recibirá: 8 manzanas."+ls+"Quedarán en la canasta: 2 manzanas."+ls
        val caso2 = "e:"+ls+"m:"+ls+"Cada estudiante recibirá: 10 manzanas."+ls+"Quedarán en la canasta: 0 manzanas."+ls
        val caso3 = "e:"+ls+"m:"+ls+"Cada estudiante recibirá: 5 manzanas."+ls+"Quedarán en la canasta: 0 manzanas."+ls
        val caso4 = "e:"+ls+"m:"+ls+"Cada estudiante recibirá: 0 manzanas."+ls+"Quedarán en la canasta: 2 manzanas."+ls

        val expectedOutput = caso1 + caso2 + caso3 + caso4

        assertEquals(expectedOutput, outContent.toString())
    }
}