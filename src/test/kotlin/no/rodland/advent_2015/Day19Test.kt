package no.rodland.advent_2015

import no.rodland.advent.DisableSlow
import no.rodland.advent.report
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@Suppress("ClassName")
@DisableSlow
internal class Day19Test {
    val data19 = "2015/input_19.txt".readFile()
    val test19 = listOf(
            "H => HO",
            "H => OH",
            "O => HH",
            "",
            "HOH"
    )

    val test19_2 = listOf(
            "H => HO",
            "H => OH",
            "O => HH",
            "",
            "HOHOHO"
    )

    @Nested
    inner class Init {
        @Test
        fun `19,1,live,init`() {
            report {
                Day19.partOne(data19) to 518
            }
        }

        @Test
        fun `19,2,live,init`() {
            report {
                Day19.partTwo(data19) to 200
            }
        }
    }

    @Nested
    inner class `Part 1` {
        @Test
        fun `19,1,test`() {
            report {
                Day19.partOne(test19) to 4
            }
        }

        @Test
        fun `19,1,test,2`() {
            report {
                Day19.partOne(test19_2) to 7
            }
        }

        @Test
        fun `19,1,live,1`() {
            report {
                Day19.partOne(data19) to 518
            }
        }

        @Test
        fun `19,1,live,2`() {
            report {
                Day19.partOne(data19) to 518
            }
        }
    }

    @Nested
    inner class `Part 2` {
        @Test
        fun `19,2,live,1`() {
            report {
                Day19.partTwo(data19) to 200
            }
        }

        @Test
        fun `19,2,live,2`() {
            report {
                Day19.partTwo(data19) to 200
            }
        }
    }
}
