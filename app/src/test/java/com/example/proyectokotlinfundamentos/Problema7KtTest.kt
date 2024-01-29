package com.example.proyectokotlinfundamentos

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class Problema7KtTest {
    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUpStreams() {
        // Simulamos las entradas del usuario
        val simulatedInput = "10\n0\n7\n-2\n"
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
    fun problema7_esCorrecto() {
        // Ejecutamos la función
        repeat(4) {
            problema7()
        }
        val ls = System.lineSeparator()
        // Verificamos las salidas
        val caso1 = "¿Cuántos sonidos del grillo escuchaste por minuto?"+ls+"Dados los sonidos del grillo, la temperatura es de 42.5 °F."+ls
        val caso2 = "¿Cuántos sonidos del grillo escuchaste por minuto?"+ls+"Dados los sonidos del grillo, la temperatura es de 40.0 °F."+ls
        val caso3 = "¿Cuántos sonidos del grillo escuchaste por minuto?"+ls+"Dados los sonidos del grillo, la temperatura es de 41.75 °F."+ls
        val caso4 = "¿Cuántos sonidos del grillo escuchaste por minuto?"+ls+"Seguro investigador, ¿un grillo puede hacer ese número de sonidos?"+ls

        val expectedOutput = caso1 + caso2 + caso3 + caso4

        assertEquals(expectedOutput, outContent.toString())
    }

}