fun saludo(persona: String) {
    println("Hola, $persona! Bienvenido al sistema de validación de rango educativo.")
}

fun validarRango(edad: Int): String {
    return when {
        edad <= 3 -> "Maternal"
        edad in 4..11 -> "Primaria"
        edad in 12..15 -> "Secundaria"
        edad in 16..18 -> "Preparatoria"
        edad in 19..64 -> "Universidad"
        else -> "Libre"
    }
}

fun resultado(rango: String, persona: String) {
    if (rango == "Libre") {
        println("$persona debe hacer lo que le plazca.")
    } else {
        println("$persona debería estar en $rango.")
    }
}

fun main() {
    val persona = "Pedro"
    val edad = 30

    saludo(persona)
    val rango = validarRango(edad)
    resultado(rango, persona)
}