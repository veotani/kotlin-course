import kotlin.math.pow

// Вариант 5
// Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
// Например, расстояние между (3, 0) и (0, 4) равно 5


fun main(){
    println("Enter point 1 in format: x1 y1:")
    var pointAsString1 = readLine()!!
    var x1 = pointAsString1.split(' ')[0].toFloat()
    var y1 = pointAsString1.split(' ')[1].toFloat()

    println("Enter point 1 in format: x2 y2:")
    var pointAsString2 = readLine()!!
    var x2 = pointAsString2.split(' ')[0].toFloat()
    var y2 = pointAsString2.split(' ')[1].toFloat()

    var distance = ((x2-x1).pow(2.0f) + (y2-y1).pow(2.0f)).pow(0.5f)

    print(distance)
}