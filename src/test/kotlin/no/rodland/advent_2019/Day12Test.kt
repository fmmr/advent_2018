package no.rodland.advent_2019

import no.rodland.advent.DisableSlow
import no.rodland.advent.Slow
import no.rodland.advent.report
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.math.BigInteger

@DisableSlow
internal class Day12Test {
    val data12 = listOf(
            listOf(14, 15, -2),
            listOf(17, -3, 4),
            listOf(6, 12, -13),
            listOf(-2, 10, -8)
    )
    val test12 = listOf(
            listOf(-1, 0, 2),
            listOf(2, -10, -7),
            listOf(4, -8, 8),
            listOf(3, 5, -1)
    )
    val test12_2 = listOf(
            listOf(-8, -10, 0),
            listOf(5, 5, 10),
            listOf(2, -7, 3),
            listOf(9, -8, -3)
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `12,1,test,1`() {
            report {
                Day12.partOne(test12, 10) to 179
            }
        }

        @Test
        fun `12,1,test,2`() {
            report {
                Day12.partOne(test12_2, 100) to 1940
            }
        }

        @Test
        fun `12,1,live`() {
            report {
                Day12.partOne(data12, 1000) to 10189
            }
        }
    }

    @Nested
    inner class `Part 2` {
        @Test
        fun `12,2,test,simple`() {
            report {
                Day12.partTwoTrivial(test12) to 2772
            }
        }

        @Test
        fun `12,2,test,real`() {
            report {
                Day12.partTwoOptimized(test12) to BigInteger("2772")
            }
        }

        @Test
        fun `12,2,test,real_2`() {
            report {
                Day12.partTwoOptimized(test12_2) to BigInteger("4686774924")
            }
        }

        @Test
        @Slow(1100)
        fun `12,2,live`() {
            report {
                Day12.partTwoOptimized(data12) to BigInteger("469671086427712")
            }
        }
    }
}


