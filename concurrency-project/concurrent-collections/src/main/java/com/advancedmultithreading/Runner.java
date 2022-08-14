package com.advancedmultithreading;

public class Runner {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
        testThreadGroup();
        testMaxPriority();
    }

    public static void testThreadGroup() {
        ThreadGroup threadGroup = new ThreadGroup("First ThreadGroup");
        System.out.println(threadGroup.getParent().getName());

        ThreadGroup childThreadGroup = new ThreadGroup(threadGroup, "Second ThreadGroup");
        System.out.println(childThreadGroup.getParent().getName());
    }

    public static void testMaxPriority() {
        System.out.println("======================================");
        System.out.println("Test Priority of ThreadGroup");
        System.out.println("======================================");
        ThreadGroup g1 = new ThreadGroup("tg");
        Thread t1 = new Thread(g1, "Thread1");
        Thread t2 = new Thread(g1, "Thread2");
        g1.setMaxPriority(3);
        Thread t3 = new Thread(g1, "Thread3");
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());

    }
}
/*
OUTPUT --
main
system
*/