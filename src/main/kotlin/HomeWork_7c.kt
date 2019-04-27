import java.lang.Exception

// Необходимо разработать класс матрица. Размер матриц фиксирован 3x3. При реализации класса
// матрицу необходимо реализовать как массив векторов. В приведенных классах разработать
// методы позволяющие инициализировать элементы матрицы посредствам двойной индексации (A.
// row(1).cell(3) = 10). В классе реализовать конструктор копирования и деструктор. В классе
// реализовать конструктор по умолчанию. При реализации методов предполагается, что методы
// нельзя вызвать, если индекс элемента больше или равен 3.

class Vector {
    var cell: Array<Double>? = arrayOf(.0, .0, .0)

    operator fun set(index: Int, value: Double) {
        if (index >= 3){
            throw Exception("Index is out of range.")
        }
        cell!![index] = value
    }

    override fun toString(): String {
        var res = ""
        for (index: Int in 0..2)
            res += cell!![index].toString() + " "
        return res
    }
}

class MatriX {
    var rows: Array<Vector>? = arrayOf(Vector(), Vector(), Vector())

    constructor() {
        for (i: Int in 0..2)
            for (j: Int in 0..2)
                rows!![i][j] = .0
    }

    constructor(otherMatrix: MatriX) {
        this.rows!![0] = otherMatrix[0]
        this.rows!![1] = otherMatrix[1]
        this.rows!![2] = otherMatrix[2]
    }

    operator fun get(index: Int): Vector {
        if (index >= 3){
            throw Exception("Index is out of range.")
        }
        return rows!![index]
    }

    operator fun set(index: Int, value: Vector){
        if (index >= 3){
            throw Exception("Index is out of range.")
        }
        rows!![index] = value
    }

    fun finalize(){
        rows = null
    }

    override fun toString(): String {
        var res = ""
        for (index: Int in 0..2)
            res += this.rows!![index].toString() + "\n"
        return res
    }
}

fun main() {
    var A = MatriX()

    // Bad column
    try {
        A[2][3] = .2
    }
    catch (e: Exception){
        println(e.message)
    }

    // Bad row
    try {
        A[3][2] = .2
    }
    catch (e: Exception){
        println(e.message)
    }

    A[2][2] = .2

    var B = MatriX(A)

    println("Матрица A: ")
    println(A)
    println("Матрица B: ")
    println(B)
}
