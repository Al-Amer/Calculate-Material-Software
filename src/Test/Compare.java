package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Compare {

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);

        int inputNumber;
        int smallestNumber = Integer.MAX_VALUE;
        int largestNumber = Integer.MIN_VALUE;

        while (true) {
            System.out.print("Enter an integer: ");
            inputNumber = keyboard.nextInt();

            if (inputNumber == -1) {
                break;
            }


            smallestNumber = Math.min(smallestNumber, inputNumber);
            largestNumber = Math.max(largestNumber, inputNumber);
        }

        PrintWriter outputFile = new PrintWriter("numbers.txt");
        outputFile.println(inputNumber);
        System.out.println("You have added the numbers to the file, 'numbers.txt'.");

        outputFile.close();

        System.out.println("The smallest number is: " + smallestNumber);
        System.out.println("The largest number is: " + largestNumber);

        keyboard.close();


    }


}
