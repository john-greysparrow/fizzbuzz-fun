package net.greysparrow.example.service.impl;

import com.google.inject.Inject;
import net.greysparrow.example.service.NumberService;

import java.io.PrintStream;
import java.util.stream.IntStream;

public class IntegerNumberService implements NumberService {

    private final OutputValueProvider outputValueProvider;

    @Inject
    public IntegerNumberService(OutputValueProvider outputValueProvider) {
        this.outputValueProvider = outputValueProvider;
    }

    @Override
    public void iterate(int minimumValue, int maximumValue, PrintStream out) {
        IntStream
                .rangeClosed(minimumValue, maximumValue)
                .mapToObj(outputValueProvider)
                .forEach(out::println);
    }

}
