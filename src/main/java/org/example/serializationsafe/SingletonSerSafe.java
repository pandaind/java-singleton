package org.example.serializationsafe;

import java.io.Serializable;

public class SingletonSerSafe implements Serializable {
    private static volatile SingletonSerSafe instance;

    private SingletonSerSafe() {
        if (instance != null)
            throw new RuntimeException("Use getInstance method to generate instance");
    }

    public static SingletonSerSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonSerSafe.class) {
                if (instance == null)
                    instance = new SingletonSerSafe();
            }
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }
}
