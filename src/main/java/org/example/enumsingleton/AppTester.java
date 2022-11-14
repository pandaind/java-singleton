package org.example.enumsingleton;

public class AppTester {
    public static void main(String[] args) {
        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        SingletonEnum instance2 = SingletonEnum.INSTANCE;
        System.out.println("instance1 hashCode:- " + instance1.hashCode());
        System.out.println("instance2 hashCode:- " + instance2.hashCode());

        instance1.setValue(10);
        System.out.println("instance 1 value "+ instance1.getValue());
        System.out.println("instance 2 value "+ instance2.getValue());
    }
}
