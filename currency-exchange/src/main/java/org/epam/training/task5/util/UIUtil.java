package org.epam.training.task5.util;


import java.util.Scanner;

public class UIUtil {

    public static void init() {
        boolean ui = true;
        while (ui) {
            displayUi();
            Scanner scanner = new Scanner(System.in);
            int value = 0;
            String optionValue = scanner.next();

            value = Integer.parseInt(optionValue);

            switch (value) {
                case 1 -> openAccount(scanner);
                case 2 -> exchangeCurrency();
                case 3 -> addClient(scanner);
                case 4 -> searchAccount(scanner);
                case 5 -> {
                    System.out.println("Bank app terminated");
                    ui = false;
                }
                default -> System.out.println("Enter the digit number for your operation");
            }
        }
    }

    private static void searchAccount(Scanner scanner) {
        // TODO
    }

    private static void addClient(Scanner scanner) {
        // TODO
    }

    private static void exchangeCurrency() {

    }

    private static void openAccount(Scanner scanner) {
        // TODO
    }

    private static void displayUi() {
        System.out.println("1 - Open new account");
        System.out.println("2 - Exchange currency");
        System.out.println("3 - Add new client");
        System.out.println("4 - Search account");
        System.out.println("5 - Exit");
    }
}
