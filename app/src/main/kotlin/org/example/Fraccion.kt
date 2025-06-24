package org.example

class Fraccion(
    private var _numerador: Int,
    private var _denominador: Int) {
    
    // Propiedades con getters y setters personalizados
    var numerador: Int = _numerador
        get() = field
        set(value) { 
            field = value 
        }
    
    var denominador: Int = _denominador
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
}
