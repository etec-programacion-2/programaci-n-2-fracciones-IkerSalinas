package org.example

import java.util.Scanner
import java.util.InputMismatchException

fun mostrarMenu() {
    println("\n=== CALCULADORA DE FRACCIONES ===")
    println("1. Sumar fracciones")
    println("2. Restar fracciones")
    println("3. Multiplicar fracciones")
    println("4. Dividir fracciones")
    println("5. Comparar fracciones")
    println("6. Convertir fracción a decimal")
    println("7. Crear fracción desde decimal")
    println("8. Ejemplos predefinidos")
    println("0. Salir")
    print("Ingrese su opción: ")
}

fun leerFraccion(scanner: Scanner, mensaje: String): Fraccion? {
    return try {
        println(mensaje)
        print("Numerador: ")
        val numerador = scanner.nextInt()
        print("Denominador: ")
        val denominador = scanner.nextInt()
        
        if (denominador == 0) {
            println("Error: El denominador no puede ser cero. Intente de nuevo.")
            return null
        }
        
        Fraccion(numerador, denominador)
    } catch (e: InputMismatchException) {
        println("Error: Debe ingresar números enteros válidos.")
        scanner.nextLine() // Limpiar buffer
        null
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
        null
    }
}

fun realizarSuma(scanner: Scanner) {
    println("\n=== SUMA DE FRACCIONES ===")
    
    var fraccion1: Fraccion? = null
    var fraccion2: Fraccion? = null
    
    // Leer primera fracción con validación
    while (fraccion1 == null) {
        fraccion1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    }
    
    // Leer segunda fracción con validación
    while (fraccion2 == null) {
        fraccion2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    }
    
    try {
        val resultado = fraccion1 + fraccion2
        println("\nResultado:")
        println("$fraccion1 + $fraccion2 = $resultado")
        println("En decimal: ${resultado.aDecimal()}")
    } catch (e: Exception) {
        println("Error al realizar la suma: ${e.message}")
    }
}

fun realizarResta(scanner: Scanner) {
    println("\n=== RESTA DE FRACCIONES ===")
    
    var fraccion1: Fraccion? = null
    var fraccion2: Fraccion? = null
    
    // Leer primera fracción con validación
    while (fraccion1 == null) {
        fraccion1 = leerFraccion(scanner, "Ingrese la primera fracción (minuendo):")
    }
    
    // Leer segunda fracción con validación
    while (fraccion2 == null) {
        fraccion2 = leerFraccion(scanner, "Ingrese la segunda fracción (sustraendo):")
    }
    
    try {
        val resultado = fraccion1 - fraccion2
        println("\nResultado:")
        println("$fraccion1 - $fraccion2 = $resultado")
        println("En decimal: ${resultado.aDecimal()}")
    } catch (e: Exception) {
        println("Error al realizar la resta: ${e.message}")
    }
}

fun realizarMultiplicacion(scanner: Scanner) {
    println("\n=== MULTIPLICACIÓN DE FRACCIONES ===")
    
    var fraccion1: Fraccion? = null
    var fraccion2: Fraccion? = null
    
    // Leer primera fracción con validación
    while (fraccion1 == null) {
        fraccion1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    }
    
    // Leer segunda fracción con validación
    while (fraccion2 == null) {
        fraccion2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    }
    
    try {
        val resultado = fraccion1 * fraccion2
        println("\nResultado:")
        println("$fraccion1 * $fraccion2 = $resultado")
        println("En decimal: ${resultado.aDecimal()}")
    } catch (e: Exception) {
        println("Error al realizar la multiplicación: ${e.message}")
    }
}

fun realizarDivision(scanner: Scanner) {
    println("\n=== DIVISIÓN DE FRACCIONES ===")
    
    var fraccion1: Fraccion? = null
    var fraccion2: Fraccion? = null
    
    // Leer primera fracción con validación
    while (fraccion1 == null) {
        fraccion1 = leerFraccion(scanner, "Ingrese la primera fracción (dividendo):")
    }
    
    // Leer segunda fracción con validación
    while (fraccion2 == null) {
        fraccion2 = leerFraccion(scanner, "Ingrese la segunda fracción (divisor):")
        if (fraccion2 != null && fraccion2.numerador == 0) {
            println("Error: No se puede dividir por cero (el numerador del divisor es cero).")
            fraccion2 = null
        }
    }
    
    try {
        val resultado = fraccion1 / fraccion2
        println("\nResultado:")
        println("$fraccion1 / $fraccion2 = $resultado")
        println("En decimal: ${resultado.aDecimal()}")
    } catch (e: Exception) {
        println("Error al realizar la división: ${e.message}")
    }
}

fun realizarComparacion(scanner: Scanner) {
    println("\n=== COMPARACIÓN DE FRACCIONES ===")
    
    var fraccion1: Fraccion? = null
    var fraccion2: Fraccion? = null
    
    // Leer primera fracción con validación
    while (fraccion1 == null) {
        fraccion1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    }
    
    // Leer segunda fracción con validación
    while (fraccion2 == null) {
        fraccion2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    }
    
    try {
        println("\nResultados de comparación:")
        println("Fracción 1: $fraccion1 (${fraccion1.aDecimal()})")
        println("Fracción 2: $fraccion2 (${fraccion2.aDecimal()})")
        
        when {
            fraccion1 == fraccion2 -> println("Las fracciones son iguales: $fraccion1 = $fraccion2")
            fraccion1.esMayor(fraccion2) -> println("La primera fracción es mayor: $fraccion1 > $fraccion2")
            fraccion1.esMenor(fraccion2) -> println("La primera fracción es menor: $fraccion1 < $fraccion2")
        }
        
        println("\nComparaciones adicionales:")
        println("$fraccion1 >= $fraccion2: ${fraccion1.esMayorOIgual(fraccion2)}")
        println("$fraccion1 <= $fraccion2: ${fraccion1.esMenorOIgual(fraccion2)}")
        println("Valor de compareTo: ${fraccion1.compareTo(fraccion2)}")
        
    } catch (e: Exception) {
        println("Error al realizar la comparación: ${e.message}")
    }
}

fun convertirADecimal(scanner: Scanner) {
    println("\n=== CONVERSIÓN A DECIMAL ===")
    
    var fraccion: Fraccion? = null
    
    // Leer fracción con validación
    while (fraccion == null) {
        fraccion = leerFraccion(scanner, "Ingrese la fracción a convertir:")
    }
    
    try {
        val decimal = fraccion.aDecimal()
        println("\nResultado:")
        println("$fraccion = $decimal")
        
        // Información adicional
        if (fraccion.esEntero()) {
            println("Esta fracción representa un número entero: ${fraccion.parteEntera()}")
        } else {
            println("Parte entera: ${fraccion.parteEntera()}")
        }
        
    } catch (e: Exception) {
        println("Error al convertir a decimal: ${e.message}")
    }
}

fun crearDesdeDecimal(scanner: Scanner) {
    println("\n=== CREAR FRACCIÓN DESDE DECIMAL ===")
    
    var decimal: Double? = null
    
    // Leer decimal con validación
    while (decimal == null) {
        try {
            print("Ingrese el número decimal: ")
            decimal = scanner.nextDouble()
            
            if (decimal.isInfinite() || decimal.isNaN()) {
                println("Error: No se puede convertir un valor infinito o NaN.")
                decimal = null
            }
            
        } catch (e: InputMismatchException) {
            println("Error: Debe ingresar un número decimal válido.")
            scanner.nextLine() // Limpiar buffer
        }
    }
    
    try {
        val fraccion = Fraccion.desdeDecimal(decimal)
        println("\nResultado:")
        println("$decimal ≈ $fraccion")
        println("Verificación: $fraccion = ${fraccion.aDecimal()}")
        
        // Mostrar versión simplificada si es diferente
        val simplificada = fraccion.obtenerSimplificada()
        if (fraccion.toString() != simplificada.toString()) {
            println("Simplificada: $simplificada")
        }
        
    } catch (e: Exception) {
        println("Error al crear fracción desde decimal: ${e.message}")
    }
}

fun mostrarEjemplos() {
    println("\n=== EJEMPLOS PREDEFINIDOS ===")
    
    try {
        val f1 = Fraccion(1, 2)  // 1/2
        val f2 = Fraccion(1, 3)  // 1/3
        val f3 = Fraccion(3, 4)  // 3/4
        val f4 = Fraccion(2, 6)  // 2/6 = 1/3
        val f5 = Fraccion(-1, 4) // -1/4
        
        println("Fracciones de ejemplo:")
        println("f1 = $f1 (${f1.aDecimal()})")
        println("f2 = $f2 (${f2.aDecimal()})")
        println("f3 = $f3 (${f3.aDecimal()})")
        println("f4 = $f4 (${f4.aDecimal()}) -> simplificada: ${f4.obtenerSimplificada()}")
        println("f5 = $f5 (${f5.aDecimal()})")
        
        println("\n--- OPERACIONES BÁSICAS ---")
        println("Suma: $f1 + $f2 = ${f1 + f2} (${(f1 + f2).aDecimal()})")
        println("Resta: $f3 - $f2 = ${f3 - f2} (${(f3 - f2).aDecimal()})")
        println("Multiplicación: $f1 * $f3 = ${f1 * f3} (${(f1 * f3).aDecimal()})")
        println("División: $f3 / $f2 = ${f3 / f2} (${(f3 / f2).aDecimal()})")
        
        println("\n--- COMPARACIONES ---")
        println("¿$f1 > $f2? ${f1.esMayor(f2)}")
        println("¿$f3 < $f1? ${f3.esMenor(f1)}")
        println("¿$f2 == ${f4.obtenerSimplificada()}? ${f2 == f4}")
        
        println("\n--- OPERACIONES AVANZADAS ---")
        println("Valor absoluto de $f5: ${f5.valorAbsoluto()}")
        println("Recíproco de $f1: ${f1.reciproco()}")
        println("¿Es $f1 un entero? ${f1.esEntero()}")
        println("¿Es ${Fraccion(8, 4)} un entero? ${Fraccion(8, 4).esEntero()}")
        
        println("\n--- CONVERSIONES ---")
        println("0.75 como fracción: ${Fraccion.desdeDecimal(0.75)}")
        println("0.333333 como fracción: ${Fraccion.desdeDecimal(0.333333)}")
        println("-1.5 como fracción: ${Fraccion.desdeDecimal(-1.5)}")
        
        println("\n--- MÉTODOS FACTORY ---")
        println("Fracción cero: ${Fraccion.cero()}")
        println("Fracción uno: ${Fraccion.uno()}")
        println("Desde entero 5: ${Fraccion.desdeEntero(5)}")
        
        println("\n--- OPERACIONES COMBINADAS ---")
        val resultado1 = (f1 + f2) * f3
        println("($f1 + $f2) * $f3 = $resultado1 (${resultado1.aDecimal()})")
        
        val resultado2 = f3 / f2 - f1
        println("$f3 / $f2 - $f1 = $resultado2 (${resultado2.aDecimal()})")
        
        println("\n--- ORDENAMIENTO ---")
        val lista = listOf(f1, f2, f3, f4.obtenerSimplificada(), f5)
        println("Lista original: ${lista.joinToString(", ")}")
        val listaOrdenada = lista.sorted()
        println("Lista ordenada: ${listaOrdenada.joinToString(", ")}")
        
    } catch (e: Exception) {
        println("Error al mostrar ejemplos: ${e.message}")
    }
}

fun limpiarBuffer(scanner: Scanner) {
    if (scanner.hasNextLine()) {
        scanner.nextLine()
    }
}

fun esperarEnter(scanner: Scanner) {
    println("\nPresione Enter para continuar...")
    limpiarBuffer(scanner)
    scanner.nextLine()
}
