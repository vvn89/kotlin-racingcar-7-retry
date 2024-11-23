package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    @Test
    fun `최종 우승자 출력 1명 검증`() {
        //given
        val winners = listOf("pobi")
        val outputView = OutputView()
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        //when
        outputView.printWinner(winners)

        //then
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi")
    }

    @Test
    fun `최종 우승자 출력 2명 검증`() {
        //given
        val winners = listOf("pobi", "java")
        val outputView = OutputView()
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        //when
        outputView.printWinner(winners)

        //then
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi, java")
    }
}