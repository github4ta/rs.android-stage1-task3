package subtask4

import java.lang.Math.sqrt
import kotlin.math.truncate

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 4) {
            return null
        }

        var numbers = arrayListOf<Int>()
        numbers.add(number - 1)

        var part = number * number - numbers[0] * numbers[0]
        var squareRoot = 0

        var isNotReady = true
        var i = 0
        var startNumber = truncate(sqrt(part.toDouble())).toInt()
        var numbersArray = arrayListOf<Int>()
        var numbersSet = setOf<Int>()

        while (isNotReady) {
            numbersArray = arrayListOf<Int>()
            numbersArray.add(startNumber)
            var part2 = part

            while (part2 >= 1) {
                part2 = part2 - numbersArray[i] * numbersArray[i]
                squareRoot = truncate(sqrt(part2.toDouble())).toInt()
                numbersArray.add(squareRoot)
                i += 1
            }

            numbersSet = numbersArray.toSet()
            var counts1 = 0
            var counts2 = 0
            var counts3 = 0
            for (i in 0..numbersArray.size-1) {
                if (numbersArray[i] == 1) {
                    counts1 += 1
                }
                if (numbersArray[i] == 2) {
                    counts2 += 1
                }
                if (numbersArray[i] == 3) {
                    counts3 += 1
                }
            }

            if (numbersArray.toIntArray().contentEquals(numbersSet.toIntArray())) {
                isNotReady = false

            } else {
                if (numbersArray.size - numbersSet.size > 0) {
                    startNumber = numbersSet.elementAt(1) - 1
                } else {
                    startNumber = numbersSet.elementAt(0) - 1
                }
                i = 0
            }
        }

        for (i in 0..numbersArray.size - 1) {
            if (numbersArray[i] > 0) {
                numbers.add(numbersArray[i])
            }
        }

        numbers.sort()
        return numbers.toTypedArray()
    }
}
