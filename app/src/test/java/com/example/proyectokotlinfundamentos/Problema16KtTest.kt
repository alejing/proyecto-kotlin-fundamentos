package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema16KtTest {
    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "4\n2\n6\n2\n10\n7\n7\n4\n21\n6\n6\n6\n6\n6\n35\n7\n1\n99\n300\n100\n3000\n348\n41\n6183\n387\n13\n2709\n1\n1\n2\n"
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
    fun problema16_esCorrecto() {
        // Ejecutamos la función
        repeat(10) {
            problema16()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas
        val caso1 = "n:"+ls+"m:"+ls+"k:"+ls+"SÍ"+ls
        val caso2 = "n:"+ls+"m:"+ls+"k:"+ls+"NO"+ls
        val caso3 = "n:"+ls+"m:"+ls+"k:"+ls+"SÍ"+ls
        val caso4 = "n:"+ls+"m:"+ls+"k:"+ls+"SÍ"+ls
        val caso5 = "n:"+ls+"m:"+ls+"k:"+ls+"NO"+ls
        val caso6 = "n:"+ls+"m:"+ls+"k:"+ls+"NO"+ls
        val caso7 = "n:"+ls+"m:"+ls+"k:"+ls+"SÍ"+ls
        val caso8 = "n:"+ls+"m:"+ls+"k:"+ls+"NO"+ls
        val caso9 = "n:"+ls+"m:"+ls+"k:"+ls+"SÍ"+ls
        val caso10 = "n:"+ls+"m:"+ls+"k:"+ls+"NO"+ls

        val expectedOutput = caso1 + caso2 + caso3 + caso4 + caso5 + caso6 + caso7 + caso8 + caso9 + caso10

        assertEquals(expectedOutput, outContent.toString())
    }
}