package com.mcnichol.math;

import javax.swing.*;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Greetings Earthling");
        JOptionPane.showInputDialog(null, "Enter a number");
        String task = "Make a Multiplication Table";
        String userInput = "";
        userInput = JOptionPane.showInputDialog(task + "\nEnter your starting number: ");
        int rangeStart = Integer.parseInt(userInput);

        userInput = JOptionPane.showInputDialog(task + "\nEnter your ending number: ");
        int rangeEnd = Integer.parseInt(userInput);

        TableService tableService = new TableService();

        Table table = tableService.initializeTable(rangeStart, rangeEnd);

        System.out.println(table.toString());


        Scanner scanner = new Scanner(System.in);
        int numCorrect = 0;
        for (int i = 0; i < 30; i++) {
            System.out.print("Question " + i + ": ");
            int operand1 = (int) Math.floor(Math.random() * rangeEnd);
            int operand2 = (int) Math.floor(Math.random() * rangeEnd);
            System.out.print(String.valueOf(operand1) + " * " + String.valueOf(operand2) + " = ");
            int result = scanner.nextInt();

            if (operand1 * operand2 == result) {
                numCorrect++;
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }
        System.out.println("Total Correct Answers: " + String.valueOf(numCorrect));

        System.exit(0);
    }
}
