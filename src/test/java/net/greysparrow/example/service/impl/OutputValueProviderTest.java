package net.greysparrow.example.service.impl;

import net.greysparrow.example.model.OutputType;
import net.greysparrow.example.model.OutputValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputValueProviderTest {

    private OutputValueProvider provider;

    @BeforeEach
    public void setUp() {
        provider = new OutputValueProvider(new StandardFizzBuzzOutputTypeProvider());
    }

    @ParameterizedTest
    @CsvSource({
            "1, NONE",
            "3, FIZZ",
            "5, BUZZ",
            "15, FIZZ_BUZZ"
    })
    public void canProvideFizzBuzzValues(int value, String outputType) {
        assertThat(provider.apply(value))
                .isEqualTo(OutputValue.builder()
                        .value(value)
                        .outputType(OutputType.valueOf(outputType))
                        .build()
                );
    }

}
