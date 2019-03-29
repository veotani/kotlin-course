//5. Входными данными является ассоциативный массив "название товара"-"пара (тип товара,
//цена товара)" и тип интересующего нас товара.Необходимо вернуть название товара
//заданного типа с минимальной стоимостью или null в случае, если товаров такого типа нет.
//Например:
//findCheapestStuff(
//mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
//"печенье"
//) -> "Мария"

fun main() {
    var items = mapOf(
        "Неправильный" to ("непеченье" to 20.0),
        "Мария" to ("печенье" to 20.0),
        "Орео" to ("печенье" to 100.0),
        "древний" to ("печенье" to 19.0),
        "медузка" to ("печенье" to 20.0)
    )

    println("Какой товар вы хотите?")
    var response = readLine()!!

    var filteredItems = items.filter { it -> it.value.first == response }

    var sortedItems = filteredItems.toList().sortedBy {
            (_, value) -> value.second
    }.toMap()

    println(sortedItems.values.toList()[0])

    for (item: String in sortedItems.keys) {
        println(item)
    }
}