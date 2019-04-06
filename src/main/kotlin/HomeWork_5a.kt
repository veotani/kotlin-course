import java.awt.Point
import java.lang.Math.*

//Дан класс: Прямая, заданная точкой point и углом наклона angle (в радианах) по отношению к оси
//X.
//Уравнение прямой: (y - point.y) * cos(angle) = (x - point.x) * sin(angle)
//или: y * cos(angle) = x * sin(angle) + b, где b = point.y * cos(angle) - point.x * sin(angle).
//Угол наклона обязан находиться в диапазоне от 0 (включительно) до PI (исключительно).
class Line private constructor(val b: Double, val angle: Double) {
    init {
        require(angle >= 0 && angle < PI) { "Incorrect line angle: $angle" }
    }
    constructor(point: Point, angle: Double): this(point.y * cos(angle) - point.x * sin(angle), angle)
    override fun equals(other: Any?) = other is Line && angle == other.angle && b == other.b
    override fun hashCode(): Int {
        var result = b.hashCode()
        result = 31 * result + angle.hashCode()
        return result
    }
    override fun toString() = "Line(${cos(angle)} * y = ${sin(angle)} * x + $b)"
}



//5. Найти точку пересечения с другой линией.Для этого необходимо составить и решить систему из
//двух уравнений (каждое для своей прямой)

fun main(){

    print("Введите значения точки и угла в соответствии с форматом \"x y angle\": ")
    val line1InpString = readLine()!!.split(" ")
    val line1Point = Point(line1InpString[0].toInt(), line1InpString[1].toInt())
    val line1Angle = line1InpString[2].toDouble()
    val line1 = Line(line1Point, line1Angle)

    print("Введите значения точки и угла в соответствии с форматом \"x y angle\": ")
    val line2InpString = readLine()!!.split(" ")
    val line2Point = Point(line2InpString[0].toInt(), line2InpString[1].toInt())
    val line2Angle = line2InpString[2].toDouble()
    val line2 = Line(line2Point, line2Angle)


    /**
     * Вывод уравнения:
     * y * cos(angle) = x * sin(angle) + b / :cos(angle)
     * y = x * tg(angle) + b/cos(angle)
     * Пусть b := b/cos(angle)
     * Тогда
     * y = x * tg(angle) + b, где
     * b = b/cos(angle) = point.y - point.x * tg(angle)
     *
     * Имеется следующая система
     * |y = x * tg(angle1) + b1
     * |y = x * tg(angle2) + b2
     * bi, angle_i -- известные величины
     * Вычтем второе уравнение из первого:
     * 0 = x(tg(angle1)-tg(angle2))+b1-b2 =>
     * x =        b2-b1
     *           -------
     *      tg(angle1)-tg(angle2)
     */

    val b1 = line1Point.y - line1Point.x * tan(line1Angle)
    val b2 = line2Point.y - line2Point.x * tan(line2Angle)

    val x = (b2-b1)/(tan(line1Angle)- tan(line2Angle))
    val y = x * tan(line2Angle) + b2

    println("Решение найдено! Получили точку ($x, $y)")
}