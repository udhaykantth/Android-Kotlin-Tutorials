
//This program explains core concepts of kotlin
//like, pair and triples, boolean, scope, when expression, nullable , loops, functions.
typealias  commonOperation = ( Int, Int) -> Int
fun main(args : Array<String>) {
/*
    val intDeclarationTemperature = 28.5
    val intDeclarationCount: Int = 10
    var name = "John cena"
    name = "Mike"


    fun addition(A: Int, B: Int): Int {
        return A + B
    }
    fun subtraction(A:Int, B:Int):Int {

        return  A - B
    }
    println("Temp = ${addition(5,8)}")
    println("Temp = ${subtraction(5,8)}")

    val intValue = "40".toInt()
    println("")

    fun printHelloworld(name:String) : Unit{
        if (name != null) {
            println("name is :$name")
        }
    }
    val names = printHelloworld("Johson")
    println("names is :$names")

    val strone = "Hello, World!"
    val strtwo = "Hello," + " World!"
    println(strone == strtwo)
    val str1 = """ |Hello, World!
    """.trimMargin()
    val str2 = """ #Hello, World!
""".trimMargin("#")
    val str3 = str1
    println(str1 == str2)
    println(str1 === str2)
    println(str1 === str3)
*/
/*
//coordinates
    val coordinates = Pair(2,3)
    val (x,y) = coordinates
    println("X:$x, Y:$y")
    println("X:${coordinates.first}, Y:${coordinates.second}")

    val coordiantes3D = Triple(1,2,3)
    println("X:${coordiantes3D.first}, Y:${coordiantes3D.second},z:${coordiantes3D.third}")

//Boolean
    val yes :Boolean = true
    val no : Boolean = false
    println("Yes: ${yes}, No: ${no}")

//while loop
    var multipleTimesCounts: Int = 0
    while (multipleTimesCounts < 10) {
        println("value is : $multipleTimesCounts")
        multipleTimesCounts++
        println("*******")
    }
    //do while
    var multiplePrints: Int = 0
    do {
        multiplePrints++
        println("value is : $multiplePrints")

    } while (multiplePrints < 5)
*/
 /*   //when expression
    val  number: Int = 10
    when(number) {
        0->println("value is zero")
        10->println("value is tem")
        else->println("value is non-zero")
    }
    val  name: String = "Cat"
    when(name) {
        "Cat"->println("value is Cat")
        "Dog"->println("value is dog")
        else->println("it is not an animal")
    }
    val myAge = 2
    when(myAge) {
       in 0..2->println("Infant")
        in 3..12->println("Child")
        in 13..19->println("Teenager")
        in 20..39->println("Adult")
        in 40..60->println("Middle age")
        in 61..110->println("Elderly age")
        else->println("invalid Agae")

    }
    val personNameAndAge = Pair("Johncena",40)
    when(personNameAndAge.second) {
        in 0..2->println(" ${personNameAndAge.first} is an Infant")
        in 3..12->println("${personNameAndAge.first} is a Child")
        in 13..19->println("${personNameAndAge.first} is a Teenager")
        in 20..39->println("${personNameAndAge.first} is an Adult")
        in 40..60->println("${personNameAndAge.first} is a Middle age")
        in 61..110->println("${personNameAndAge.first} is an Elderly age")
        else->println("invalid Agae")

    }
    val stringPerson = when(personNameAndAge.second) {
        in 0..2->println(" ${personNameAndAge.first} is an Infant")
        in 3..12->println("${personNameAndAge.first} is a Child")
        in 13..19->println("${personNameAndAge.first} is a Teenager")
        in 20..39->println("${personNameAndAge.first} is an Adult")
        in 40..60->println("${personNameAndAge.first} is a Middle age")
        in 61..110->println("${personNameAndAge.first} is an Elderly age")
        else->println("invalid Agae")

    }
    println(stringPerson)
    */
    //functions
  /*  fun  printableStatement(){
    println("printableStatement invoked")
}
    printableStatement()
    fun  multipleOf2(value: Int){
        println("${value * 1} = ${value * 1} ")
    }
    multipleOf2(2)

    fun  multipleOf4(mutiplier: Int, value: Int){
        println("$mutiplier * $value = ${mutiplier * value } ")
    }
    multipleOf4(4,2)

    fun  multipleOf4x10(mutiplier: Int, value: Int = 10){
        println("$mutiplier * $value = ${mutiplier * value } ")
    }
    multipleOf4x10(4)
    fun  multipleOf4x10Equals(mutiplier: Int, value: Int = 10) : Int{

        return mutiplier * value
    }
    val result =  multipleOf4x10Equals(4)
    println(result)

    fun multiplyAndDivide(mutiplier: Int, value: Int = 10) : Pair<Int,Int>{

        return Pair(mutiplier*value, mutiplier/value)
    }
    println("Multiplier and Divide is : ${multiplyAndDivide(100,10)}")

    var function : (Int , Int) -> Int = ::multipleOf4x10Equals

    println(function(3,2))

    fun  addition(A: Int, B: Int) : Int {
        return  A+B
    }
    fun  substraction(A: Int, B: Int) : Int {
        return  A - B
    }
    function = ::addition
    println(function(11,2))
    function = ::substraction
    println(function(11,2))

    fun printResult(function:(Int,Int)->Int, A:Int, B:Int) {
        var result = function(A,B)
        println("Addition result is :$result")

    }
    printResult(::addition,4,5)
    printResult(::substraction,10,5)


    fun printResult2(function:commonOperation, A:Int, B:Int) {
        var result = function(A,B)
        println("Addition result is :$result")

    }

    printResult2(::addition,4,5)

    fun noReturnType():Unit {
        println("Unit is Returns nothing")
    }
    */
    //Nullable
   /* var myName : String? = null
    println(myName)
    myName = "Jhon Cena"
    println(myName)

    var nonNull: Int? = null

    //println(nonNull!! + 1)

    val educationDegree: String? = null//"Bachelor of Science"
    educationDegree?.let { println(educationDegree) } ?:  println("No education degree")
*/
//Collections
    var playersWWE = arrayListOf<String>("johncena","brocklesnar","Kali","Rock")
    println("indexo of ${playersWWE.indexOf("Kali")}")
    println("Count of : ${playersWWE.size}")
    println("Add of: ${playersWWE.add("Shwan Micheal") }")
    println("Count of : ${playersWWE.size}")

    var titlePoints = arrayListOf<Int>(2,4,6,8,10)
    var index = 0
    for (player in playersWWE){
        println("Wrestler name  ${index+1}) $player -- ${titlePoints[index]}")
        index++
    }
    println("**********")
    playersWWE.forEachIndexed {index,player ->

        println("Wrestler name  ${index+1}) $player -- ${titlePoints[index]}")
    }

}