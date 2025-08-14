package ejercicios

data class Usuarios(val dia: Int,
                    var mes: String,
                    val anio: Int)

var usuario = Usuarios(3, "MARZO", 1986)

fun main() {
    usuario.mes = usuario.mes.lowercase()
    val signoZodiacal = zodiacal(usuario)
    println("El signo zodiacal de ${usuario.dia} de ${usuario.mes} es: $signoZodiacal")
    val signoZodiacalChino = zodiacoChino(usuario.anio)
    println("El signo zodiacal chino del año ${usuario.anio} es: $signoZodiacalChino")
    val estacionActual = estacion(usuario)
    println("La estación del año para ${usuario.dia} de ${usuario.mes} es: $estacionActual")
}

fun zodiacal(usuario: Usuarios): String {
    val (dia, mes) = usuario
    return when (mes) {
        "enero" -> if (dia < 20) "Capricornio" else "Acuario"
        "febrero" -> if (dia < 19) "Acuario" else "Piscis"
        "marzo" -> if (dia < 21) "Piscis" else "Aries"
        "abril" -> if (dia < 20) "Aries" else "Tauro"
        "mayo" -> if (dia < 21) "Tauro" else "Géminis"
        "junio" -> if (dia < 21) "Géminis" else "Cáncer"
        "julio" -> if (dia < 23) "Cáncer" else "Leo"
        "agosto" -> if (dia < 23) "Leo" else "Virgo"
        "septiembre" -> if (dia < 23) "Virgo" else "Libra"
        "octubre" -> if (dia < 23) "Libra" else "Escorpio"
        "noviembre" -> if (dia < 22) "Escorpio" else "Sagitario"
        "diciembre" -> if (dia < 22) "Sagitario" else "Capricornio"
        else -> throw IllegalArgumentException("Mes no válido")
    }
}

fun zodiacoChino(anio: Int): String {
    return when (anio % 12) {
        0 -> "Mono"
        1 -> "Gallo"
        2 -> "Perro"
        3 -> "Cerdo"
        4 -> "Rata"
        5 -> "Buey"
        6 -> "Tigre"
        7 -> "Conejo"
        8 -> "Dragón"
        9 -> "Serpiente"
        10 -> "Caballo"
        11 -> "Cabra"
        else -> throw IllegalArgumentException("Año no válido")
    }
}

fun estacion(usuario: Usuarios): String {
    val (dia, mes) = usuario
    return when (mes) {
        "enero", "febrero", "marzo" -> if (mes == "marzo" && dia < 20) "Invierno" else "Primavera"
        "abril", "mayo", "junio" -> if (mes == "junio" && dia < 21) "Primavera" else "Verano"
        "julio", "agosto", "septiembre" -> if (mes == "septiembre" && dia < 23) "Verano" else "Otoño"
        "octubre", "noviembre", "diciembre" -> if (mes == "diciembre" && dia < 21) "Otoño" else "Invierno"
        else -> throw IllegalArgumentException("Mes no válido")
    }
}