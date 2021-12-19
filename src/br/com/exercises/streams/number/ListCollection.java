package br.com.exercises.streams.number;

import java.util.List;
import java.util.Optional;

public class ListCollection {

    public static void main(String[] args) {
        sortFromLargestToSmallest();
        sortFromSmallestToLargest();
        getTheMighestNumberOnTheList();
        getTheLowestNumberOnTheList();
        multiplyingAllNumbersInTheListByAnInteger(2);
        takeOnlyEvenNumbersFromTheList();
        justTakeOddNumbersFromTheList();
        addUpAllTheNumbersFromTheList();
        takingTheMathematicalMeanOfTheNumbersInTheList();
        findValueInTheListGreaterThan30();
        findValueInTheListParallelGreaterThan30();
    }

    public static void sortFromLargestToSmallest() {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Sort from largest to smallest");
        listNumbers.stream().sorted().forEach(number -> {
            System.out.print(" " + number);
        });
    }

    public static void sortFromSmallestToLargest() {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Sort from smallest to largest");
        listNumbers.stream().sorted((number1, number2) -> Integer.compare(number2, number1)).forEach(number -> {
            System.out.print(" " + number);
        });
    }

    public static void getTheMighestNumberOnTheList() {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Get the highest number on the list");
        Optional<Integer> highestNumber = listNumbers.stream().max(Integer::compare);
        highestNumber.ifPresent(number -> System.out.println(" " + number));
    }

    public static void getTheLowestNumberOnTheList() {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println("Get the lowest number on the list");
        Optional<Integer> lowestNumber = listNumbers.stream().min(Integer::compare);
        lowestNumber.ifPresent(number -> System.out.println(" " + number));
    }

    public static void multiplyingAllNumbersInTheListByAnInteger(Integer multiplier) {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println("Multiplying all numbers in the list by an integer");
        listNumbers.stream().map(number -> number * multiplier).forEach(multipliedNumber -> {
            System.out.print(" " + multipliedNumber);
        });
    }

    public static void takeOnlyEvenNumbersFromTheList() {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Take only even numbers from the list");
        listNumbers.stream().filter(number -> number % 2 == 0).forEach(evenNumber -> {
            System.out.print(" " + evenNumber);
        });
    }

    public static void justTakeOddNumbersFromTheList() {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Just take odd numbers from the list");
        listNumbers.stream().filter(number -> number % 2 == 1).forEach(evenNumber -> {
            System.out.print(" " + evenNumber);
        });
    }

    public static void addUpAllTheNumbersFromTheList() {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println(System.lineSeparator() + "Add up all the numbers from the list");
        Optional<Integer> summedNumbers = listNumbers.stream().reduce(Integer::sum);
        summedNumbers.ifPresent(number -> System.out.println(" " + number));
    }

    public static void takingTheMathematicalMeanOfTheNumbersInTheList() {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        Long quantityOfItems = listNumbers.stream().count();
        System.out.println("taking the mathematical mean of the numbers in the list");
        Optional<Integer> summedNumbers = listNumbers.stream().reduce(Integer::sum);
        Double average = (double) summedNumbers.get() / quantityOfItems;
        System.out.println(" " + average);
    }

    public static void findValueInTheListGreaterThan30() {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println("find a value in the list greater than 30");
        Optional<Integer> number = listNumbers.stream().filter(value -> value > 30).findAny();
        System.out.println(number.get());
    }

    public static void findValueInTheListParallelGreaterThan30() {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println("find a value in the list parallel greater than 30");
        Optional<Integer> number = listNumbers.parallelStream().filter(value -> value > 30).findAny();
        System.out.println(number.get());
    }

}
