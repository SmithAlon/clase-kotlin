package practicas

fun main(){
    ifBasico()
}

fun ifBasico(){

    var num1 = 10
    var num2 = 10

    var resultado = num1 / num2

    if(resultado <= 5){

        print("Como el resultado de la operacion es $resultado y " +
                "se cumple la segunda situacion, se muestra otro resultado")
    } else {

        print("Como el resultado de la operacion es $resultado y " +
        "se cumple la primer situacion, se muestra este resultado")
    }
}

fun ifAnidado(){

    var n1 = 1
    var n2 = 5

    var resultado = n1 + n2

    if (resultado <= 3){
        print("El resultado es la primera opcion")
    } else if(resultado <= 4){
        print("El resultado es la segunda opcion")
    } else if(resultado <= 5){
        print("El resultado es la tercera opcion")
    } else{
        print("El resultado es mayor a lo esperado")
    }
}
