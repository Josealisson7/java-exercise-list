package br.com.exercises.collections;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {

    public static void main(String[] args) {
        int index = 1;
        String newData = "World!!!";
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("world");
        System.out.println("I entered this data " + list);
        System.out.println("I want to change this data : " + list.get(index) + ", for this data : " + newData);
        list.set(index, newData);
        System.out.println("Now we have the modified list " + list);
        list.addAll(List.of("All", "good?"));
        System.out.println("Enter new data in the list " + list);
        list.removeAll(List.of("All", "good?"));
        System.out.println("I removed the new data " + list);
        list.remove(0);
        System.out.println("I removed another data " + list);
        list.add(0, "Hello");
        System.out.println("I returned the list to its original state " + list);
    }
}
