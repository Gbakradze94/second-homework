package org.epam.training.task4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingObjectPool {

    private final BlockingQueue<Item> blockingPool;
    /**
     * Creates filled pool of passed size
     * @param max size of the pool
     */
    public BlockingObjectPool(int max) {
        blockingPool = new ArrayBlockingQueue<>(max);
        for (int i = 0; i < max; i++) {
            blockingPool.add(new Item(i));
        }
    }

    /**
     * Gets item from pool or blocks thread if pool is empty
     * @return item from the pool
     */
    public synchronized Item get() {
        if (blockingPool.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("Error. Can't block the thread while pool is empty.");
            }
        }
        Item item = blockingPool.remove();
        notifyAll();
        return item;
    }

    /**
     * Puts item to pool
     * @param item to put back
     */
    public synchronized void put(Item item) {
        blockingPool.add(item);
        notifyAll();
    }
}
