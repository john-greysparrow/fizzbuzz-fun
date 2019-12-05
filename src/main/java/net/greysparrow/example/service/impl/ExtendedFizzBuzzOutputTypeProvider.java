package net.greysparrow.example.service.impl;

import net.greysparrow.example.model.OutputType;
import net.greysparrow.example.service.OutputTypeProvider;

import java.util.function.Predicate;

public class ExtendedFizzBuzzOutputTypeProvider extends BaseFizzBuzzOutputTypeProvider {

    private static final Predicate<Integer> isDivisibleByThree = v -> v % 3 == 0;
    private static final Predicate<Integer> isDivisibleByFive = v -> v % 5 == 0;

    private static final Predicate<Integer> containsDigitThree = v -> String.valueOf(v).contains("3");
    private static final Predicate<Integer> containsDigitFive = v -> String.valueOf(v).contains("5");

    private static final Predicate<Integer> threePredicate = isDivisibleByThree.or(containsDigitThree);
    private static final Predicate<Integer> fivePredicate = isDivisibleByFive.or(containsDigitFive);

    public ExtendedFizzBuzzOutputTypeProvider() {
        super(threePredicate, fivePredicate);
    }

}
