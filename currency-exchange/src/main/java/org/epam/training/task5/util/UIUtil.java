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
            if (optionValue.matches("//d+")) {
                value = Integer.parseInt(optionValue);
            }
            switch (value) {
                case 1:
                    openAccount(scanner);
                    break;
                case 2:
                    exchangeCurrency();
                    break;
                case 3:
                    addClient(scanner);
                    break;
                case 4:
                    searchAccount(scanner);
                    break;
                case 5:
                    System.out.println("Bank app terminated");
                    ui = false;
                    break;
                default:
                    System.out.println("Enter the digit number for your operation");
            }
        }
    }

    private static void searchAccount(Scanner scanner) {

    }

    private static void addClient(Scanner scanner) {

    }

    private static void exchangeCurrency() {

    }

    private static void openAccount(Scanner scanner) {

    }

    private static void displayUi() {
        System.out.println("1 - Open new account");
        System.out.println("2 - Exchange currency");
        System.out.println("3 - Add new client");
        System.out.println("4 - Search account");
        System.out.println("5 - Exit");
    }
}
