import java.lang.Exception

// Разработать класс рациональное число и реализовать метод печати числа. В классе реализовать
// инициализирующий конструктор. При реализации методов предполагается, что методы нельзя
// вызвать, если число не инициализировалось.

class RationalNumber() {

    private var number: String = "Not initialized"

    constructor(value: String) : this() {
        val numberPattern = Regex("\\d+\\.?\\d+")
        if (numberPattern.matches(value)) {
            number = value
        }
        else return
    }

    fun printNumber() {
        if (number == "Not initialized") {
            throw Exception("Can't print number that is not initialized yet.")
        }
        println(number)
    }

}

fun main() {
    // Throws exception because number is not initialized.
    val badNumber = RationalNumber()
    try {
        badNumber.printNumber()
    }
    catch (exception: Exception) {
        println(exception.message)
    }

    // Throws exception because number is not correct.
    val invalidNumber = RationalNumber("121.12.1")
    try {
        invalidNumber.printNumber()
    }
    catch (exception: Exception) {
        println(exception.message)
    }

    // Doesn't throw exception and prints the number.
    val goodNumber = RationalNumber("123123123.12312321321")
    goodNumber.printNumber()
}