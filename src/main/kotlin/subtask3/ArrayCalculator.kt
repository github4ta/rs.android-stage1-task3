package subtask3

import java.lang.Math.abs

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        if (itemsFromArray.size == 0) return 0

        var product : Int
        var hasNumberInArray = false
        var numbersFromArray = arrayListOf<Int>()

        itemsFromArray.forEach {
            if (it !is String) {
                hasNumberInArray = true
                numbersFromArray.add(it.toString().toInt())
            }
        }

        if (!hasNumberInArray) {
            return 0
        }

        product = 1
        if (numberOfItems >= numbersFromArray.size) {
            numbersFromArray.forEach {
                product *= it
            }
            return product
        }

        product = 1
        numbersFromArray.sort()
        var firstIndex = 0
        do {
            product = getProduct(getNumbers(numbersFromArray, firstIndex, numberOfItems))
            firstIndex += 1
        } while (product < 0)
        return product
    }

    private fun getNumbers(numbers: ArrayList<Int>, index: Int, counts: Int): ArrayList<Int> {
        var indexStart = index
        var indexEnd = numbers.size - 1
        var valueStart = numbers[indexStart]
        var valueEnd = numbers[indexEnd]
        var selectedNumbers = arrayListOf<Int>()

        for(i in counts downTo 1) {
            if (abs(valueStart) < abs(valueEnd)) {
                selectedNumbers.add(valueEnd)
                indexEnd -= 1
                valueEnd = numbers[indexEnd]
            } else {
                selectedNumbers.add(valueStart)
                indexStart += 1
                valueStart = numbers[indexStart]
            }
        }
        return selectedNumbers
    }

    private fun getProduct(numbers: ArrayList<Int>): Int {
        var product = 1
        numbers.forEach { product *= it }
        return product
    }
}
