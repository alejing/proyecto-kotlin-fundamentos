package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema11KtTest {
    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "100\n20\n10\n5\n50\n1000\n200\n100\n200\n600\n"
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
    fun problema11_esCorrecto() {
        // Ejecutamos la función
        repeat(2) {
            problema11()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas
        val caso1 = "Dame el presupuesto:"+ls+"Dame el valor de la comida:"+ls+"Dame el valor de la electricidad:"+ls+"Dame el valor del internet:"+ls+"Dame el valor del arriendo:"+ls+"Vamos melos!"+ls
        val caso2 = "Dame el presupuesto:"+ls+"Dame el valor de la comida:"+ls+"Dame el valor de la electricidad:"+ls+"Dame el valor del internet:"+ls+"Dame el valor del arriendo:"+ls+"Rayos estoy quebrado(a)!"+ls

        val expectedOutput = caso1 + caso2

        assertEquals(expectedOutput, outContent.toString())
    }
}