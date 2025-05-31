import java.util.*;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Mapping operator choices to lambda functions
        Map<Integer, BinaryOperator<Integer>> operations = new HashMap<>();
        operations.put(1, (a, b) -> a + b);
        operations.put(2, (a, b) -> a - b);
        operations.put(3, (a, b) -> a * b);
        operations.put(4, (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        });

        System.out.println("Choose an operation:");
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");

        System.out.print("Enter your choice: ");
        int operator = sc.nextInt();

        System.out.print("Enter the first number: ");
        int n1 = sc.nextInt();

        System.out.print("Enter the second number: ");
        int n2 = sc.nextInt();

        BinaryOperator<Integer> operation = operations.get(operator);
        if (operation != null) {
            try {
                int result = operation.apply(n1, n2);
                System.out.println("The result is: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid operator choice.");
        }
    }
}
