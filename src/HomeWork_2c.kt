import kotlin.math.pow

// Рассчитать значение многочлена при заданном x:
// p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
// Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
// Значение пустого многочлена равно 0.0 при любом x.

// Рассказать про !! и в readLine()

fun main(){
    print("Введите коэффициенты полинома: ")
    var coefficients = readLine()!!.split(' ').map { it.toFloat() }
    print("\nВведите точку, в которой нужно вычислить значение: ")
    var point = readLine()!!.toFloat()

    var b = checkIfPassing(1f, 2f, 3f, 4f)
    var result = 0f
    coefficients.forEachIndexed { i, pi ->  result += pi*point.pow(i)}

    println(result)
}