package oops.sealedClasses

sealed class Tile
class Red(val type: String, val points: Int) : Tile()
class Blue(val points: Int) : Tile()

fun main() {
    val tile1 = Red("mushroom", 25)
    val tile2 = Red("fire", 30)

    val tile: Tile = Red("Mushroom", 25)
    val points = when (tile) {
        is Red -> tile.points * 2
        is Blue -> tile.points * 5
    }
    println(points)
}