package org.epam.training.task6;

import java.util.List;

public class Consumer implements Runnable{
    protected List<Integer> list;

    public Consumer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (Integer integer: list) {
            System.out.println("Consumer consumer integer: " + integer);
        }
    }
}
