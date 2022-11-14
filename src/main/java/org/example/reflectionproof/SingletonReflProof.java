package org.example.reflectionproof;

public class SingletonReflProof {
    private static SingletonReflProof instance;

    private SingletonReflProof() {
        if (instance != null)
            throw new RuntimeException("Use getInstance method to generate instance");
    }

    public static SingletonReflProof getInstance() {
        if (instance == null)
            instance = new SingletonReflProof();
        return instance;
    }

}
