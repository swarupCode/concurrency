package com.multithreading;

public class InterruptedExceptionDemo1 extends Thread{

    @Override
    public void run() {
        try {
            for (int i=0; i<10; i++) {
                System.out.println("I am Lazy Thread!!!");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("I got interrupted");
        }
    }
}

class ThreadSleepDemo {
    public static void main(String[] args) {
        InterruptedExceptionDemo1 thread = new InterruptedExceptionDemo1();
        thread.start();
        thread.interrupt();
        System.out.println("END of MAIN Thread: "+Thread.currentThread());
    }
}
