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
    
    fun obtenerSimplificada(): Fraccion {
        val nueva = Fraccion(this.numerador, this.denominador)
        nueva.simplificar()
        return nueva
    }
}
