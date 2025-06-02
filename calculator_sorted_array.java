import java.util.Scanner;
import java.util.Arrays; // Import the Arrays class

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Data Type:");
        System.out.println("1. int\n2. float\n3. double\n4. long");
        System.out.print("Enter your choice: ");
        int dataType = sc.nextInt();

        System.out.println("Calculator Menu:");
        System.out.println("1. +\n2. -\n3. *\n4. /");
        System.out.print("Enter operator choice: ");
        int operator = sc.nextInt();

        System.out.print("How many numbers do you want to calculate? ");
        int count = sc.nextInt();

        String[] inputs = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            inputs[i] = sc.next();
        }

        System.out.println("Numbers entered: " + Arrays.toString(inputs));

        // --- Sorting the arrays before calculation ---
        switch (dataType) {
            case 1:
                int[] ints = new int[count];
                for (int i = 0; i < count; i++) ints[i] = Integer.parseInt(inputs[i]);
                Arrays.sort(ints); // Sort the int array
                System.out.println("Sorted numbers (int): " + Arrays.toString(ints));
                calculate(ints, operator);
                break;
            case 2:
                float[] floats = new float[count];
                for (int i = 0; i < count; i++) floats[i] = Float.parseFloat(inputs[i]);
                Arrays.sort(floats); // Sort the float array
                System.out.println("Sorted numbers (float): " + Arrays.toString(floats));
                calculate(floats, operator);
                break;
            case 3:
                double[] doubles = new double[count];
                for (int i = 0; i < count; i++) doubles[i] = Double.parseDouble(inputs[i]);
                Arrays.sort(doubles); // Sort the double array
                System.out.println("Sorted numbers (double): " + Arrays.toString(doubles));
                calculate(doubles, operator);
                break;
            case 4:
                long[] longs = new long[count];
                for (int i = 0; i < count; i++) longs[i] = Long.parseLong(inputs[i]);
                Arrays.sort(longs); // Sort the long array
                System.out.println("Sorted numbers (long): " + Arrays.toString(longs));
                calculate(longs, operator);
                break;
            default:
                System.out.println("Invalid data type selection.");
        }
        sc.close();
    }

    // Overloaded methods for arrays of different types
    static void calculate(int[] nums, int op) {
        // Calculation logic remains the same
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            switch (op) {
                case 1: result += nums[i]; break;
                case 2: result -= nums[i]; break;
                case 3: result *= nums[i]; break;
                case 4:
                    if (nums[i] != 0) result /= nums[i];
                    else { System.out.println("Division by zero error!"); return; }
                    break;
                default: System.out.println("Invalid operator"); return;
            }
        }
        System.out.println("Result: " + result);
    }

    static void calculate(float[] nums, int op) {
        float result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            switch (op) {
                case 1: result += nums[i]; break;
                case 2: result -= nums[i]; break;
                case 3: result *= nums[i]; break;
                case 4:
                    if (nums[i] != 0) result /= nums[i];
                    else { System.out.println("Division by zero error!"); return; }
                    break;
                default: System.out.println("Invalid operator"); return;
            }
        }
        System.out.println("Result: " + result);
    }

    static void calculate(double[] nums, int op) {
        double result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            switch (op) {
                case 1: result += nums[i]; break;
                case 2: result -= nums[i]; break;
                case 3: result *= nums[i]; break;
                case 4:
                    if (nums[i] != 0) result /= nums[i];
                    else { System.out.println("Division by zero error!"); return; }
                    break;
                default: System.out.println("Invalid operator"); return;
            }
        }
        System.out.println("Result: " + result);
    }

    static void calculate(long[] nums, int op) {
        long result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            switch (op) {
                case 1: result += nums[i]; break;
                case 2: result -= nums[i]; break;
                case 3: result *= nums[i]; break;
                case 4:
                    if (nums[i] != 0) result /= nums[i];
                    else { System.out.println("Division by zero error!"); return; }
                    break;
                default: System.out.println("Invalid operator"); return;
            }
        }
        System.out.println("Result: " + result);
    }
}