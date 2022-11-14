package org.example.reflectionproof;

import org.example.lazy.SingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AppTester {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingletonLazy instance = SingletonLazy.getInstance();

        // Create a instance using reflection
        SingletonLazy instance2 = null;
        Class<SingletonLazy> clazz = SingletonLazy.class;
        Constructor<SingletonLazy> cons = clazz.getDeclaredConstructor();
        cons.setAccessible(true);
        instance2 = cons.newInstance();

        System.out.println("Instance 1 " + instance.hashCode());
        System.out.println("Instance 2 " + instance2.hashCode());


        // after reflection proof

        SingletonReflProof instance3 = SingletonReflProof.getInstance();

        SingletonReflProof instance4 = null;
        Class<SingletonReflProof> clazzRP = SingletonReflProof.class;
        Constructor<SingletonReflProof> consRP = clazzRP.getDeclaredConstructor();
        consRP.setAccessible(true);
        instance4 = consRP.newInstance();
        // will throw error is you try to instantiate
    }
}
