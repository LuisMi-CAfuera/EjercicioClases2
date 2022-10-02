
import kotlin.random.Random

fun main(){


    val Jugadores = List(10) {Jugador()}

    for (x in 0..9){
        Jugadores[x].id=x+1
    }

    println("Ya se han creado las IDs")


    Batalla(Jugadores)



}



fun Batalla(Jugador : List<Jugador>){

    val dado1 = Dado()
    val killMax : Int = 10

    println("Dime dos jugadores que quieres que pelen")

    var j1 : Int = readln().toInt()
    var j2 : Int = readln().toInt()
    var resp : String = ""

    while(resp == "si" || resp == "SI"){
        println("Comienza")
        for(kill in 1..killMax) {
            println("Jugador ${Jugador[j1].id}")
            Jugador[j1].puntos=dado1.tiradaDoble()
            println("Jugador ${Jugador[j2].id}")
            Jugador[j2].puntos=dado1.tiradaDoble()

        }
    }
}








class Dado {
    private var numMin = 0
    private var numMax = 10

    fun darValores(valMin: Int, valMax: Int) {
        if (valMin <= valMax) {
            numMax = valMax
            numMin = valMin
        } else {
            println("Se han cambiado los valores min y maximo")
            numMax = valMin
            numMin = valMax
        }
    }

    fun tiradaUnica (): Int {
        return Random.nextInt(numMin, numMax)
    }

    fun tiradaDoble (): Int {
        val num1 = Random.nextInt(numMin, numMax)
        println("Primer Dado = $num1")
        val num2 = Random.nextInt(numMin, numMax)
        println("Segundo Dado = $num2")
        return num1 + num2
    }
}

class Jugador{
    var id = 0
    var puntos = 0
    var kills =0
    var muertes =0


}