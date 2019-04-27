import java.lang.Exception

// Разработайте класс матрица размерности 3x3 и реализуйте метод сложения элементов матрицы.
// Матрицу хранить как непрерывный массив. В классе реализовать инициализирующий
// конструктор. При реализации методов предполагается, что методы нельзя вызвать, если числа
// матрицы отрицательные.

class Matrix() {

    private var values: Array<Double> = arrayOf(0.0)

    constructor(values: Array<Double>) : this() {
        if (values.size != 9){
            throw Exception("Bad size of the array.")
        }

        this.values = values
    }

    fun sumOfElements(): Double {
        if (values.any { x -> x < 0.0 }) {
            throw Exception("Values can't be less than zero.")
        }

        return values.sum()
    }
}

fun main() {
    // Size is less than 9
    try {
        val badMatrix = Matrix(arrayOf(.0, .1, .2, .3, .4, .5, .6, .7))
        badMatrix.sumOfElements()
    }
    catch (exception: Exception) {
        println(exception.message)
    }

    // There are values less than zero
    try {
        val badMatrix = Matrix(arrayOf(.0, -.1, .2, .3, .4, .5, .6, .7, .8))
        badMatrix.sumOfElements()
    }
    catch (exception: Exception) {
        println(exception.message)
    }

    // This code will run w/o any errors
    val goodMatrix = Matrix(arrayOf(.0, .1, .2, .3, .4, .5, .6, .7, .8))
    println("Сумма элементов матрицы: ${goodMatrix.sumOfElements()}")
}