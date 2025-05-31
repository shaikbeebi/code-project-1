import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1, num2 = 0;
        char operator;
        double result = 0;
        boolean validInput = false;

        System.out.print("Enter first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        // Repeat input until valid
        while (!validInput) {
            System.out.print("Enter second number: ");
            num2 = scanner.nextDouble();

            try {
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        validInput = true;
                        break;
                    case '-':
                        result = num1 - num2;
                        validInput = true;
                        break;
                    case '*':
                        result = num1 * num2;
                        validInput = true;
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        result = num1 / num2;
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid operator.");
                        return;
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}
