package no.rodland.advent_2020

import no.rodland.advent.DisableSlow
import no.rodland.advent.report
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@Suppress("ClassName")
@DisableSlow
internal class Day17Test {
    val data17 = "2020/input_17.txt".readFile()
    val test17 = listOf("1", "2")

    @Nested
    inner class Init {
        @Test
        fun `17,1,live,init`() {
            report {
                Day17.partOne(data17) to 2
            }
        }

        @Test
        fun `17,2,live,init`() {
            report {
                Day17.partTwo(data17) to 2
            }
        }
    }

    @Nested
    inner class `Part 1` {
        @Test
        fun `17,1,test`() {
            report {
                Day17.partOne(test17) to 2
            }
        }

        @Test
        fun `17,1,live,1`() {
            report {
                Day17.partOne(data17) to 2
            }
        }

        @Test
        fun `17,1,live,2`() {
            report {
                Day17.partOne(data17) to 2
            }
        }
    }

    @Nested
    inner class `Part 2` {
        @Test
        fun `17,2,test`() {
            report {
                Day17.partTwo(test17) to 2
            }
        }

        @Test
        fun `17,2,live,1`() {
            report {
                Day17.partTwo(data17) to 2
            }
        }

        @Test
        fun `17,2,live,2`() {
            report {
                Day17.partTwo(data17) to 2
            }
        }
    }
}