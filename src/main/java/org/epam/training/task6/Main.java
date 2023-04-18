package org.epam.training.task6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Producer(list));
        Thread t2 = new Thread(new Consumer(list));
        t1.start();
        t2.start();
    }
}
