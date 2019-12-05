package net.greysparrow.example.service.impl;

import net.greysparrow.example.model.OutputType;
import net.greysparrow.example.model.OutputValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntegerNumberServiceTest {

    private IntegerNumberService numberService;
    private OutputValueProvider valueProvider;
    private ByteArrayOutputStream buffer;
    private PrintStream output;

    @BeforeEach
    public void setUp() throws Exception {
        setUpOutputCapture();
        setUpValueProvider();
        setUpService();
    }

    private void setUpOutputCapture() throws UnsupportedEncodingException {
        buffer = new ByteArrayOutputStream();
        output = new PrintStream(buffer, true, "UTF-8");
    }

    private void setUpValueProvider() {
        valueProvider = mock(OutputValueProvider.class);
        when(valueProvider.apply(1)).thenReturn(OutputValue.builder().value(1).outputType(OutputType.NONE).build());
        when(valueProvider.apply(2)).thenReturn(OutputValue.builder().value(2).outputType(OutputType.NONE).build());
        when(valueProvider.apply(3)).thenReturn(OutputValue.builder().value(3).outputType(OutputType.FIZZ).build());
        when(valueProvider.apply(4)).thenReturn(OutputValue.builder().value(4).outputType(OutputType.NONE).build());
        when(valueProvider.apply(5)).thenReturn(OutputValue.builder().value(5).outputType(OutputType.BUZZ).build());
        when(valueProvider.apply(6)).thenReturn(OutputValue.builder().value(6).outputType(OutputType.FIZZ).build());
        when(valueProvider.apply(7)).thenReturn(OutputValue.builder().value(7).outputType(OutputType.NONE).build());
        when(valueProvider.apply(8)).thenReturn(OutputValue.builder().value(8).outputType(OutputType.NONE).build());
        when(valueProvider.apply(9)).thenReturn(OutputValue.builder().value(9).outputType(OutputType.FIZZ).build());
        when(valueProvider.apply(10)).thenReturn(OutputValue.builder().value(10).outputType(OutputType.BUZZ).build());
    }

    private void setUpService() {
        numberService = new IntegerNumberService(valueProvider);
    }

    @Test
    public void canIterateAndOutputValues() throws Exception {
        numberService.iterate(1, 10, output);
        assertThat(buffer.toString("UTF-8").split(System.lineSeparator())).containsExactly(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"
        );
    }

}
