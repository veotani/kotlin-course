
// Вариант 5
// Поменять порядок цифр заданного числа n на обратный:
// 13478 -> 87431. Использовать операции со строками в
// этой задаче запрещается.

fun main(){
    println("Введите число")
    var number = readLine()!!.toInt()
    var result = 0

    while (number > 0){
        result = result * 10 + number % 10
        number /= 10;
    }

    print(result)
}