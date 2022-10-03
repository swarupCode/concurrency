package com.multithreading;

public class WaitNotifyDemo extends Thread{

    int total = 0;
    @Override
    public void run() {
        synchronized (this) {
            for (int i=0; i<10; i++) {
                total += 100;
            }
            notify();
        }
    }
}

class Main2 {
    public static void main(String[] args) throws InterruptedException {
        WaitNotifyDemo t = new WaitNotifyDemo();
        t.start();
        synchronized (t) {
            t.wait();
            System.out.println("Total amount : "+t.total);
        }

    }
}
