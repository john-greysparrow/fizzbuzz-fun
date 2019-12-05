package net.greysparrow.example.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputValueTest {

    @ParameterizedTest
    @CsvSource({
            "1, NONE, 1",
            "3, FIZZ, Fizz",
            "5, BUZZ, Buzz",
            "15, FIZZ_BUZZ, FizzBuzz"
    })
    public void canProvideFizzBuzzToStringValues(int value, String outputType, String toStringValue) {
        assertThat(
                OutputValue.builder()
                        .value(value)
                        .outputType(OutputType.valueOf(outputType))
                        .build()
                        .toString()
        )
                .isEqualTo(toStringValue);
    }

}
