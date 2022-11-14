package org.example.lazy;

import java.io.Serializable;

public class SingletonLazy implements Serializable, Cloneable {

    private static SingletonLazy instance;

    //private constructor
    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
