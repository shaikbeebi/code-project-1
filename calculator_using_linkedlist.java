import java.util.Scanner;
import java.util.LinkedList; // Import LinkedList
import java.util.InputMismatchException; 
class InvalidOperatorException extends Exception {
    public InvalidOperatorException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Double> operandList = new LinkedList<>(); 
        double result = 0;
        System.out.println(" 1. Add (+)\n 2. Subtract (-)\n 3. Multiply (*)\n 4. Divide (/)");
        try {
            System.out.print("Enter your choice (1-4): ");
            int operator = sc.nextInt();
            System.out.print("Enter the first number: ");
            double n1 = sc.nextDouble();
            System.out.print("Enter index to insert first number (0 to " + operandList.size() + "): ");
            int insertIndex1 = sc.nextInt();
            // Validate insertion index
            if (insertIndex1 < 0 || insertIndex1 > operandList.size()) {
                throw new IndexOutOfBoundsException("Invalid index for first number insertion: " + insertIndex1);
            }
            operandList.add(insertIndex1, n1);
            System.out.println("Inserted " + n1 + " at index " + insertIndex1 + ". Current list: " + operandList);

            System.out.print("Enter the second number: ");
            double n2 = sc.nextDouble();
            System.out.print("Enter index to insert second number (0 to " + operandList.size() + "): ");
            int insertIndex2 = sc.nextInt();
            // Validate insertion index
            if (insertIndex2 < 0 || insertIndex2 > operandList.size()) {
                throw new IndexOutOfBoundsException("Invalid index for second number insertion: " + insertIndex2);
            }
            operandList.add(insertIndex2, n2);
            System.out.println("Inserted " + n2 + " at index " + insertIndex2 + ". Current list: " + operandList);
            if (operandList.size() < 2) {
                throw new IllegalArgumentException("Error: Less than two operands available for calculation after insertions.");
            }
            double op1 = operandList.get(0); // Always take the first element
            double op2 = operandList.get(1); // Always take the second element
            System.out.println("Retrieved op1 (" + op1 + ") from index 0 and op2 (" + op2 + ") from index 1 for calculation.");

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
            System.out.println("The result is: " + result);
            System.out.println("Current list before deletions: " + operandList);
            if (!operandList.isEmpty()) {
                System.out.print("Enter index to remove the first operand (0 to " + (operandList.size() - 1) + "): ");
                int deleteIndex1 = sc.nextInt();
                // Validate deletion index
                if (deleteIndex1 < 0 || deleteIndex1 >= operandList.size()) {
                    throw new IndexOutOfBoundsException("Invalid index for first operand deletion: " + deleteIndex1);
                }
                double removedOp1 = operandList.remove(deleteIndex1);
                System.out.println("Removed " + removedOp1 + " from index " + deleteIndex1 + ". Current list: " + operandList);
            } else {
                System.out.println("Operand list is empty, cannot remove any more elements.");
            }
            if (!operandList.isEmpty()) {
                System.out.print("Enter index to remove the second operand (0 to " + (operandList.size() - 1) + "): ");
                int deleteIndex2 = sc.nextInt();
                // Validate deletion index
                if (deleteIndex2 < 0 || deleteIndex2 >= operandList.size()) {
                    throw new IndexOutOfBoundsException("Invalid index for second operand deletion: " + deleteIndex2);
                }
                double removedOp2 = operandList.remove(deleteIndex2);
                System.out.println("Removed " + removedOp2 + " from index " + deleteIndex2 + ". Current list: " + operandList);
            } else {
                System.out.println("Operand list is now empty, no more elements to remove.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input format. Please enter numbers for operands/indices and a valid choice for the operator.");
            sc.nextLine();
        } catch (ArithmeticException e) {
            System.err.println("Calculation Error: " + e.getMessage());
        } catch (InvalidOperatorException e) {
            System.err.println("Operator Error: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            // Catches invalid indices for add(index, element) or remove(index)
            System.err.println("List Index Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Input Logic Error: " + e.getMessage()); // For our custom 'not enough operands' check
        } catch (Exception e) { // Catch any other unexpected exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Calculator session ended.");
        }
    }
}