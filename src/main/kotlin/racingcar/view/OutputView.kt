package racingcar.view

class OutputView {
    fun printWinner(winners: List<String>) {
        val finalWinner = winners.joinToString( ", " )
        println("최종 우승자 : $finalWinner")
    }
}