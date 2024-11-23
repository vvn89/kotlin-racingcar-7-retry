package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
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