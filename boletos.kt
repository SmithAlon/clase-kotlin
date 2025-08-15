package com.example.projectandroid

data class Boletos(val tipo: String, val precio: Double)

val boletos = listOf(
    Boletos("Adulto", 100.0),
    Boletos("Niño", 50.0),
    Boletos("Infantil", 0.0),
    Boletos("Tercera Edad", 70.0)
)

data class Usuario(
    val nombre: String,
    val edad: Int,
    val correo: String,
    val estudiante : Boolean
)

val usuarios = listOf(
    Usuario("José", 3, "jose@example.com", false),
    Usuario("Eva", 15, "eva@example.com", true),
    Usuario("Carlos", 65, "carlos@example.com", false),
    Usuario("Ana", 19, "ana@example.com", true),
    Usuario("Miguel", 25, "miguel@example.com", false)
)

fun calcularPrecioBoleto(tipo: String, edad: Int, esEstudiante: Boolean): Double {
    val boleto = boletos.find { it.tipo == tipo }
    return when {
        boleto != null && edad < 13 -> boleto.precio // Precio normal para niños
        boleto != null && esEstudiante -> boleto.precio * 0.5 // 50% descuento para estudiantes adultos
        boleto != null -> boleto.precio
        else -> 0.0
    }
}

fun simularCompra(usuario: Usuario): Double {
    val tipoBoleto = when {
        usuario.edad <= 3 -> "Infantil"
        usuario.edad < 13 -> "Niño"
        usuario.edad >= 60 -> "Tercera Edad"
        else -> "Adulto"
    }

    return calcularPrecioBoleto(tipoBoleto, usuario.edad, usuario.estudiante)
}

fun determinarTipoBoleto(edad: Int): String = when {
    edad <= 3 -> "Infantil"
    edad < 13 -> "Niño"
    edad >= 60 -> "Tercera Edad"
    else -> "Adulto"
}

fun imprimirTicket(usuario: Usuario) {
    val precioFinal = simularCompra(usuario)
    val tipoBase = determinarTipoBoleto(usuario.edad)
    val descuentoEstudiante = usuario.estudiante && usuario.edad >= 12
    println("""
        ====== TICKET DE COMPRA ======
        Cliente: ${usuario.nombre}
        Email: ${usuario.correo}
        Tipo de boleto: $tipoBase${if (descuentoEstudiante) " (Descuento Estudiante)" else ""}
        Precio final: $${precioFinal}
        ===========================
    """.trimIndent())
}

// Ejemplo de uso en main
fun main() {
    usuarios.forEach { usuario ->
        imprimirTicket(usuario)
        println() // Línea en blanco entre tickets
    }
}
