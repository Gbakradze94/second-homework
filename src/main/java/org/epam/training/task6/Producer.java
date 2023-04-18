package org.epam.training.task6;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private List<Integer> list;

    public Producer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            Integer integer = new Random().nextInt(100);
            list.add(integer);
            list.notify();
            System.out.println("Producer addes the integer: " + integer);
        }
    }
}
