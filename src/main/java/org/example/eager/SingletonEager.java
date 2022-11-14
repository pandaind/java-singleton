package org.example.eager;

public class SingletonEager {

    private static final SingletonEager instance = new SingletonEager();

    //private constructor
    private SingletonEager() {}

    public static SingletonEager getInstance(){
        return instance;
    }

    // Drawback is it creates the instance even it is not needed by the application
}
