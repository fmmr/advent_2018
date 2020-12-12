package no.rodland.advent

import kotlin.math.atan2
import kotlin.math.pow

data class Pos(val x: Int, val y: Int) : Comparable<Pos> {
    override fun compareTo(other: Pos): Int {
        val yComp = y.compareTo(other.y)
        return if (yComp == 0) {
            x.compareTo(other.x)
        } else yComp
    }

    fun distanceTo(other: Pos): Int {
        return Math.abs(other.x - x) + Math.abs(other.y - y)
    }

    fun directDistance(other: Pos): Double {
        return Math.sqrt((other.x - x).toDouble().pow(2) + (other.y - y).toDouble().pow(2))
    }

    fun neighboorCellsReadingOrder(): List<Pos> {
        return listOf(
            Pos(x, y - 1),
            Pos(x - 1, y),
            Pos(x + 1, y),
            Pos(x, y + 1)
        )
    }

    fun positiveNeighboor(limitX: Int = Int.MAX_VALUE, limitY: Int = Int.MAX_VALUE): List<Pos> {
        return neighboorCellsReadingOrder()
            .filter { it.x >= 0 && it.y >= 0 }
            .filter { it.x < limitX }
            .filter { it.y < limitY }

    }

    fun getNeighboorsNotInMap(map: Map<Pos, *>): List<Pos> {
        return neighboorCellsReadingOrder().filter { !map.containsKey(it) }
    }

    fun neighboorCellsAllEight(): List<Pos> {
        return listOf(
            Pos(x, y - 1),
            Pos(x - 1, y),
            Pos(x + 1, y),
            Pos(x, y + 1),
            Pos(x - 1, y - 1),
            Pos(x + 1, y - 1),
            Pos(x - 1, y + 1),
            Pos(x + 1, y + 1)
        )
    }

    fun angle(another: Pos) = atan2((another.x - x).toDouble(), (another.y - y).toDouble())

    fun getDownNeighbors(): List<Pos> {
        return listOf(
            Pos(x - 1, y),
            Pos(x + 1, y),
            Pos(x, y + 1)
        )
    }

    fun next(c: Char): Pos {
        return when (c) {
            'N', '^' -> above()
            'S', 'v' -> below()
            'W', '<' -> left()
            'E', '>' -> right()
            else -> error("Unable to get pos from direction: $c")
        }
    }

    fun next(s: String): Pos {
        return when (s) {
            "N", "^" -> above()
            "S", "v" -> below()
            "W", "<" -> left()
            "E", ">" -> right()
            "NE" -> ne()
            "SE" -> se()
            "NW" -> nw()
            "SW" -> sw()
            else -> error("Unable to get pos from direction: $s")
        }
    }

    fun getSidesAfterMoving(c: Char): List<Pos> {
        return when (c) {
            'N', 'S' -> listOf(left(), right())
            'E', 'W' -> listOf(below(), above())
            else -> error("Unable to get pos from direction: $c")
        }
    }

    fun isPositive(): Boolean = x >= 0 && y >= 0

    fun isInGrid(maxX: Int, maxY: Int): Boolean = x >= 0 && y >= 0 && x < maxX && y < maxY

    fun above(): Pos = Pos(x, y - 1)
    fun below(): Pos = Pos(x, y + 1)
    fun left(): Pos = Pos(x - 1, y)
    fun right(): Pos = Pos(x + 1, y)
    fun nw(): Pos = Pos(x - 1, y - 1)
    fun ne(): Pos = Pos(x + 1, y - 1)
    fun sw(): Pos = Pos(x - 1, y + 1)
    fun se(): Pos = Pos(x + 1, y + 1)

    companion object {
        fun getMinMax(coordinates: Collection<Pos>): Pair<Pair<Int, Int>, Pair<Int, Int>> {
            val xmin = coordinates.map { it.x }.minOrNull()!!
            val xmax = coordinates.map { it.x }.maxOrNull()!!
            val ymin = coordinates.map { it.y }.minOrNull()!!
            val ymax = coordinates.map { it.y }.maxOrNull()!!
            return (xmin to xmax) to (ymin to ymax)
        }
    }
}