import java.lang.Math.abs

//Определить число ходов, за которое шахматный слон пройдёт из клетки start в клетку end.
//Шахматный слон может за один ход переместиться на любую другую клетку по диагонали.
//Ниже точками выделены возможные ходы слона, а крестиками -- невозможные:
//.xxx.ххх
//x.x.xххх
//
//xxСxxxxx
//x.x.xххх
//.xxx.ххх
//xxxxx.хх
//xxxxxх.х
//xxxxxхх.
//Если клетки start и end совпадают, вернуть 0.
//Если клетка end недостижима для слона, вернуть -1.
//Если любая из клеток некорректна, бросить IllegalArgumentException().
//Примеры: bishopMoveNumber(Square(3, 1), Square(6, 3)) = -1; bishopMoveNumber(Square(3, 1),
//Square(3, 7)) = 2.
//Слон может пройти через клетку (6, 4) к клетке (3, 7).

data class Square(val column: Int, val row: Int) {
    init {
        require(column in 1..8 && row in 1..8) { "Размер поля 8x8, однако введённое положение выходит за эти" +
            "рамки" }
    }
    override fun equals(other: Any?) = other is Square && column == other.column && row == other.row
}

fun bishopMoveNumber(from: Square, to: Square): Int{
    if (from==to) return 0
    if (abs(from.column - to.column) == abs(from.row - to.row)) return 1
    if (abs(from.column - to.column) % 2 == 0 && abs(from.row - to.row) % 2 == 0) return 2
    return -1
}

fun main(args: Array<String>){

    print("Задайте начальную позицию в формате (column row): ")
    val fromPointInitLineSplited = readLine()!!.split(" ")

    print("Задайте конечную позицию в формате (column row): ")
    val toPointInitLineSplited = readLine()!!.split(" ")

    val fromPoint = Square(fromPointInitLineSplited[0].toInt(), fromPointInitLineSplited[1].toInt())
    val toPoint = Square(toPointInitLineSplited[0].toInt(), toPointInitLineSplited[1].toInt())

    val result = bishopMoveNumber(fromPoint, toPoint)

    print("Результат: $result")
}