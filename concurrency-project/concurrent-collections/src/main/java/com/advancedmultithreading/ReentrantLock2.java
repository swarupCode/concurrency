package com.advancedmultithreading;

import java.util.concurrent.locks.ReentrantLock;

class Display {
//    public void wish(String name) { // without synchronized
//    public synchronized void wish(String name) { // with synchronized
    ReentrantLock lock = new ReentrantLock();
    public void wish(String name) { // with Locks

        lock.lock();
        for (int i=0; i<10; i++) {
            System.out.print("Good Morning:");

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
        }
        System.out.println(name);
        }
        lock.unlock();

    }
}

class MyNewThread extends Thread {
    Display d;
    String name;

    public MyNewThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }
    @Override
    public void run() {
        d.wish(name);
    }
}

public class ReentrantLock2 {
    public static void main(String[] args) {

        Display d = new Display();
        MyNewThread t1 = new MyNewThread(d, "Swarup");
        MyNewThread t2 = new MyNewThread(d, "Anusha");
        t1.start();
        t2.start();

    }
}
