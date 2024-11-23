package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val inputNames = inputView.readNames()
        val inputNumber = inputView.readNumber()
        val names = splitNames(inputNames)
        val number = convertNumber(inputNumber)
        val cars = createCars(names)
        play(cars, number)
        findWinner(cars)
    }

    private fun findWinner(cars: List<Car>) {
        val winnerDistance: Int = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == winnerDistance }.map { it.name }
        outputView.printWinner(winners)
    }

    fun play(cars: List<Car>, number: Int) {
        repeat(number) {
            cars.forEach {
                val randomNumber = generateRandomNumber()
                if (isValidMoveCondition(randomNumber)) {
                    it.move()
                }
                outputView.printRacing(it)
            }
        }
    }

    private fun convertNumber(inputNumber: String): Int {
        validateInputNumber(inputNumber)
        return inputNumber.toInt()
    }

    fun createCars(names: List<String>): List<Car> {
        val cars: MutableList<Car> = mutableListOf()
        names.forEach { cars.add(Car(name = it)) }
        return cars
    }

    private fun validateInputName(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException()
        }
        if (input.split(SEPERATOR).any { it.length !in 1..5 }) {
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
        return inputNames.split(SEPERATOR)
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

        const val SEPERATOR = ","
    }
}