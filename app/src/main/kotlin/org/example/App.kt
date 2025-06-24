package org.example

fun main() {
    try {
        // Crear una fracción válida
        val fraccion1 = Fraccion(3, 4)
        println("Fracción 1: ${fraccion1.toString()}")
        fraccion1.mostrar()
        
        // Cambiar valores usando setters
        fraccion1.numerador = 5
        fraccion1.denominador = 8
        println("Fracción 1 modificada: $fraccion1")
        
        // Crear otra fracción
        val fraccion2 = Fraccion(-2, 0)
        println("Fracción 2: $fraccion2")
        fraccion2.mostrar()

    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}