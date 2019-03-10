import kotlin.math.pow

fun main(args: Array<String>){

    //Part A
    //parseDistance()

    //Part B
    var time = evalTime()
    println("It took $time to pass half of the way.")
}

//Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
//Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
fun parseTime(){
    print("Enter time in HH:MM:SS format: ")
    var timeAsString = readLine()!!
    var timeAsInts = timeAsString.split(':')
    var totalSeconds = timeAsInts[0].toInt() * 3600 + timeAsInts[1].toInt() * 60 + timeAsInts[2].toInt()
    println(totalSeconds.toString() + " seconds has passed.")
}

//Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
//Например, расстояние между (3, 0) и (0, 4) равно 5
fun parseDistance(){

    print("Enter point 1 as x1 y1: ")
    var A = readLine()!!.split(' ')
    print("Enter point 2 as x2 y2: ")
    var B = readLine()!!.split(' ')

    var distance = ((B[0].toDouble()-A[0].toDouble()).pow(2) + (B[1].toDouble()-A[1].toDouble()).pow(2)).pow(0.5).toString()
    println("The distance between points is: $distance")
}

//Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
//и t3 часов — со скоростью v3 км/час.
//Определить, за какое время он одолел первую половину пути?
fun evalTime(): Double{

    print("Enter velocities as v1 v2 v3: ")
    var inpVelocities = readLine()!!.split(' ')

    print("Enter times t1 t2 t3: ")
    var inpTimes = readLine()!!.split(' ')

    var v1 = inpVelocities[0].toDouble()
    var v2 = inpVelocities[1].toDouble()
    var v3 = inpVelocities[2].toDouble()

    var t1 = inpTimes[0].toDouble()
    var t2 = inpTimes[1].toDouble()
    var t3 = inpTimes[2].toDouble()

    var totalDistance = v1 * t1 + v2 * t2 + v3 * t3

    println("DEBUG information:")
    println("Total distance of the way is $totalDistance")
    println("At the first part the traveler passed "  + v1*t1)
    println("At the second part the traveler passed " + v2*t2)
    println("At the third part the traveler passed "  + v3*t3)

    return when {
        v1 * t1 >= totalDistance/2              -> totalDistance/(2 * v1)
        v1 * t1 + v2 * t2 >= totalDistance/2    -> t1 + (totalDistance/2 - v1 * t1)/v2
        else                                    -> t1 + t2 + (totalDistance/2 - v1 * t1 - v2 * t2)/v3
    }
}