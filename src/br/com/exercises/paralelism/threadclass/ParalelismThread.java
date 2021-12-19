package br.com.exercises.paralelism.threadclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class ParalelismThread {
    static AtomicInteger i = new AtomicInteger(0);
    final static String DIRECTORY = "./src//br/com/exercises/paralelism/threadclass/files/";

    public static void main(String[] args) {
        /* switch between the methods by removing the comment from one and commenting on the other */

        createFilesUsingMultipleThreads();
        //createFilesNotUsingMultipleThreads();
    }

    public static void createFilesUsingMultipleThreads() {
        long startTime = System.currentTimeMillis();
        try {
            Thread thread = new Thread(ParalelismThread::createFile);
            Thread thread2 = new Thread(ParalelismThread::createFile);
            Thread thread3 = new Thread(ParalelismThread::createFile);
            thread.start();
            thread2.start();
            thread3.start();
        } catch (Exception e) {
            System.out.println("An error occurred in the execution of the threads and the process needed to be stopped");
        }
        System.out.println("Using multithreading the execution took a while " + (System.currentTimeMillis() - startTime) + " milliseconds");
    }

    public static void createFilesNotUsingMultipleThreads() {
        long startTime = System.currentTimeMillis();
        try {
            for (int it = 0; it < 3; it++) {
                String filename = "File - " + it;
                PrintWriter writer = new PrintWriter(DIRECTORY + filename, "UTF-8");
                writer.println("Hi!! I was created by running the system");
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("There was an error creating the files.");
        }
        System.out.println("Using singlethreading the execution took a while " + (System.currentTimeMillis() - startTime) + " milliseconds");
    }

    public static void createFile() {
        try {
            String threadName = Thread.currentThread().getName();
            PrintWriter writer = new PrintWriter(DIRECTORY + threadName, "UTF-8");
            writer.println("thread " + threadName + " created me");
            System.out.println("thread " + threadName + " created the File in " + i.incrementAndGet());
            writer.close();
        } catch (IOException e) {
            System.out.println("There was an error creating the files.");
        }
    }
}
