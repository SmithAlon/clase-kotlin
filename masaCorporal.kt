package ejercicios

fun calcularIMC(peso: Double, altura: Double): Double {
    return peso / (altura * altura)
}

fun clasificarIMC(imc: Double): String {
    return if (imc < 18.5) {
        "Bajo peso"
    } else if (imc <= 24.9) {
        "Normal"
    } else if (imc <= 29.9) {
        "Sobrepeso"
    } else {
        "Obesidad"
    }
}

fun main() {
    println("Ingrese su peso en kilogramos:")
    val peso = readLine()?.toDoubleOrNull() ?: return println("Entrada inválida.")

    println("Ingrese su altura en metros:")
    val altura = readLine()?.toDoubleOrNull() ?: return println("Entrada inválida.")

    val imc = calcularIMC(peso, altura)
    val clasificacion = clasificarIMC(imc)

    println("Su índice de masa corporal es: %.2f".format(imc))
    println("Clasificación: $clasificacion")
}