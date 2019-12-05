package net.greysparrow.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzCmdTest {

    private ByteArrayOutputStream buffer;
    private PrintStream output;

    @BeforeEach
    public void setUpOutputCapture() throws UnsupportedEncodingException {
        buffer = new ByteArrayOutputStream();
        output = new PrintStream(buffer, true, "UTF-8");
    }

    @Test
    public void canOutputFizzBuzzValues() throws UnsupportedEncodingException {
        FizzBuzzCmd
                .configureCmd(new String[]{"-max", "35"})
                .configureGuice()
                .run(output);

        assertThat(buffer.toString("UTF-8").split(System.lineSeparator())).containsExactly(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
                "11", "Fizz", "13", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz",
                "Fizz", "22", "23", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz",
                "31", "32", "Fizz", "34", "Buzz"
        );
    }

    @Test
    public void canOutputExtendedFizzBuzzValues() throws UnsupportedEncodingException {
        FizzBuzzCmd
                .configureCmd(new String[]{"-max", "35", "-extended"})
                .configureGuice()
                .run(output);

        assertThat(buffer.toString("UTF-8").split(System.lineSeparator())).containsExactly(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
                "11", "Fizz", "Fizz", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz",
                "Fizz", "22", "Fizz", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz",
                "Fizz", "Fizz", "Fizz", "Fizz", "FizzBuzz"
        );
    }

}
