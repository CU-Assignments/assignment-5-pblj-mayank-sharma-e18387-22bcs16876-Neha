// Easy Level: Sum of Integers using Autoboxing & Unboxing
// 🎯 Task
// Write a Java program to calculate the sum of a list of integers using Autoboxing and Unboxing. Implement methods to parse strings into their respective wrapper classes using Integer.parseInt().

// 🔹 Steps to Follow
// Create an ArrayList of integers.
// Read a list of numbers from the user as a string.
// Convert the input into Integer objects using autoboxing.
// Compute the sum of the integers using unboxing.
// Display the result.
// 📄 Sample Output
// Enter numbers separated by spaces: 10 20 30 40 50
// Sum of numbers: 150

import java.util.*;

public class SumOfIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("Enter numbers separated by spaces: ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        int sum = 0;
        for (String part : parts) {
            // Autoboxing: converting int to Integer
            Integer num = Integer.parseInt(part);
            numbers.add(num);
        }

        for (Integer number : numbers) {
            // Unboxing: Integer to int
            sum += number;
        }

        System.out.println("Sum of numbers: " + sum);
        scanner.close();
    }
}
