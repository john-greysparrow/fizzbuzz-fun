package net.greysparrow.example.service.impl;

import java.util.function.Predicate;

public class StandardFizzBuzzOutputTypeProvider extends BaseFizzBuzzOutputTypeProvider {

    private static final Predicate<Integer> IS_DIVISIBLE_BY_THREE = v -> v % 3 == 0;
    private static final Predicate<Integer> IS_DIVISIBLE_BY_FIVE = v -> v % 5 == 0;

    public StandardFizzBuzzOutputTypeProvider() {
        super(IS_DIVISIBLE_BY_THREE, IS_DIVISIBLE_BY_FIVE);
    }

}
