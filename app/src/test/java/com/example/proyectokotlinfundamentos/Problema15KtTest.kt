package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema15KtTest {
    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "1111\n4321\n1234\n1221\n1112\n2111\n"
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
    fun problema15_esCorrecto() {
        // Ejecutamos la función
        repeat(6) {
            problema15()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas
        val caso1 = "Dame un numero de 4 cifras:"+ls+"SÍ"+ls
        val caso2 = "Dame un numero de 4 cifras:"+ls+"NO"+ls
        val caso3 = "Dame un numero de 4 cifras:"+ls+"NO"+ls
        val caso4 = "Dame un numero de 4 cifras:"+ls+"SÍ"+ls
        val caso5 = "Dame un numero de 4 cifras:"+ls+"NO"+ls
        val caso6 = "Dame un numero de 4 cifras:"+ls+"NO"+ls

        val expectedOutput = caso1 + caso2 + caso3 + caso4 + caso5 + caso6

        assertEquals(expectedOutput, outContent.toString())
    }
}