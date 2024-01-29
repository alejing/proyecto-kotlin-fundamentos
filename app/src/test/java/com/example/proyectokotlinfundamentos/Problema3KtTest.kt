package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema3KtTest {

    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "matemáticas\n2.5\n2.5\n2.5\nprogramación\n3.1\n2.8\n4.3\n"
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
    fun problema3_esCorrecto() {
        // Ejecutamos la función
        repeat(2) {
            problema3()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas
        val caso1 = "Ingresa la asignatura:"+ls+"Ingresa nota primer corte:"+ls+"Ingresa nota segundo corte:"+ls+"Ingresa nota tercer corte:"+ls+"Asignatura: matemáticas"+ls+"Definitiva: 2.5"+ls
        val caso2 = "Ingresa la asignatura:"+ls+"Ingresa nota primer corte:"+ls+"Ingresa nota segundo corte:"+ls+"Ingresa nota tercer corte:"+ls+"Asignatura: programación"+ls+"Definitiva: 3.409"+ls
        val expectedOutput = caso1 + caso2

        assertEquals(expectedOutput, outContent.toString())
    }

}