package net.greysparrow.example.model;

import java.util.Optional;

public enum OutputType {

    NONE(),
    FIZZ("Fizz"),
    BUZZ("Buzz"),
    FIZZ_BUZZ("FizzBuzz");

    private final Optional<String> type;

    OutputType() {
        this.type = Optional.empty();
    }

    OutputType(String type) {
        this.type = Optional.of(type);
    }

    public Optional<String> getType() {
        return type;
    }

}
