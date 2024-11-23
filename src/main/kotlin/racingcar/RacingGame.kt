package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame {
    val inputView = InputView()
    val outputView = OutputView()

    fun run() {
        val inputNames = inputView.readNames()
        val inputNumber = inputView.readNumber()
        val names = splitNames(inputNames)
        val number = convertNumber(inputNumber)
    }

    private fun convertNumber(inputNumber: String): Int {
        validateInputNumber(inputNumber)
        return inputNumber.toInt()
    }

    fun createCars(names: String) {

    }

    private fun validateInputName(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException()
        }
    }

    private fun validateInputNumber(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException()
        }
        try {
            input.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
    }

    private fun splitNames(inputNames: String): List<String> {
        validateInputName(inputNames)
        return inputNames.split(",")
    }

    fun generateRandomNumber() = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_MIN, RANDOM_NUMBER_RANGE_MAX)

    fun isValidMoveCondition(number: Int): Boolean {
        if (number >= MINIMUM_MOVE_CONDITION) {
            return true
        }
        return false
    }

    companion object {
        const val RANDOM_NUMBER_RANGE_MIN = 0
        const val RANDOM_NUMBER_RANGE_MAX = 9
        const val MINIMUM_MOVE_CONDITION = 4
    }
}