package org.epam.training.task1;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create HashMap<Integer, Integer>. The first thread adds elements into the map,
 * the other go along the given map and sum the values. Threads should work before
 * catching ConcurrentModificationException. Try to fix the problem with
 * ConcurrentHashMap and Collections.synchronizedMap(). What has happened after
 * simple Map implementation exchanging? How it can be fixed in code? Try to write
 * your custom ThreadSafeMap with synchronization and without. Run your samples with
 * different versions of Java (6, 8, and 10, 11) and measure the performance. Provide a
 * simple report to your mentor.
 */
public class DasExperiment {
    Map<Integer, Integer> hashMap = new ConcurrentHashMap<>();

    static AtomicInteger counter = new AtomicInteger(1);

    public void addAndSum() throws InterruptedException {
        Runnable firstThread = () -> {
            while (true) {
                hashMap.put(counter.incrementAndGet(), counter.get());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(counter.get());
            }
        };

        Runnable secondThread = () -> {
            while (true) {
                int sum = 0;
                Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> entry = iterator.next();
                    int key = entry.getKey();
                    int value = entry.getValue();
                    sum += value;
                    if (value > 10) {
                        hashMap.remove(key);
                    }
                }
                System.out.println("Sum: " + sum);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(firstThread);
        executorService.submit(secondThread);

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.exit(0);
    }

    public static void main(String[] args) throws InterruptedException {
        DasExperiment dasExperiment = new DasExperiment();
        dasExperiment.addAndSum();
    }
}
