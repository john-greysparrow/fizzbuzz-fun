package net.greysparrow.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutputValue {

    private final int value;
    private final OutputType outputType;

    @Override
    public String toString() {
        return outputType.getType().orElse(String.valueOf(value));
    }

}
