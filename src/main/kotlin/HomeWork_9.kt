import java.io.File
import java.sql.Time
import java.util.*
import kotlin.concurrent.timer

// Реализовать многопоточное приложение, реализующее поиск подстроки в файлах. Список файлов передается в качестве парам
// етра командной строки. Для каждого файла выделяется отдельный поток. Для вывода результатов поиска в консоль создает
// ся отдельный поток, считывающий данные по мере поступления из разделяемого списка объектов класса SearchResult, имеющ
// его следующие поля «имя файла», «индекс вхождения»

data class SearchResult(val fileName: String, val index: Int)

class SearchResults
{
    var searchResults: MutableList<SearchResult?> = mutableListOf()
    @Synchronized fun addSearchRes(searchRes: SearchResult?)
    {
        searchResults.add(searchRes)
    }
}


fun main() {
    val query = "инфор"

    val fileNames = arrayOf(
            "src/main/resources/hw9_1.txt",
            "src/main/resources/hw9_2.txt",
            "src/main/resources/hw9_3.txt"
    )

    var searchResults = SearchResults()
    var threadsList: MutableList<Thread> = mutableListOf()

    for (fileName in fileNames)
        threadsList.add(Thread(Runnable {
            println("Starting to search for query in file $fileName")
            val file = File(fileName)
            for (line in file.readLines()) for (startIndex in 0..(line.length - query.length)) {
                if (line.substring(startIndex until startIndex + query.length) == query)
                {
                    val searchRes = SearchResult(fileName, startIndex)
                    searchResults.addSearchRes(searchRes)
                }
            }
            searchResults.addSearchRes(null)
            println("Finished with $fileName")
        }))


    val printerThread = Thread(Runnable {
        println("Waiting for any search results")
        var valuesPrinted = 0
        var finishedThreadsCount = 0
        val threadsLaunched = fileNames.size
        /*
        I still dont understand resources management in multithreaded world. I feel this synchronized block is
        used wrong by me. On the one hand i always block searchResults in a very fast while cycle (so it's locked almost
        forever).
        On the other there are no need of other threads to have lot of "searchResults" variable access. Im also not sure
        how the things work.
        In my understanding it's just like this: synchronized locks searchResults and makes the
        "if" statement on it. Meanwhile if other thread tries to write new value to searchResults it goes into
        addSearchRes method and "locks" it, but while he is inside he waits for synchronized to release
        searchResults. After that he writes his value and goes away from searchResults. This is surely may be
        improved, but i've gotta start doing big-data course tasks to get more knowledge on parallel programming.
        This is just a reminder for myself that this code is not for reusing in real projects and not a knowledge
        base. Im also warning all those who suddenly reads it to not use this code.
        Linking very useful page on parallel primitives in JVM:
        https://medium.com/@korhanbircan/multithreading-and-kotlin-ac28eed57fea

        P.S. Kotlin approach doesn't make you use Threads class, but in this task we have to do it without coroutines.
        */
        while (finishedThreadsCount != threadsLaunched)
            synchronized(searchResults) {
                if (valuesPrinted != searchResults.searchResults.size) {
                    val lastSearchRes = searchResults.searchResults[valuesPrinted]
                    if (lastSearchRes == null) {
                        finishedThreadsCount++
                        valuesPrinted++
                    } else {
                        println("Found: in ${lastSearchRes!!.fileName} at position ${lastSearchRes!!.index}")
                        valuesPrinted++
                    }
                }
            }
    })

    threadsList.add(printerThread)
    //printerThread.start()

    for (thread in threadsList) {
        thread.start()
    }

    for (thread in threadsList)
        thread.join()
    printerThread.join()
}
