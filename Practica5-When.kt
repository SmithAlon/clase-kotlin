package ejercicios

var dato = 3
var mes = 13



fun main() {
    dato(dato)
    mes(mes)
    trimestre(mes)
    semestre(mes)
}

fun dato(dato: Int) {
    when (dato) {
        1 -> println("Primera opción")
        2 -> println("Segunda opción")
        3 -> println("Tercera opción")
        else -> println("El dato no está en el rango de 1 a 5")
    }
}

fun mes(mes: Int) {
    when (mes) {
        1 -> println("Enero")
        2 -> println("Febrero")
        3 -> println("Marzo")
        4 -> println("Abril")
        5 -> println("Mayo")
        6 -> println("Junio")
        7 -> println("Julio")
        8 -> println("Agosto")
        9 -> println("Septiembre")
        10 -> println("Octubre")
        11 -> println("Noviembre")
        12 -> println("Diciembre")
        else -> println("Mes no válido")
    }
}

fun trimestre(mes: Int) {
    when (mes) {
        in 1..3 -> println("Primer trimestre")
        in 4..6 -> println("Segundo trimestre")
        in 7..9 -> println("Tercer trimestre")
        in 10..12 -> println("Cuarto trimestre")
        else -> println("Mes no válido")
    }
}

fun semestre(mes: Int) {
    when (mes) {
        in 1..6 -> println("Primer semestre")
        in 7..12 -> println("Segundo semestre")
        else -> println("Mes no válido")
    }
}