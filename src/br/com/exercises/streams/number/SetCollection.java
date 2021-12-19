package br.com.exercises.streams.number;

import java.util.Optional;
import java.util.Set;

public class SetCollection {

    public static void main(String[] args) {
        sortFromLargestToSmallest();
        sortFromSmallestToLargest();
        getTheHighestNumberOnTheSet();
        getTheLowestNumberOnTheSet();
        multiplyingAllNumbersInTheSetByAnInteger(2);
        takeOnlyEvenNumbersFromTheSet();
        justTakeOddNumbersFromTheSet();
        addUpAllTheNumbersFromTheSet();
        takingTheMathematicalMeanOfTheNumbersInTheSet();
        findValueInTheListGreaterThan30();
        findValueInTheListParallelGreaterThan30();
    }

    public static void sortFromLargestToSmallest() {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Sort from largest to smallest");
        setNumbers.stream().sorted().forEach(number -> {
            System.out.print(" " + number);
        });
    }

    public static void sortFromSmallestToLargest() {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Sort from smallest to largest");
        setNumbers.stream().sorted((number1, number2) -> Integer.compare(number2, number1)).forEach(number -> {
            System.out.print(" " + number);
        });
    }

    public static void getTheHighestNumberOnTheSet() {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Get the highest number on the set");
        Optional<Integer> highestNumber = setNumbers.stream().max(Integer::compare);
        highestNumber.ifPresent(number -> System.out.println(" " + number));
    }

    public static void getTheLowestNumberOnTheSet() {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println("Get the lowest number on the set");
        Optional<Integer> lowestNumber = setNumbers.stream().min(Integer::compare);
        lowestNumber.ifPresent(number -> System.out.println(" " + number));
    }

    public static void multiplyingAllNumbersInTheSetByAnInteger(Integer multiplier) {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println("Multiplying all numbers in the set by an integer");
        setNumbers.stream().map(number -> number * multiplier).forEach(multipliedNumber -> {
            System.out.print(" " + multipliedNumber);
        });
    }

    public static void takeOnlyEvenNumbersFromTheSet() {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Take only even numbers from the set");
        setNumbers.stream().filter(number -> number % 2 == 0).forEach(evenNumber -> {
            System.out.print(" " + evenNumber);
        });
    }

    public static void justTakeOddNumbersFromTheSet() {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Just take odd numbers from the set");
        setNumbers.stream().filter(number -> number % 2 == 1).forEach(evenNumber -> {
            System.out.print(" " + evenNumber);
        });
    }

    public static void addUpAllTheNumbersFromTheSet() {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Add up all the numbers from the set");
        Optional<Integer> summedNumbers = setNumbers.stream().reduce(Integer::sum);
        summedNumbers.ifPresent(number -> System.out.println(" " + number));
    }

    public static void takingTheMathematicalMeanOfTheNumbersInTheSet() {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        Long quantityOfItems = setNumbers.stream().count();
        System.out.println("taking the mathematical mean of the numbers in the set");
        Optional<Integer> summedNumbers = setNumbers.stream().reduce(Integer::sum);
        Double average = (double) summedNumbers.get() / quantityOfItems;
        System.out.println(" " + average);
    }

    public static void findValueInTheListGreaterThan30() {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println("find a value in the list greater than 30");
        Optional<Integer> number = setNumbers.stream().filter(value -> value > 30).findAny();
        System.out.println(number.get());
    }

    public static void findValueInTheListParallelGreaterThan30() {
        Set<Integer> setNumbers = Set.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println("find a value in the list parallel greater than 30");
        Optional<Integer> number = setNumbers.parallelStream().filter(value -> value > 30).findAny();
        System.out.println(number.get());
    }

}
