package org.example

class Fraccion(numerador: Int, denominador: Int) : Comparable<Fraccion> {
    
    // Propiedades con getters y setters personalizados
    var numerador: Int = numerador
        get() = field
        set(value) { 
            field = value 
        }
    
    var denominador: Int = denominador
        get() = field
        set(value) {
            if (value == 0) {
                throw IllegalArgumentException("El denominador no puede ser cero")
            }
            field = value
        }
    
    // Bloque init para validación en el constructor
    init {
        if (denominador == 0) {
            throw IllegalArgumentException("El denominador no puede ser cero")
        }
    }
    
    override fun toString(): String {
        return "$numerador/$denominador"
    }
    
    fun mostrar() {
        println(this.toString())
    }

    operator fun plus(otra: Fraccion): Fraccion {
        // Validar que la otra fracción sea válida
        if (otra.denominador == 0) {
            throw IllegalArgumentException("La fracción a sumar tiene denominador cero")
        }
        
        // Aplicar la fórmula: (a*d + b*c)/(b*d)
        val nuevoNumerador = this.numerador * otra.denominador + this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        
        // Crear nueva fracción y simplificarla
        val resultado = Fraccion(nuevoNumerador, nuevoDenominador)
        resultado.simplificar()
        return resultado
    }
    
    operator fun minus(otra: Fraccion): Fraccion {
        // Validar que la otra fracción sea válida
        if (otra.denominador == 0) {
            throw IllegalArgumentException("La fracción a restar tiene denominador cero")
        }
        
        // Aplicar la fórmula: (a*d - b*c)/(b*d)
        val nuevoNumerador = this.numerador * otra.denominador - this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        
        // Crear nueva fracción y simplificarla
        val resultado = Fraccion(nuevoNumerador, nuevoDenominador)
        resultado.simplificar()
        return resultado
    }
    
    private fun simplificar() {
        // Calcular el MCD del numerador y denominador
        val mcd = calcularMCD(kotlin.math.abs(numerador), kotlin.math.abs(denominador))
        
        // Simplificar dividiendo ambos por el MCD
        if (mcd > 1) {
            numerador /= mcd
            denominador /= mcd
        }
        
        // Manejar el signo: si el denominador es negativo, mover el signo al numerador
        if (denominador < 0) {
            numerador = -numerador
            denominador = -denominador
        }
    }
    
    private fun calcularMCD(a: Int, b: Int): Int {
        return if (b == 0) a else calcularMCD(b, a % b)
    }

    operator fun times(otra: Fraccion): Fraccion {
        // Validar que la otra fracción sea válida
        if (otra.denominador == 0) {
            throw IllegalArgumentException("La fracción a multiplicar tiene denominador cero")
        }
        
        // Aplicar la fórmula: (a*c)/(b*d)
        val nuevoNumerador = this.numerador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        
        // Crear nueva fracción y simplificarla
        val resultado = Fraccion(nuevoNumerador, nuevoDenominador)
        resultado.simplificar()
        return resultado
    }

    operator fun div(otra: Fraccion): Fraccion {
        // Validar que la otra fracción sea válida
        if (otra.denominador == 0) {
            throw IllegalArgumentException("La fracción divisor tiene denominador cero")
        }
        
        // Validar que no se esté dividiendo por cero (numerador de la segunda fracción no puede ser cero)
        if (otra.numerador == 0) {
            throw IllegalArgumentException("No se puede dividir por cero (el numerador del divisor es cero)")
        }
        
        // Aplicar la fórmula: (a*d)/(b*c)
        val nuevoNumerador = this.numerador * otra.denominador
        val nuevoDenominador = this.denominador * otra.numerador
        
        // Crear nueva fracción y simplificarla
        val resultado = Fraccion(nuevoNumerador, nuevoDenominador)
        resultado.simplificar()
        return resultado
    }
    
    override fun compareTo(otra: Fraccion): Int {
        // Validar que la otra fracción sea válida
        if (otra.denominador == 0) {
            throw IllegalArgumentException("La fracción a comparar tiene denominador cero")
        }
        
        // Para comparar a/b con c/d, calculamos a*d - b*c
        // Si el resultado es positivo, a/b > c/d
        // Si es negativo, a/b < c/d
        // Si es cero, a/b = c/d
        val diferencia = this.numerador * otra.denominador - this.denominador * otra.numerador
        
        return when {
            diferencia > 0 -> 1
            diferencia < 0 -> -1
            else -> 0
        }
    }
    
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        
        // Dos fracciones son iguales si a/b = c/d, es decir, a*d = b*c
        return this.numerador * other.denominador == this.denominador * other.numerador
    }
    
    override fun hashCode(): Int {
        val simplificada = this.obtenerSimplificada()
        return simplificada.numerador.hashCode() * 31 + simplificada.denominador.hashCode()
    }
    
    fun esMayor(otra: Fraccion): Boolean {
        return this.compareTo(otra) > 0
    }
    
    fun esMenor(otra: Fraccion): Boolean {
        return this.compareTo(otra) < 0
    }

    fun esMayorOIgual(otra: Fraccion): Boolean {
        return this.compareTo(otra) >= 0
    }

    fun esMenorOIgual(otra: Fraccion): Boolean {
        return this.compareTo(otra) <= 0
    }
    
    fun aDecimal(): Double {
        return numerador.toDouble() / denominador.toDouble()
    }

    fun esEntero(): Boolean {
        return numerador % denominador == 0
    }

    fun parteEntera(): Int {
        return numerador / denominador
    }

    fun valorAbsoluto(): Fraccion {
        return Fraccion(kotlin.math.abs(numerador), kotlin.math.abs(denominador))
    }

    fun reciproco(): Fraccion {
        if (numerador == 0) {
            throw IllegalArgumentException("No se puede calcular el recíproco de cero")
        }
        return Fraccion(denominador, numerador)
    }
    
    companion object {

        fun desdeDecimal(decimal: Double, precision: Int = 1000): Fraccion {
            if (decimal.isInfinite() || decimal.isNaN()) {
                throw IllegalArgumentException("No se puede convertir un valor infinito o NaN a fracción")
            }
            
            // Casos especiales
            if (decimal == 0.0) return Fraccion(0, 1)
            if (decimal == 1.0) return Fraccion(1, 1)
            
            val esNegativo = decimal < 0
            val decimalPositivo = kotlin.math.abs(decimal)
            
            // Algoritmo de fracciones continuas simplificado
            var x = decimalPositivo
            var a = x.toInt()
            var numerador1 = a
            var denominador1 = 1
            var numerador2 = 1
            var denominador2 = 0
            
            while (kotlin.math.abs(x - a) > 1.0 / precision && denominador1 < precision) {
                x = 1.0 / (x - a)
                a = x.toInt()
                
                val nuevoNumerador = a * numerador1 + numerador2
                val nuevoDenominador = a * denominador1 + denominador2
                
                numerador2 = numerador1
                denominador2 = denominador1
                numerador1 = nuevoNumerador
                denominador1 = nuevoDenominador
            }
            
            val resultado = Fraccion(numerador1, denominador1)
            return if (esNegativo) Fraccion(-numerador1, denominador1) else resultado
        }

        fun desdeEntero(entero: Int): Fraccion {
            return Fraccion(entero, 1)
        }

        fun cero(): Fraccion {
            return Fraccion(0, 1)
        }

        fun uno(): Fraccion {
            return Fraccion(1, 1)
        }
    }
    
    fun obtenerSimplificada(): Fraccion {
        val nueva = Fraccion(this.numerador, this.denominador)
        nueva.simplificar()
        return nueva
    }
}

