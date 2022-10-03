package com.advancedmultithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockRunner {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();

        System.out.println(lock.isLocked()); //true
        System.out.println(lock.isHeldByCurrentThread()); //true
        System.out.println(lock.getQueueLength()); //0

        lock.unlock();

        System.out.println(lock.getHoldCount()); //1
        System.out.println(lock.isLocked()); //true

        lock.unlock();

        System.out.println(lock.isLocked()); //false
        System.out.println(lock.isFair()); //false
    }
}
