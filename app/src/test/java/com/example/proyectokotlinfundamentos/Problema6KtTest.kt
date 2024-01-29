package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema6KtTest {

    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "179\n829\n204\n100\n999\n483\n"
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
    fun problema6_esCorrecto() {
        // Ejecutamos la función
        repeat(6) {
            problema6()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas

        val caso1 = "Dame un número entero:"+ls+"La suma de los dígitos del número 179 es igual a 17."+ls
        val caso2 = "Dame un número entero:"+ls+"La suma de los dígitos del número 829 es igual a 19."+ls
        val caso3 = "Dame un número entero:"+ls+"La suma de los dígitos del número 204 es igual a 6."+ls
        val caso4 = "Dame un número entero:"+ls+"La suma de los dígitos del número 100 es igual a 1."+ls
        val caso5 = "Dame un número entero:"+ls+"La suma de los dígitos del número 999 es igual a 27."+ls
        val caso6 = "Dame un número entero:"+ls+"La suma de los dígitos del número 483 es igual a 15."+ls


        val expectedOutput = caso1 + caso2 + caso3 + caso4 + caso5 + caso6

        assertEquals(expectedOutput, outContent.toString())
    }
}