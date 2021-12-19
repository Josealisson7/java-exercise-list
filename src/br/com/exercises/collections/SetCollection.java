package br.com.exercises.collections;

import java.util.HashSet;
import java.util.Set;

public class SetCollection {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        String newData = "World!!";
        set.add("Hello");
        set.add("world");
        System.out.println("I entered this data " + set);
        System.out.println("I want to change this data : world, for this data : " + newData);
        set.removeIf(data -> data.equals("world"));
        set.add(newData);
        System.out.println("Now we have the modified set " + set);
        set.addAll(Set.of("All", "good?"));
        System.out.println("Enter new data in the set " + set);
        set.removeAll(Set.of("All", "good?"));
        System.out.println("I removed the new data " + set);
        set.remove("Hello");
        System.out.println("I removed another data " + set);
        set.add("Hello");
        System.out.println("I returned the set to its original state " + set);
        /* trying to enter a duplicate data */
        System.out.println("trying to insert duplicate data: " + newData);
        set.add(newData);
        System.out.println("Duplicate data is not accepted in sets, this is a peculiarity of set interface implementations. " + set);
    }
}
