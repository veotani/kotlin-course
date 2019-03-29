import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon


data class Person(
    @Json(name = "type")
    val supply_type: String

    @Json(name = "name")
    val name: String
)

fun shouldReturnTrue(){
    val result = Klaxon()
            .parse<Person>("""
        {
          "the_name": "John Smith", // note the field name
          "age": 23
        }
    """)
}