package net.greysparrow.example.service.impl;

import net.greysparrow.example.model.OutputType;
import net.greysparrow.example.service.OutputTypeProvider;

import java.util.function.Predicate;

public abstract class BaseFizzBuzzOutputTypeProvider implements OutputTypeProvider {

    private final Predicate<Integer> threePredicate;
    private final Predicate<Integer> fivePredicate;

    BaseFizzBuzzOutputTypeProvider(Predicate<Integer> threePredicate, Predicate<Integer> fivePredicate) {
        this.threePredicate = threePredicate;
        this.fivePredicate = fivePredicate;
    }

    @Override
    public OutputType apply(int value) {
        if (threePredicate.test(value) && fivePredicate.test(value)) {
            return OutputType.FIZZ_BUZZ;
        }
        else if (threePredicate.test(value)) {
            return OutputType.FIZZ;
        }
        else if (fivePredicate.test(value)) {
            return OutputType.BUZZ;
        }
        else {
            return OutputType.NONE;
        }
    }

}
