package no.rodland.advent_2016

import no.rodland.advent.DisableSlow
import no.rodland.advent.report
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@Suppress("ClassName")
@DisableSlow
internal class Day10Test {
    val data10 = "2016/input_10.txt".readFile()


    @Nested
    inner class Init {
        @Test
        fun `10,1,live,init`() {
            report {
                Day10.partOne(data10) to 47
            }
        }

        @Test
        fun `10,2,live,init`() {
            report {
                Day10.partTwo(data10) to 2666
            }
        }
    }

    @Nested
    inner class `Part 1` {
        @Test
        fun `10,1,live,1`() {
            report {
                Day10.partOne(data10) to 47
            }
        }

        @Test
        fun `10,1,live,2`() {
            report {
                Day10.partOne(data10) to 47
            }
        }
    }

    @Nested
    inner class `Part 2` {
        @Test
        fun `10,2,live,1`() {
            report {
                Day10.partTwo(data10) to 2666
            }
        }

        @Test
        fun `10,2,live,2`() {
            report {
                Day10.partTwo(data10) to 2666
            }
        }
    }
}
