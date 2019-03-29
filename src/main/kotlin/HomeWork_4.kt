import java.io.File

//2. В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
//Во входном файле с именем inputName содержится некоторый текст на русском языке.
//Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
//файл outputName текст с исправленными ошибками.
//Регистр заменённых букв следует сохранять.
//Исключения (жюри, брошюра, парашют) в рамках данного задания обрабатывать не нужно

fun main(){

    val FILE_TO_READ = "E:/University/Sem2/internet-apps/kotlin-course/src/main/resources/fileToRead.txt"

    val re_bad_letter_combination = Regex("[жчшщЖЧШЩ]([ыяюЫЯЮ])")

    val REPLACE_RULES = mapOf<Char, Char>(
        'ы' to 'и',
        'я' to 'а',
        'ю' to 'у',
        'Ы' to 'И',
        'Я' to 'А',
        'Ю' to 'У'
    )

    var resultLines = emptyArray<String>()

    File(FILE_TO_READ).forEachLine {line ->
        var newLine = line
        var combinations_to_replace = re_bad_letter_combination.findAll(line)
        combinations_to_replace.forEach {combinations_to_replace ->
            var string_to_replace = combinations_to_replace.value
            var string_new_value = combinations_to_replace.value[0].toString() +
                    REPLACE_RULES.getValue(combinations_to_replace.value[1]).toChar()
            newLine = newLine.replace(string_to_replace, string_new_value)
        }

        resultLines += newLine

    }

    resultLines.forEach { line ->
        println(line)
    }
}