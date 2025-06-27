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
        
        println("\n=== CASOS ESPECIALES DE MULTIPLICACIÓN Y DIVISIÓN ===")
        val fraccionCero = Fraccion(0, 5)
        val fraccionUno = Fraccion(7, 7).obtenerSimplificada()
        
        println("Multiplicación por cero: $fraccion1 * $fraccionCero = ${fraccion1 * fraccionCero}")
        println("Multiplicación por uno: $fraccion1 * $fraccionUno = ${fraccion1 * fraccionUno}")
        println("División por uno: $fraccion1 / $fraccionUno = ${fraccion1 / fraccionUno}")
        
        // Casos que generarían error (comentados para evitar excepciones)
        println("\n=== CASOS DE ERROR EN DIVISIÓN (comentados) ===")
        println("// División por cero causaría error:")
        println("// $fraccion1 / $fraccionCero // Esto lanzaría IllegalArgumentException")
        
        // Ejemplo de división por cero (descomenta para ver el error)
        // val divisionPorCero = fraccion1 / fraccionCero
        
        println("\n=== COMPARACIONES Y VALIDACIONES ===")
        println("Comparando fracciones:")
        println("$fraccion1 compareTo $fraccion2 = ${fraccion1.compareTo(fraccion2)}")
        println("$fraccion1 == $fraccion2: ${fraccion1 == fraccion2}")
        println("$fraccion1 > $fraccion2: ${fraccion1.esMayor(fraccion2)}")
        println("$fraccion1 < $fraccion2: ${fraccion1.esMenor(fraccion2)}")
        println("$fraccion1 >= $fraccion2: ${fraccion1.esMayorOIgual(fraccion2)}")
        println("$fraccion1 <= $fraccion2: ${fraccion1.esMenorOIgual(fraccion2)}")
        
        println("\nComparando fracciones equivalentes:")
        val fraccion5 = Fraccion(6, 8) // Equivale a 3/4
        println("$fraccion1 == ${fraccion5.obtenerSimplificada()}: ${fraccion1 == fraccion5}")
        println("$fraccion1 compareTo $fraccion5 = ${fraccion1.compareTo(fraccion5)}")
        
        println("\n=== CONVERSIONES A DECIMAL ===")
        println("$fraccion1 = ${fraccion1.aDecimal()}")
        println("$fraccion2 = ${fraccion2.aDecimal()}")
        println("$fraccion3 = ${fraccion3.aDecimal()}")
        println("$fraccion4 simplificado = ${fraccion4.obtenerSimplificada().aDecimal()}")
        
        println("\n=== PROPIEDADES DE FRACCIONES ===")
        println("¿Es $fraccion1 un entero? ${fraccion1.esEntero()}")
        println("¿Es ${Fraccion(8, 4)} un entero? ${Fraccion(8, 4).esEntero()}")
        println("Parte entera de $fraccion1: ${fraccion1.parteEntera()}")
        println("Parte entera de ${Fraccion(22, 7)}: ${Fraccion(22, 7).parteEntera()}")
        
        println("\n=== VALOR ABSOLUTO Y RECÍPROCO ===")
        println("Valor absoluto de $fraccion3: ${fraccion3.valorAbsoluto()}")
        println("Recíproco de $fraccion1: ${fraccion1.reciproco()}")
        println("Recíproco de $fraccion3: ${fraccion3.reciproco()}")
        
        println("\n=== CONVERSIÓN DESDE DECIMAL ===")
        val decimal1 = 0.75
        val decimal2 = 0.333333
        val decimal3 = -1.25
        val decimal4 = 2.5
        
        println("$decimal1 = ${Fraccion.desdeDecimal(decimal1)}")
        println("$decimal2 ≈ ${Fraccion.desdeDecimal(decimal2)}")
        println("$decimal3 = ${Fraccion.desdeDecimal(decimal3)}")
        println("$decimal4 = ${Fraccion.desdeDecimal(decimal4)}")
        
        println("\n=== MÉTODOS DE FACTORY ===")
        println("Fracción cero: ${Fraccion.cero()}")
        println("Fracción uno: ${Fraccion.uno()}")
        println("Desde entero 5: ${Fraccion.desdeEntero(5)}")
        println("Desde entero -3: ${Fraccion.desdeEntero(-3)}")
        
        println("\n=== ORDENAMIENTO DE FRACCIONES ===")
        val listaFracciones = listOf(
            Fraccion(1, 2),
            Fraccion(3, 4),
            Fraccion(1, 3),
            Fraccion(2, 3),
            Fraccion(5, 6)
        )
        
        println("Lista original: ${listaFracciones.joinToString(", ")}")
        val listaOrdenada = listaFracciones.sorted()
        println("Lista ordenada: ${listaOrdenada.joinToString(", ")}")
        
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    val scanner = Scanner(System.`in`)
    var opcion: Int
    
    println("¡Bienvenido a la Calculadora de Fracciones!")
    println("Esta aplicación le permite realizar operaciones con fracciones de manera sencilla.")
    
    do {
        try {
            mostrarMenu()
            opcion = scanner.nextInt()
            
            when (opcion) {
                1 -> {
                    realizarSuma(scanner)
                    esperarEnter(scanner)
                }
                2 -> {
                    realizarResta(scanner)
                    esperarEnter(scanner)
                }
                3 -> {
                    realizarMultiplicacion(scanner)
                    esperarEnter(scanner)
                }
                4 -> {
                    realizarDivision(scanner)
                    esperarEnter(scanner)
                }
                5 -> {
                    realizarComparacion(scanner)
                    esperarEnter(scanner)
                }
                6 -> {
                    convertirADecimal(scanner)
                    esperarEnter(scanner)
                }
                7 -> {
                    crearDesdeDecimal(scanner)
                    esperarEnter(scanner)
                }
                8 -> {
                    mostrarEjemplos()
                    esperarEnter(scanner)
                }
                0 -> {
                    println("\n¡Gracias por usar la Calculadora de Fracciones!")
                    println("¡Hasta luego!")
                }
                else -> {
                    println("Opción inválida. Por favor, seleccione una opción del 0 al 8.")
                    esperarEnter(scanner)
                }
            }
            
        } catch (e: InputMismatchException) {
            println("Error: Debe ingresar un número entero válido para la opción del menú.")
            scanner.nextLine() // Limpiar buffer
            opcion = -1 // Para que no salga del bucle
            esperarEnter(scanner)
        } catch (e: Exception) {
            println("Error inesperado: ${e.message}")
            opcion = -1 // Para que no salga del bucle
            esperarEnter(scanner)
        }
        
    } while (opcion != 0)
    
    scanner.close()
}