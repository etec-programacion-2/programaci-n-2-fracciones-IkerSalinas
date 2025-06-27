package org.example

class Fraccion(numerador: Int, denominador: Int) {
    
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
    
    /**
     * Operador de resta de fracciones
     * Fórmula: (a/b) - (c/d) = (a*d - b*c)/(b*d)
     * @param otra La fracción a restar
     * @return Nueva fracción con el resultado simplificado
     */
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
    
    /**
     * Método privado para simplificar la fracción a su forma más simple
     * Utiliza el algoritmo de Euclides para encontrar el MCD
     */
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
    
    /**
     * Método privado para calcular el Máximo Común Divisor usando el algoritmo de Euclides
     * @param a Primer número (debe ser positivo)
     * @param b Segundo número (debe ser positivo)
     * @return El MCD de a y b
     */
    private fun calcularMCD(a: Int, b: Int): Int {
        return if (b == 0) a else calcularMCD(b, a % b)
    }
    
    /**
     * Método para obtener una fracción simplificada sin modificar la original
     * @return Nueva fracción simplificada
     */
    fun obtenerSimplificada(): Fraccion {
        val nueva = Fraccion(this.numerador, this.denominador)
        nueva.simplificar()
        return nueva
    }
}