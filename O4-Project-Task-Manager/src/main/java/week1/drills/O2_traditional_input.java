package main.java.week1.drills;

import java.util.Scanner;

class O2_traditional_input {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.println("Hello, %s %s! Welcome to Java".formatted(firstName, lastName));

    }
}
