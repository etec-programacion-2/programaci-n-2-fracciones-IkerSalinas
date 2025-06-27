package org.example

fun main() {
    try {
        println("=== CREACIÓN DE FRACCIONES ===")
        val fraccion1 = Fraccion(3, 4)
        val fraccion2 = Fraccion(2, 6)
        val fraccion3 = Fraccion(-1, 3)
        val fraccion4 = Fraccion(5, -10)
        
        println("Fracción 1: $fraccion1")
        println("Fracción 2: $fraccion2")
        println("Fracción 3: $fraccion3")
        println("Fracción 4: $fraccion4")
        
        println("\n=== SIMPLIFICACIÓN ===")
        println("Fracción 2 original: $fraccion2")
        println("Fracción 2 simplificada: ${fraccion2.obtenerSimplificada()}")
        println("Fracción 4 original: $fraccion4")
        println("Fracción 4 simplificada: ${fraccion4.obtenerSimplificada()}")
        
        println("\n=== OPERACIONES DE SUMA ===")

        val suma1 = fraccion1 + fraccion2
        println("$fraccion1 + $fraccion2 = $suma1")

        val suma2 = fraccion1 + fraccion3
        println("$fraccion1 + $fraccion3 = $suma2")

        val suma3 = fraccion3 + fraccion4.obtenerSimplificada()
        println("$fraccion3 + ${fraccion4.obtenerSimplificada()} = $suma3")
        
        println("\n=== OPERACIONES DE RESTA ===")

        val resta1 = fraccion1 - fraccion2
        println("$fraccion1 - $fraccion2 = $resta1")
        

        val resta2 = fraccion1 - fraccion3
        println("$fraccion1 - $fraccion3 = $resta2")

        val resta3 = fraccion3 - fraccion4.obtenerSimplificada()
        println("$fraccion3 - ${fraccion4.obtenerSimplificada()} = $resta3")
        
        println("\n=== OPERACIONES ENCADENADAS ===")
 
        val operacionCompleja = (fraccion1 + fraccion2) - fraccion3
        println("($fraccion1 + $fraccion2) - $fraccion3 = $operacionCompleja")
        
        println("\n=== CASOS ESPECIALES ===")
        val fraccionCero = Fraccion(0, 5)
        val fraccionUno = Fraccion(7, 7)
        println("Fracción cero: $fraccionCero")
        println("Fracción uno: ${fraccionUno.obtenerSimplificada()}")
        println("Cero + 3/4 = ${fraccionCero + fraccion1}")
        println("Uno + 3/4 = ${fraccionUno.obtenerSimplificada() + fraccion1}")
        
        println("\n=== CASOS DE ERROR (comentados) ===")

    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}