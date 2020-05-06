package subtask1

import java.lang.Math.abs

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.size == 0) return null
        if (numbers.size == 1) {
            if (numbers[0] == 0) {
                return ""
            } else {
                return numbers[0].toString()
            }
        }

        val result = StringBuilder()
        var isFirst : Boolean
        var firstIndex = 0

        for (i in 0..numbers.size - 1) {
            if (numbers[i] == 0) {
                firstIndex += 1
                continue
            }
            if (i <= firstIndex) isFirst = true else isFirst = false
            result.append(getPolynomet(numbers[i], numbers.size - 1 - i, isFirst))
            print(getPolynomet(numbers[i], numbers.size - 1 - i, isFirst))
        }
        return result.toString()
    }

    private fun getPolynomet(number: Int, power: Int, first: Boolean): String {
        when (number) {
            0 -> return ""
            1 -> if (power != 0) return getCoefficient(number, first).plus(getVariablePower(power)) else return getCoefficient(number, first).plus(1)
            else -> if (power !=0) return getCoefficient(number, first).plus(getVariablePower(power)) else return getCoefficient(number, first)
        }
        return ""
    }

    private fun getSign(number: Int): String {
        if (number > 0) return "+"
        if (number < 0) return "-"
        return ""
    }

    private fun getCoefficient(number: Int, first: Boolean): String {
        if (!first) {
            when (number) {
                0 -> return ""
                1 -> return " + "
                -1 -> return " - "
                else -> return " ${getSign(number)} ${abs(number)}"
            }
        } else {
            when (number) {
                0 -> return ""
                1 -> return ""
                -1 -> return "-"
                else -> if (number < 0) return getSign(number).plus(abs(number)) else return abs(number).toString()
            }
        }
        return ""
    }

    private fun getVariablePower(power: Int): String {
        when (power) {
            0 -> return ""
            1 -> return "x"
            else -> return "x^$power"
        }
    }
}
