package br.com.exercises.paralelism.executorsclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParalelismExecutors {
    final static String DIRECTORY = "./src/br/com/exercises/paralelism/executorsclass/files/";

    public static void main(String[] args) {
        /* switch between the methods by removing the comment from one and commenting on the other */

        //readFilesNotUsingMultipleThreads();
        readFilesUsingMultipleThreads();
    }

    public static void readFilesUsingMultipleThreads() {
        try {
            ExecutorService threadPool = Executors.newFixedThreadPool(2);
            Future<String> future = threadPool.submit(() -> {
                System.out.println("I was executed on the thread " + Thread.currentThread().getName());
                return ParalelismExecutors.readFile("File");
            });
            Future<String> future2 = threadPool.submit(() -> {
                System.out.println("I was executed on the thread " + Thread.currentThread().getName());
                return ParalelismExecutors.readFile("File2");
            });
            String text1 = future.get();
            String text2 = future2.get();
            System.out.println(System.lineSeparator() + "This operation was performed in Multithrading");
            System.out.println(System.lineSeparator() + "READ TEXT:");
            System.out.println(System.lineSeparator() + text1);
            System.out.println(System.lineSeparator() + text2);
            threadPool.shutdown();
        } catch (Exception e) {
            System.out.println("An error occurred in the execution of the threads and the process needed to be stopped");
        }
    }

    public static void readFilesNotUsingMultipleThreads() {
        try {
            String line = readFile("File");
            String line2 = readFile("File2");
            System.out.println(System.lineSeparator() + "This operation was performed in Singlethreading");
            System.out.println(System.lineSeparator() + "READ TEXT:");
            System.out.println(System.lineSeparator() + line);
            System.out.println(System.lineSeparator() + line2);
        } catch (Exception e) {
            System.out.println("An error occurred in the execution of the threads and the process needed to be stopped");
        }
    }

    public static String readFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(DIRECTORY + filename));
            return br.readLine();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
