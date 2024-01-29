package com.example.proyectokotlinfundamentos

import org.junit.Test
import org.junit.Assert.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Problema1KtTest {

    @Test
    fun problema1_esCorrecto() {
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
        val caso = "Hola Mundo Kotlin!" + System.lineSeparator()
        problema1()
        assertEquals(caso, outContent.toString())
    }
}