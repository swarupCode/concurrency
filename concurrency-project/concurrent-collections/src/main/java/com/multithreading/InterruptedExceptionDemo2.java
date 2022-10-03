package com.multithreading;

public class InterruptedExceptionDemo2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("I am Lazy Thread: "+ i);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("I got interrupted");
        }
    }
}

class ThreadSleepDemo2 {
    public static void main(String[] args) {
        InterruptedExceptionDemo2 thread = new InterruptedExceptionDemo2();
        thread.start();
        thread.interrupt();
        System.out.println("END of MAIN Thread: " + Thread.currentThread());
    }
}

// Output:
/*
* I am Lazy Thread: 0
I am Lazy Thread: 1
....
I am Lazy Thread: 999
I got interrupted
* */