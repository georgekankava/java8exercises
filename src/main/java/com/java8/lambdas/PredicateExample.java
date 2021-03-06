package com.java8.lambdas;

import java.util.function.Predicate;

/**
 * Created by georgekankava on 09.07.17.
 */
public class PredicateExample {
    public static void main(String[] args) {
        // Call with a lambda expression
        Predicate<Apple> applePredicate = apple -> apple.getWeight() > 100;
        // Predicate with and expression
        applePredicate = applePredicate.and(apple -> apple.getCountry().isEmpty());
        // Negate predicate
        Predicate<Apple> negatedApplePredicate = applePredicate.negate();
    }

    private interface Apple {
        int getWeight();
        String getCountry();
    }
}
