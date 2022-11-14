package org.example.threadsafe;

import org.example.lazy.SingletonLazy;

public class AppTester {
    public static void main(String[] args) {
        // Thread 1
        Thread t1 = new Thread(() -> {
            SingletonLazy instance = SingletonLazy.getInstance();
            System.out.println("Thread1's singleton "+ instance.hashCode());
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            SingletonLazy instance = SingletonLazy.getInstance();
            System.out.println("Thread2's singleton "+ instance.hashCode());
        });

        t1.start();
        t2.start();

        // Both have different hashcode which breaks our singleton
        // to solve we can use
        // 1. Make getInstance() synchronise
        // 2. Double check locking method
        // 3. use Volatile keyword

        // Thread 3
        Thread t3 = new Thread(() -> {
            SingletonTsafe instance = SingletonTsafe.getInstance();
            System.out.println("Thread3's singleton "+ instance.hashCode());
        });

        // Thread 4
        Thread t4 = new Thread(() -> {
            SingletonTsafe instance = SingletonTsafe.getInstance();
            System.out.println("Thread4's singleton "+ instance.hashCode());
        });

        t3.start();
        t4.start();
    }
}
