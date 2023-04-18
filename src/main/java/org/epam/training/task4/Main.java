package org.epam.training.task4;

public class Main {
    public static void main(String[] args) {
        BlockingObjectPool pool = new BlockingObjectPool(100);

        final Runnable producer = () -> {
            while (true) {
                Item item = pool.get();
                System.out.println("Item Id: " + item.getId());
                try {
                    Thread.sleep((int)(Math.random() * 1100) + 100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                pool.put(item);
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
    }
}
