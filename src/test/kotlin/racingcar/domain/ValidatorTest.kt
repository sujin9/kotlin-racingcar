package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    @ValueSource(strings = ["", "jinini"])
    @ParameterizedTest
    fun `자동차 이름이 짧거나 긴 경우 오류 발생`(input: String) {
        assertThat(
            Validator.isNameLengthInRange(input),
        ).isFalse
    }

    @ValueSource(strings = ["", "a", "0d9", "-1"])
    @ParameterizedTest
    fun `숫자가 올바르지 않은 경우 오류 발생`(input: String) {
        assertThat(
            Validator.isNumber(input),
        ).isFalse
    }
}
