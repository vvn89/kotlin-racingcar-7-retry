package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingGameTest {
    @ParameterizedTest(name = "isValidMoveCondition({0}) 테스트")
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `isValidMoveCondition 메서드 이동 테스트`(number: Int) {
        //when
        val result = RacingGame().isValidMoveCondition(number)

        //then
        assertThat(result).isEqualTo(true)
    }

    @ParameterizedTest(name = "isValidMoveCondition({0}) 테스트")
    @ValueSource(ints = [0, 1, 2, 3])
    fun `isValidMoveCondition 메서드 정지 테스트`(number: Int) {
        //when
        val result = RacingGame().isValidMoveCondition(number)

        //then
        assertThat(result).isEqualTo(false)
    }
}