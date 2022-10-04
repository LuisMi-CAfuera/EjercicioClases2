
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
    val Rondas : Int = 10
    var j1 : Int = 0
    var j2 : Int = 0


    var resp : String = "Si"

    do{
        println("Dime dos jugadores que quieres que pelen")

        j1 = readln().toInt()
        j2= readln().toInt()

        println("Comienza")


        for(kill in 1..10) {
            println("Jugador ${Jugador[j1-1].id}")
            Jugador[j1-1].puntos=dado1.tiradaDoble()
            println("------------------------")
            println("Jugador ${Jugador[j2-1].id}")
            Jugador[j2-1].puntos=dado1.tiradaDoble()
            println("------------------------")

            if(Jugador[j1-1].puntos < Jugador[j2-1].puntos){
                Jugador[j2-1].kills = Jugador[j2-1].kills +1
                Jugador[j1-1].muertes = Jugador[j1-1].muertes +1
            }else if (Jugador[j1-1].puntos > Jugador[j2-1].puntos) {
                Jugador[j1-1].kills = Jugador[j1-1].kills + 1
                Jugador[j2-1].muertes = Jugador[j2-1].muertes + 1
            }else{
                println("Los Dos sacaron lo mismo no se suma a ninguno")
            }
        }

        println("El jugador ${Jugador[j1-1].id}  tiene ${Jugador[j1-1].kills} kills y ${Jugador[j1-1].muertes}muertes")
        println("El jugador ${Jugador[j2-1].id} tiene ${Jugador[j2-1].kills} kills y ${Jugador[j2-1].muertes} muetes")


        println("¿Quieres seguir?(Si/No)")

        resp = readln()



    }while(resp == "Si" || resp == "si")
    println("Termino el programa")
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