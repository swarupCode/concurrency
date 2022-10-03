package com.multithreading;

public class JoinThreadDemo extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("I got interrupted");
            }
        }
    }
}
class Main {
    public static void main(String[] args) throws InterruptedException {
        JoinThreadDemo thread = new JoinThreadDemo();
        thread.start();
        thread.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}
