package AdvancedOnlineShoppingSystem;

import java.util.Scanner;

public class trial {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int age= -1;
        while (age < 0) {
            System.out.println("Please enter your age: ");
            String input= stdin.nextLine();

            try {
                age = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                age = -1;
            }
        }
        System.out.println("Your age is: " +(age + 10));
    }
}
