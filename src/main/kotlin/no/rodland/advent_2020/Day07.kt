package no.rodland.advent_2020

object Day07 {
    fun partOne(list: List<String>): Int {
        val bags = list.map { fromTo(it) }
        val start = bags.filter { it.second.contains(Bag("shiny gold")) }.map { it.first }
        var size = 0
        val seq = generateSequence(start) { newList ->
            (newList + bags.filter { fromTo -> newList.any { fromTo.second.contains(it) } }.map { it.first }).distinct()
        }.takeWhile { newList ->
            val prevSize = size
            size = newList.size
            newList.size > prevSize
        }
        return seq.last().size
    }

    private fun fromTo(line: String): Pair<Bag, List<Bag>> {
        //    posh tomato bags contain 4 faded coral bags, 2 dull chartreuse bags, 4 shiny teal bags, 3 light beige bags.
        val splitted = line.split(" contain ", ", ", ".").filter { it.isNotEmpty() }
        return Bag(splitted[0].replace(" bags", "")) to Bag.list(splitted.subList(1, splitted.size))
    }

    data class Bag(val color: String) {
        companion object {
            val regex = """(\d+) (.*) bags?""".toRegex()
            private fun MatchResult.toInt(i: Int) = groups[i]!!.value.toInt()
            fun list(str: List<String>): List<Bag> {
                return str.flatMap {
                    if ("no other bags" == it) {
                        emptyList()
                    } else {
                        val find = regex.find(it)!!
                        val number = find.toInt(1)
                        val colour = find.groups[2]!!.value
                        MutableList(number) { Bag(colour) }
                    }
                }
            }
        }
    }

    fun partTwo(list: List<String>): Int {
        val bags = list.map { fromTo(it) }.toMap()
        val start = bags[Bag("shiny gold")]!!
        return countBags(bags, start) - 1
    }

    private fun countBags(bags: Map<Bag, List<Bag>>, start: List<Bag>): Int {
        return if (start.isEmpty()) {
            1
        } else {
            1 + start.map { countBags(bags, bags[it]!!) }.sum()
        }
    }
}
