package kotlin

const val CONS_INT_MAX_VALUE = Int.MAX_VALUE

class IntroducaoKotlin {

    fun main() {

        val pi = 3.14159265358979323
        val formatted = "Pi: %.2f".format(pi)
        print(formatted)

        var currentAge = 22 // a variável assume o tipo a partir do primeiro valor inserido
        var currentAgeTipo:Int? //currentAge = null ou 22
        currentAgeTipo = 23

        val currentAgeVal = 24 // a variável final assume o tipo a partir do primeiro valor inserido
        val currentAgeValTipo:Int? //currentAge = null ou 22
        currentAgeValTipo = 25

        println(currentAge)
        println(currentAgeTipo)
        println(currentAgeVal)
        println(currentAgeValTipo)
        println(CONS_INT_MAX_VALUE)

        /* ERRO - Precisar partir de uma referência
        var currentAgeError
        currentAgeError = 22
        */

        /* ERRO - Variável inicializada como string, não pode atribuir valor diferente do tipo definido
        var currentYear = "Ano"
        currentYear = 2021
        */

        //Atribui valor null corretamente a month
        var month:Int? = null

        /* ERRO de compilação
        var day:Int = null
        */

        val welcome = "Bem vindo"
        var name = "Vinícius"
        println("$welcome, ${name.capitalize()}!")

        val x = calculate(12,4,::sum)
        val y = calculate(12,4){a,b -> a*b}
        println("X = ${x}, Y = ${y}")

        /* switch
        when {
            case1 -> {}
            case2 -> {}
            else -> {}
        }
        when (year){
            -4000.. 475 -> {}
            476.. 1900 -> {}
            else -> {}
        }
        */

        val num1:Int? = null
        var num2 = num1 ?: 0
        println(num1)
        println(num2)

        println("For com step")
        for(i in 0..20 step 2){
            print(i)
        }
        println("")

        println("For com until")
        for(i in 0 until 10){
            print(i)
        }
        println("")

        println("For com downTo")
        for(i in 10 downTo 0){
            print(i)
        }
        println("")

        val sArray = "Olha essa string!"
        for(s in sArray){
            print("$s ")
        }
    }

    fun sum(a1:Int, a2:Int) = a1.plus(a2)

    fun calculate(n1:Int,n2:Int,operation:(Int,Int) ->Int):Int{
        return operation(n1,n2)
    }
}