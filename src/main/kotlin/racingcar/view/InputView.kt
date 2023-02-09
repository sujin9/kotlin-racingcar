package racingcar.view

import racingcar.constant.ERROR_NAME_LENGTH
import racingcar.constant.ERROR_WRONG_NUMBER
import racingcar.domain.Validator

class InputView {
    fun getCarsName(): List<String> {
        val input = readLine()?.trim()
        val names: List<String>

        if (!input.isNullOrBlank()) {
            names = input.split(",").map {
                it.trim()
            }
            checkNameLength(names)
        } else {
            throw IllegalArgumentException(ERROR_NAME_LENGTH)
        }

        return names
    }

    fun checkNameLength(value: List<String>) {
        value.forEach {
            require(Validator.isNameLengthInRange(it)) { ERROR_NAME_LENGTH }
        }
    }

    fun getMovingCount(): Int {
        val input = readLine()?.trim()

        if (!input.isNullOrBlank()) {
            require(Validator.isNumber(input)) { ERROR_WRONG_NUMBER }
        } else {
            throw IllegalArgumentException(ERROR_WRONG_NUMBER)
        }

        return input.toInt()
    }
}
