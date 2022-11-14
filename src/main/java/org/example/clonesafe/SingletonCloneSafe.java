package org.example.clonesafe;

import java.io.Serializable;

public class SingletonCloneSafe implements Serializable, Cloneable {
    private static volatile SingletonCloneSafe instance;

    private SingletonCloneSafe() {
        if (instance != null)
            throw new RuntimeException("Use getInstance method to generate instance");
    }

    public static SingletonCloneSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonCloneSafe.class) {
                if (instance == null)
                    instance = new SingletonCloneSafe();
            }
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
