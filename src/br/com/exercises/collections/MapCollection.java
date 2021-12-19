package br.com.exercises.collections;

import java.util.HashMap;
import java.util.Map;

public class MapCollection {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Hello");
        map.put(1, "world");
        String newData = "World!!!";
        System.out.println(map);
        System.out.println("I entered this data " + map);
        System.out.println("I want to change this data : world, for this data : " + newData);
        map.replace(1, newData);
        System.out.println("Now we have the modified map " + map);
        map.putAll(Map.of(2, "All", 3, "good?"));
        System.out.println("Enter new data in the map " + map);
        map.remove(2);
        map.remove(3);
        System.out.println("I removed the new data " + map);
        map.remove(0, "Hello");
        System.out.println("I removed another data " + map);
        map.put(0, "Hello");
        System.out.println("I returned the map to its original state " + map);
    }
}
