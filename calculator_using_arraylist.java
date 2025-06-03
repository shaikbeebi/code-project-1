import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.InputMismatchException;
class InvalidOperatorException extends Exception {
    public InvalidOperatorException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> operandList = new ArrayList<>(); 
        double result = 0;
        System.out.println("Numbers will be stored in ascending order.");
        try{
            boolean addingNumbers = true;
            while (addingNumbers) {
                System.out.print("\nEnter a number(or 'done' to finish): ");
                String input = sc.next();
                if (input.equalsIgnoreCase("done")) {
                    addingNumbers = false;
                } else {
                    try {
                        double num = Double.parseDouble(input);
                        int insertIndex = 0;
                        while (insertIndex < operandList.size() && operandList.get(insertIndex) < num) {
                            insertIndex++;
                        }
                        operandList.add(insertIndex, num);
                        System.out.println("Inserted " + num + " at index " + insertIndex + ". Current sorted list: " + operandList);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input.");
                    }
                }
            }
            if (operandList.size() < 2) {
                throw new IllegalArgumentException("You need at least two numbers in the list to perform a calculation.");
            }
            System.out.println("\nYour current sorted list of numbers: " + operandList);
            System.out.print("Enter the index of the first number for calculation (0 to " + (operandList.size() - 1) + "): ");
            int op1Index = sc.nextInt();
            if (op1Index < 0 || op1Index >= operandList.size()) {
                throw new IndexOutOfBoundsException("Invalid index for first operand: " + op1Index);
            }
            double op1 = operandList.get(op1Index);

            System.out.print("Enter the index of the second number for calculation (0 to " + (operandList.size() - 1) + "): ");
            int op2Index = sc.nextInt();
            if (op2Index < 0 || op2Index >= operandList.size()) {
                throw new IndexOutOfBoundsException("Invalid index for second operand: " + op2Index);
            }
            double op2 = operandList.get(op2Index);
            System.out.println("\nCalculating with " + op1 + " (at index " + op1Index + ") and " + op2 + " (at index " + op2Index + ").");
            System.out.println(" 1. Add (+)\n 2. Subtract (-)\n 3. Multiply (*)\n 4. Divide (/)");
            System.out.print("Enter your choice (1-4) for operation: ");
            int operator = sc.nextInt();
            switch (operator) {
                case 1:
                    result = op1 + op2;
                    break;
                case 2:
                    result = op1 - op2;
                    break;
                case 3:
                    result = op1 * op2;
                    break;
                case 4:
                    if (op2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = op1 / op2;
                    break;
                default:
                    throw new InvalidOperatorException("Invalid choice: " + operator + ". Please enter a number between 1 and 4.");
            }
            System.out.println("\nThe result is: " + result);
            System.out.println("\nCurrent list before deletions: " + operandList);
            while (!operandList.isEmpty()) {
                System.out.print("Enter index to remove an element (0 to " + (operandList.size() - 1) + ", or -1 to stop deleting): ");
                int deleteIndex = sc.nextInt();
                if (deleteIndex == -1) {
                    break; // User wants to stop deleting
                }
                if (deleteIndex < 0 || deleteIndex >= operandList.size()) {
                    System.err.println("Invalid index. Please enter a valid index or -1 to stop.");
                } else {
                    double removedElement = operandList.remove(deleteIndex);
                    System.out.println("Removed " + removedElement + " from index " + deleteIndex + ". Current list: " + operandList);
                }
            }
            if (operandList.isEmpty()) {
                System.out.println("Operand list is now empty.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input format. ");
            sc.nextLine();
        } catch (ArithmeticException e) {
            System.err.println("Calculation Error: " + e.getMessage());
        } catch (InvalidOperatorException e) {
            System.err.println("Operator Error: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("List Index Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Input Logic Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Calculator session ended.");
        }
    }
}