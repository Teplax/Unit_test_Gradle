package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();

        do {
            System.out.println("Введите мин. длину пароля:");
            try {
                int length = Integer.parseInt(scanner.nextLine());
                checker.setMinLength(length);
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (checker.getMinLength() <= 0);

        do {
            System.out.println("Введите макс. допустимое количество повторений символа подряд:");
            try {
                int repeat = Integer.parseInt(scanner.nextLine());
                checker.setMaxRepeats(repeat);
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (checker.getMaxRepeats() <= 0);

        try {
            while (true) {
                System.out.println("Введите пароль или end: ");
                String inputString = scanner.nextLine();
                if (inputString.equals("end")) {
                    break;
                } else if (checker.verify(inputString)) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Программа завершена");
    }
}