class Graph {
    private data class Vertex(val name: String) {
        val neighbors = mutableSetOf<Vertex>()
    }

    private val vertices = mutableMapOf<String, Vertex>()

    private operator fun get(name: String) = vertices[name] ?: throw IllegalArgumentException()

    fun addVertex(name: String) {
        vertices[name] = Vertex(name)
    }

    private fun connect(first: Vertex, second: Vertex) {
        first.neighbors.add(second)
        second.neighbors.add(first)
    }

    fun getDistance(fromVertexName: String, toVertexName: String): Int{

        val fromVertex = get(fromVertexName)
        val toVertex   = get(toVertexName)

        var length = 1
        var checkedVerteces = fromVertex.neighbors.toSet()

        if (toVertex in checkedVerteces) return length

        while (true) {
            length++
            var newLevelVerteces = checkedVerteces.toSet().union(checkedVerteces.toSet())

            for (vertex in checkedVerteces) {
                newLevelVerteces = newLevelVerteces.toSet().union(vertex.neighbors.toSet())
            }

            if (toVertex in newLevelVerteces) return length
            if (newLevelVerteces.count() == checkedVerteces.count()) return -1
            checkedVerteces = checkedVerteces.union(newLevelVerteces)
        }
    }

    fun connect(first: String, second: String) = connect(this[first], this[second])
}

// 1.По двум вершинам рассчитать расстояние между ними = число дуг на самом коротком пути
//   между ними.
//   Вернуть -1, если пути между вершинами не существует.
fun main(argv: Array<String>){
    var graph = Graph()
    graph.addVertex("a")
    graph.addVertex("b")
    graph.addVertex("c")
    graph.addVertex("d")
    graph.addVertex("e")
    graph.addVertex("f")
    graph.addVertex("g")
    graph.addVertex("h")

    graph.connect("a", "b")
    graph.connect("b", "c")
    graph.connect("c", "d")

    println(graph.getDistance("a", "d"))
}
