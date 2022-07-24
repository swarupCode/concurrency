package com.concurrenthashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Program01 extends Thread{

//    HashMap as it is not threadSafe will give us "Exception in thread "main" java.util.ConcurrentModificationException"
//    static HashMap<Integer, String> m = new HashMap<>();

//    ConcurrentHashMap is Thread safe; hence no such Exception
    static ConcurrentHashMap<Integer, String> m = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        m.put(101, "A");
        m.put(102, "B");

        Program01 myThread = new Program01();
        myThread.start();

        Set<Integer> set = m.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer i1 = (Integer) iterator.next();
            System.out.println("Main Thread is "+i1+" ... "+ m.get(i1));
            Thread.sleep(3000);
        }
        System.out.println("MAP: "+m);
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Child Thread UPDATING Map...");
        m.put(103, "C");
    }
}

        /*Main Thread is 101 ... A
        Child Thread UPDATING Map...
        Main Thread is 102 ... B
        Main Thread is 103 ... C
        MAP: {101=A, 102=B, 103=C}*/