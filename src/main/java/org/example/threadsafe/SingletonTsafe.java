package org.example.threadsafe;

public class SingletonTsafe {
    private static volatile SingletonTsafe instance;

    private SingletonTsafe() {
        if (instance != null)
            throw new RuntimeException("Use getInstance method to generate instance");
    }

    //1. t2 will wait until t1 creates the instance which is slow
    /*public synchronized static SingletonTsafe getInstance() {
        if (instance == null) {
            instance = new SingletonTsafe();
        }
        return instance;
    }*/

    //2. Double check locking
    // Without volatile modifier, it’s possible for another thread in Java to see
    // half initialized state of instance variable
    // but with volatile variable guaranteeing happens-before relationship,
    // all write will happen on volatile instance before any read of instance variable
    public static SingletonTsafe getInstance() {
        if (instance == null) {
            synchronized (SingletonTsafe.class){
                if (instance == null)
                    instance = new SingletonTsafe();
            }
        }
        return instance;
    }
}
