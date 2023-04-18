package org.epam.training.task3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyCustomBlockingQueue<E> {
    private final Queue<E> queue;
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition notEmpty = reentrantLock.newCondition();
    private final Condition notFull = reentrantLock.newCondition();

    private int maxElementNumber = 16;

    public MyCustomBlockingQueue(int size) {
        queue = new LinkedList<>();
        this.maxElementNumber = size;
    }

    public void put(E e) throws InterruptedException {
        reentrantLock.lock();
        if (queue.size() >= maxElementNumber) {
            notFull.await();
        }
        queue.add(e);
        notEmpty.signalAll();
        reentrantLock.unlock();
    }

    public E pop() {
        reentrantLock.lock();
        try {
            notEmpty.await();
            E item = queue.remove();
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }
}
