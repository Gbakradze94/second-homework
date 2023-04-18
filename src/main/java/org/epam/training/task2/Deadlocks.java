package org.epam.training.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Create three threads:
 * •	1st thread is infinitely writing random number to the collection;
 * •	2nd thread is printing sum of the numbers in the collection;
 * •	3rd is printing square root of sum of squares of all numbers in the collection.
 * Make these calculations thread-safe using synchronization block. Fix the possible deadlock.
 */
public class Deadlocks {

    List<Integer> integers = new ArrayList<>();

    void firstThread() {
        integers.add((int) (Math.random() * 100));
    };

    void secondThread() {
        System.out.println(integers.stream()
                .reduce(0, Integer::sum)
        );
    };

    void thirdThread() {
        synchronized (this) {
            double sum = integers.stream()
                    .reduce(0, (a, b) -> a * a + b * b);
            System.out.println(sum);
        }
    };

    public static void main(String[] args) {
        Deadlocks deadlocks = new Deadlocks();

        new Thread(deadlocks::firstThread).start();
        new Thread(deadlocks::secondThread).start();
        new Thread(deadlocks::thirdThread).start();
    }
}
