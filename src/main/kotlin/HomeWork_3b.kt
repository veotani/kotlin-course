//5. Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
//"220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
//Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
//Высота и соответствующие ей попытки разделяются пробелом.
//Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
//При нарушении формата входной строки вернуть -1.

fun main() {
    var inputString = readLine()

    var commands = inputString!!.split(' ')

    if (commands.count().rem(2) == 1) {
        println("Вы очень плохую строку дали возвращаю -1")
        return
    }

    var maxRes = Int.MIN_VALUE
    for (i in 0..(commands.count() / 2 - 1)) {
        var resultNumber = commands[2 * i].toInt()
        var resultStatus = commands[2 * i + 1]

        if (maxRes < resultNumber && '+' in resultStatus) {
            maxRes = resultNumber
        }
    }

    println("Максимальная высота: $maxRes")
}