// Путник двигался t1 часов со скоростью v1 км/час, затем t2
// часов — со скоростью v2 км/час и t3 часов — со
// скоростью v3 км/час.
// Определить, за какое время он одолел первую
// половину пути?

fun main(){
    println("Введите v1 v2 v3")
    var velocities = readLine()!!.split(' ').map { it.toFloat() }
    if (velocities.size != 3){
        println("Неверное количество скоростей!")
        return
    }
    var v1 = velocities[0]
    var v2 = velocities[1]
    var v3 = velocities[2]
    println("Введите t1 t2 t3")

    var times = readLine()!!.split(' ').map { it.toFloat() }
    if (times.size != 3){
        println("Неверное количество временных интервалов!")
        return
    }
    var t1 = times[0]
    var t2 = times[1]
    var t3 = times[2]

    var firstPart = v1*t1
    var secondPart = firstPart + v2*t2
    var thirdPart = secondPart + v3*t3

    if (firstPart >= thirdPart / 2){
        var res = (thirdPart / 2)/v1
        println(res)
    }
    else if (secondPart >= thirdPart / 2){
        var res = t1 + ((thirdPart / 2) - firstPart)/v2
        println(res)
    }
    else{
        var res = t1 + t2 + ((thirdPart/2) - secondPart)/v3
        println(res)
    }

}