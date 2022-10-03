package com.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    Queue<Integer> queue = new LinkedList<>();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (!queue.isEmpty())
                    wait();

                System.out.println("Produced Data: "+value);
                queue.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while(queue.isEmpty())
                    wait();

                int data = queue.remove();
                System.out.println("Consumed Data is : "+data);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}

class Utility {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc  = new ProducerConsumer();
        Thread producer1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer1 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer1.start();
        consumer1.start();

        producer1.join();
        consumer1.join();
    }
}

class MyBlockingQueue<T> {
    private Queue<T> queue;
    private int capacity = 16;

    public MyBlockingQueue(T data, int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void put(T data) {

    }

}
