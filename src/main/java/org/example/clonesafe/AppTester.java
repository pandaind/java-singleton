package org.example.clonesafe;

import org.example.lazy.SingletonLazy;

public class AppTester {
    public static void main(String[] args) throws CloneNotSupportedException {
        SingletonLazy instance1 = SingletonLazy.getInstance();
        SingletonLazy instance2 = (SingletonLazy) instance1.clone();
        System.out.println("instance1 hashCode:- " + instance1.hashCode());
        System.out.println("instance2 hashCode:- " + instance2.hashCode());
        // Different hashcode breaks singleton

        SingletonCloneSafe instance3 = SingletonCloneSafe.getInstance();
        SingletonCloneSafe instance4 = (SingletonCloneSafe) instance1.clone();
        // Don't Allow Cloning
    }
}
