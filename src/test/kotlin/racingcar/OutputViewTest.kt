package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.view.OutputView
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val outputView = OutputView()
    @Test
    fun `최종 우승자 출력 1명 검증`() {
        //given
        val winners = listOf("pobi")
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
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        //when
        outputView.printWinner(winners)

        //then
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi, java")
    }
}