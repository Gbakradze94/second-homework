package org.epam.training.task3;

import org.epam.training.task4.Item;

public class Main {
    public static void main(String[] args) {
        MyCustomBlockingQueue<Item> blockingQueue = new MyCustomBlockingQueue<>(10);

        final Runnable producer = () -> {
            while (true) {
                try {
                    blockingQueue.put(new Item(generateRandomNumber(1, 1000)));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        final Runnable consumer = () -> {
            while (true) {
                Item item = blockingQueue.pop();
                System.out.println("Item popped from the queue: " + item);
            }
        };
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    public static int generateRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
