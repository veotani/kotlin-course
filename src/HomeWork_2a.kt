
// Вариант 5
// Определить, пройдет ли кирпич со сторонами а, b, c
// сквозь прямоугольное отверстие в стене со сторонами
// r и s. Стороны отверстия должны быть параллельны
// граням кирпича. Считать, что совпадения длин сторон
// достаточно для прохождения кирпича, т.е., например,
// кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
// Вернуть true, если кирпич пройдёт

fun checkIfPassing(x: Float, y: Float, a: Float, b: Float): Boolean{
    if (x <= a && y <= b || x <= b && y <= a) return true
    return false
}

fun main(){
    println("Введите 3 значения (1 значение на строку) для сторон кирпича")
    var a = readLine()!!.toFloat()
    var b = readLine()!!.toFloat()
    var c = readLine()!!.toFloat()

    println("Введите 2 значения (1 значение на строку) для сторон отверстия")
    var r = readLine()!!.toFloat()
    var s = readLine()!!.toFloat()

    var isPassing = false;
    isPassing = checkIfPassing(a, b, r, s) || isPassing
    isPassing = checkIfPassing(a, c, r, s) || isPassing
    isPassing = checkIfPassing(b, c, r, s) || isPassing

    if (isPassing) println("Пройдёт!")
    else println("Не пройдёт!")
}