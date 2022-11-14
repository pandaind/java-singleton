package org.example.serializationsafe;

import org.example.lazy.SingletonLazy;

import java.io.*;

public class AppTester {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingletonLazy instance1 = SingletonLazy.getInstance();
        ObjectOutput out = null;

        out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instance1);
        out.close();

        //deserialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SingletonLazy instance2 = (SingletonLazy) in.readObject();
        in.close();

        System.out.println("instance1 hashCode=" + instance1.hashCode());
        System.out.println("instance2 hashCode=" + instance2.hashCode());
        // Both the hascode are different hence breaking singleton

        // After Serialization proof
        SingletonSerSafe instance3 = SingletonSerSafe.getInstance();
        ObjectOutput outSer = null;

        outSer = new ObjectOutputStream(new FileOutputStream("filenamesafe.ser"));
        outSer.writeObject(instance3);
        outSer.close();

        //deserialize from file to object
        ObjectInput inSer = new ObjectInputStream(new FileInputStream("filenamesafe.ser"));
        SingletonSerSafe instance4 = (SingletonSerSafe) inSer.readObject();
        inSer.close();

        System.out.println("instance3 hashCode=" + instance3.hashCode());
        System.out.println("instance4 hashCode=" + instance4.hashCode());
    }
}
