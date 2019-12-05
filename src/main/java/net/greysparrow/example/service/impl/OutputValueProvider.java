package net.greysparrow.example.service.impl;

import com.google.inject.Inject;
import net.greysparrow.example.model.OutputValue;
import net.greysparrow.example.service.OutputTypeProvider;

import java.util.function.IntFunction;

public class OutputValueProvider implements IntFunction<OutputValue> {

    private final OutputTypeProvider typeProvider;

    @Inject
    public OutputValueProvider(OutputTypeProvider typeProvider) {
        this.typeProvider = typeProvider;
    }

    @Override
    public OutputValue apply(int value) {
        return OutputValue.builder()
                .value(value)
                .outputType(typeProvider.apply(value))
                .build();
    }

}
