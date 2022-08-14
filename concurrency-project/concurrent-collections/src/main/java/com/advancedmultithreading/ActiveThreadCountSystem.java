package com.advancedmultithreading;

public class ActiveThreadCountSystem {
    public static void main(String[] args) {
        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread[] tArr = new Thread[system.activeCount()];
        system.enumerate(tArr);

        for (Thread t : tArr) {
            System.out.println(t.getName() + "...." + t.isDaemon());
        }
    }
}
