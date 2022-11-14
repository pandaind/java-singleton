package org.example.enumsingleton;

public enum SingletonEnum {
    INSTANCE;
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // It is threadsafe, serialization safe by default
}
