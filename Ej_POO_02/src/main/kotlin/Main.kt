/*
Actualizar el ejercicio 1 para añadir a la clase el siguiente comportamiento:

    Debe saludar con su nombre... saludar()
    Debe retornar su imc... obtenerImc()
    Debe implementar también un método que muestre una descripción completa de la persona... mostrarDesc(). Este método mostrará por pantalla "Julia con una altura de 1.72m y un peso 64.7kg tiene un IMC de 21,87 (peso saludable)".
    Yo añadiría también un método obtenerImcDesc() para usar en mostrarDesc(), que implemente el retorno de la descripción del rango de tipo de imc al que equivale su cálculo.

*Nota: Si el IMC es menos de 18.5, se encuentra dentro del rango de "peso insuficiente". Si el IMC está entre 18.5 y 24.9, se encuentra dentro del rango de "peso saludable". Si el IMC está entre 25.0 y 29.9, se encuentra dentro del rango de "sobrepeso". Si el IMC es 30.0 o superior, se encuentra dentro del rango de "obesidad".

Crear en el main una estructura de datos con 4 o 5 personas más, recorrer la estructura y por cada persona debe saludar y mostrar su descripción completa.

Finalmente, revisa el IDE e intenta actualizar el modificador de visibilidad de los métodos de tu clase cómo te está indicando... verás que los métodos que realmente no van a ser llamados desde fuera de la clase te recomiendo que sean privados a la misma.
 */


/**
 * Clase que representa a una persona con atributos como peso, altura, nombre e índice de masa corporal (IMC).
 *
 * @property peso Peso de la persona en kilogramos.
 * @property altura Altura de la persona en metros.
 * @property nombre Nombre de la persona.
 * @property imc Índice de Masa Corporal (IMC) de la persona, calculado automáticamente.
 */
class Persona(private var peso: Double, private var altura: Double) {

    private var nombre: String = ""

    /**
     * Índice de Masa Corporal (IMC) de la persona, calculado automáticamente.
     */
    var imc = this.peso/(this.altura * this.altura)


    /**
     * Constructor secundario que incluye el nombre de la persona.
     */
    constructor(nombre: String, peso: Double, altura: Double): this(peso, altura) {
        this.nombre = nombre
        this.peso = peso
        this.altura = altura
    }


    /**
     * Saluda a la persona mostrando su nombre.
     */
    fun saludar() {
        println("Hola soy ${this.nombre}")
    }


    /**
     * Método privado que obtiene el IMC con formato de dos decimales.
     *
     * @return Cadena de texto que representa el IMC con formato de dos decimales.
     */
    private fun obtenerImc() = "%.2f".format(this.imc)


    /**
     * Muestra un texto con la descripción de las propiedades de la persona.
     */
    fun mostrarDesc() {
        println("${this.nombre} con una altura de ${this.altura}m y un peso de ${this.peso}, tiene un IMC de ${obtenerImc()} (${obtenerImcDesc()}).\n")

    }


    /**
     * Obtiene la descripción del IMC según los criterios de intervalo del cálculo del IMC
     * @return Una cadena de texto con la descripción del IMC
     */
    private fun obtenerImcDesc(): String {
        return when {
            this.imc < 18.5 -> "peso insuficiente"
            this.imc >= 18.5 || this.imc >= 24.9 -> "peso saludable"
            this.imc >= 25.0 || this.imc >= 29.9 -> "sobrepeso"
            this.imc > 30.0 -> "obesidad"
            else -> ""
        }
    }
}


fun main() {
    val persona1 = Persona("Sebas", 70.0, 1.74)
    val persona2 = Persona("Pepe", 80.0, 1.80)
    val persona3 = Persona("Arturo", 90.0, 1.90)
    val persona4 = Persona("María", 56.5, 1.58)
    val persona5 = Persona("Rocío", 61.2, 1.68)
    val persona6 = Persona("Jorge", 71.6, 1.76)
    val persona7 = Persona("Alex", 73.8, 1.87)

    val datos = arrayOf(persona1, persona2, persona3, persona4, persona5, persona6, persona7)

    datos.forEach {it.saludar()
        it.mostrarDesc()
    }
}
