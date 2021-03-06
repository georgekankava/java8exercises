package com.java8.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Created by georgekankava on 10.07.17.
 */
public class StreamExample {

    public void higitestCaloricDish(List<Dish> dishes) {
        dishes
                .stream()
                .map(Dish::getCalories)
                .reduce(Integer::max);
    }

    public List<String> extractDishNames(List<Dish> dishes) {
        return dishes.stream()
                    .map(dish -> dish.getName())
                    .collect(toList());
    }

    public Optional<Dish> findAnyExample(List<Dish> dishes) {
        return dishes.stream()
                    .filter(dish -> dish.getCalories() < 300)
                    .findAny();
    }

    public int sumList(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0, Integer::sum);
    }

    public Integer countNumberOfDishes(List<Dish> dishes) {
        return dishes.stream()
                    .map(dish -> 1)
                    .reduce(0, Integer::sum);
    }

    public List<Integer> squareOfNumbers(List<Integer> numbers) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .filter(integer -> i + integer %3 == 0)
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        return numbers.stream()
                    .map(n -> n * n)
                    .collect(toList());
    }

    public void anyMatchExample(List<Dish> menu) {
        if(menu.stream().anyMatch(dish -> dish.isVegetarian())) {
            System.out.println("Menu has vegetarion food.");
        }
    }

    public List<Integer> extractDishNamesLength(List<Dish> dishes) {
        return dishes.stream()
                .map(dish -> dish.getName())
                .map(s -> s.length())
                .collect(toList());
    }

    public List<String> distinctLettersInWord(List<String> words) {
        return words.stream()
                .map(word -> word.split(""))
                .flatMap(strings -> Arrays.stream(strings))
                .distinct()
                .collect(toList());
    }

    public List<String> lowCaloricDishes(List<Dish> menu) {
        return menu.stream()
                    .filter(dish -> dish.getCalories() < 400)
                    .sorted(Comparator.comparing(Dish::getCalories))
                    .map(dish -> dish.getName())
                    .collect(toList());
    }

    public List<Dish> skipFirstTwoElements(List<Dish> dishes) {
        return dishes.stream()
                    .filter(dish -> dish.getCalories() < 300)
                    .skip(2)
                    .collect(toList());
    }

    public static void main(String[] args) {

    }

    public interface Dish {
        int getCalories();
        String getName();
        boolean isVegetarian();
    }
}
