package org.example
// Ejemplo de uso
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
        // 3/4 + 2/6 = (3*6 + 4*2)/(4*6) = (18 + 8)/24 = 26/24 = 13/12
        val suma1 = fraccion1 + fraccion2
        println("$fraccion1 + $fraccion2 = $suma1")
        
        // 3/4 + (-1/3) = (3*3 + 4*(-1))/(4*3) = (9 - 4)/12 = 5/12
        val suma2 = fraccion1 + fraccion3
        println("$fraccion1 + $fraccion3 = $suma2")
        
        // (-1/3) + 5/(-10) = (-1/3) + (-1/2) = ((-1)*2 + 3*(-1))/(3*2) = (-2 - 3)/6 = -5/6
        val suma3 = fraccion3 + fraccion4.obtenerSimplificada()
        println("$fraccion3 + ${fraccion4.obtenerSimplificada()} = $suma3")
        
        println("\n=== OPERACIONES DE RESTA ===")
        // 3/4 - 2/6 = (3*6 - 4*2)/(4*6) = (18 - 8)/24 = 10/24 = 5/12
        val resta1 = fraccion1 - fraccion2
        println("$fraccion1 - $fraccion2 = $resta1")
        
        // 3/4 - (-1/3) = 3/4 + 1/3 = (3*3 + 4*1)/(4*3) = (9 + 4)/12 = 13/12
        val resta2 = fraccion1 - fraccion3
        println("$fraccion1 - $fraccion3 = $resta2")
        
        // (-1/3) - (-1/2) = (-1/3) + (1/2) = ((-1)*2 + 3*1)/(3*2) = (-2 + 3)/6 = 1/6
        val resta3 = fraccion3 - fraccion4.obtenerSimplificada()
        println("$fraccion3 - ${fraccion4.obtenerSimplificada()} = $resta3")
        
        println("\n=== OPERACIONES ENCADENADAS ===")
        // (3/4 + 2/6) - (-1/3) = 13/12 - (-1/3) = 13/12 + 1/3
        val operacionCompleja = (fraccion1 + fraccion2) - fraccion3
        println("($fraccion1 + $fraccion2) - $fraccion3 = $operacionCompleja")
        
        println("\n=== OPERACIONES DE MULTIPLICACIÓN ===")
        // 3/4 * 2/6 = (3*2)/(4*6) = 6/24 = 1/4
        val multiplicacion1 = fraccion1 * fraccion2
        println("$fraccion1 * $fraccion2 = $multiplicacion1")
        
        // 3/4 * (-1/3) = (3*(-1))/(4*3) = -3/12 = -1/4
        val multiplicacion2 = fraccion1 * fraccion3
        println("$fraccion1 * $fraccion3 = $multiplicacion2")
        
        // (-1/3) * (-1/2) = ((-1)*(-1))/(3*2) = 1/6
        val multiplicacion3 = fraccion3 * fraccion4.obtenerSimplificada()
        println("$fraccion3 * ${fraccion4.obtenerSimplificada()} = $multiplicacion3")
        
        // Multiplicación por entero representado como fracción
        val fraccionEntero = Fraccion(2, 1)
        val multiplicacion4 = fraccion1 * fraccionEntero
        println("$fraccion1 * $fraccionEntero = $multiplicacion4")
        
        println("\n=== OPERACIONES DE DIVISIÓN ===")
        // 3/4 / 2/6 = 3/4 * 6/2 = (3*6)/(4*2) = 18/8 = 9/4
        val division1 = fraccion1 / fraccion2
        println("$fraccion1 / $fraccion2 = $division1")
        
        // 3/4 / (-1/3) = 3/4 * (-3/1) = (3*(-3))/(4*1) = -9/4
        val division2 = fraccion1 / fraccion3
        println("$fraccion1 / $fraccion3 = $division2")
        
        // (-1/3) / (-1/2) = (-1/3) * (-2/1) = ((-1)*(-2))/(3*1) = 2/3
        val division3 = fraccion3 / fraccion4.obtenerSimplificada()
        println("$fraccion3 / ${fraccion4.obtenerSimplificada()} = $division3")
        
        // División por entero
        val division4 = fraccion1 / fraccionEntero
        println("$fraccion1 / $fraccionEntero = $division4")
        
        println("\n=== OPERACIONES COMBINADAS ===")
        // (3/4 + 2/6) * (-1/3) = 13/12 * (-1/3) = -13/36
        val operacionCombinada1 = (fraccion1 + fraccion2) * fraccion3
        println("($fraccion1 + $fraccion2) * $fraccion3 = $operacionCombinada1")
        
        // (3/4 * 2/6) + (-1/3) = 1/4 + (-1/3) = 3/12 - 4/12 = -1/12
        val operacionCombinada2 = (fraccion1 * fraccion2) + fraccion3
        println("($fraccion1 * $fraccion2) + $fraccion3 = $operacionCombinada2")
        
        // (3/4 / 2/6) - 1 = 9/4 - 4/4 = 5/4
        val operacionCombinada3 = (fraccion1 / fraccion2) - fraccionEntero
        println("($fraccion1 / $fraccion2) - $fraccionEntero = $operacionCombinada3")
 
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}