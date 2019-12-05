package net.greysparrow.example.service.impl;

import net.greysparrow.example.model.OutputType;
import net.greysparrow.example.service.OutputTypeProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtendedFizzBuzzOutputTypeProviderTest {

    private OutputTypeProvider provider;

    @BeforeEach
    public void setUp() {
        provider = new ExtendedFizzBuzzOutputTypeProvider();
    }

    @ParameterizedTest
    @CsvSource({
            "1, NONE",
            "2, NONE",
            "3, FIZZ",
            "4, NONE",
            "5, BUZZ",
            "6, FIZZ",
            "7, NONE",
            "8, NONE",
            "9, FIZZ",
            "10, BUZZ",
            "11, NONE",
            "12, FIZZ",
            "13, FIZZ",
            "14, NONE",
            "15, FIZZ_BUZZ",
            "16, NONE",
            "17, NONE",
            "18, FIZZ",
            "19, NONE",
            "20, BUZZ",
            "23, FIZZ",
            "31, FIZZ",
            "35, FIZZ_BUZZ",
            "39, FIZZ",
            "45, FIZZ_BUZZ",
            "51, FIZZ_BUZZ",
            "52, BUZZ",
            "53, FIZZ_BUZZ",
            "57, FIZZ_BUZZ",
            "73, FIZZ",
            "75, FIZZ_BUZZ",
    })
    public void canProvideFizzBuzzValues(int value, String outputType) {
        assertThat(provider.apply(value)).isEqualTo(OutputType.valueOf(outputType));
    }

}
