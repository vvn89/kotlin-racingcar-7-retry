package racingcar.view

import racingcar.Car

class OutputView {
    fun printRacing(car: Car) {
        println("${car.name} : ${DISTANCE_SYMBOL.repeat(car.distance)}")
    }

    fun printWinner(winners: List<String>) {
        val finalWinner = winners.joinToString( JOIN_SEPARATOR )
        println("최종 우승자 : $finalWinner")
    }

    companion object {
        const val DISTANCE_SYMBOL = "-"
        const val JOIN_SEPARATOR = ", "
    }
}