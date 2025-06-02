import java.util.Scanner;

class Main {
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

        System.out.print("Enter first number: ");
        String input1 = sc.next();
        System.out.print("Enter second number: ");
        String input2 = sc.next();

        switch (dataType) {
            case 1: // int
                int i1 = Integer.parseInt(input1);
                int i2 = Integer.parseInt(input2);
                calculate(i1, i2, operator);
                break;
            case 2: // float
                float f1 = Float.parseFloat(input1);
                float f2 = Float.parseFloat(input2);
                calculate(f1, f2, operator);
                break;
            case 3: // double
                double d1 = Double.parseDouble(input1);
                double d2 = Double.parseDouble(input2);
                calculate(d1, d2, operator);
                break;
            case 4: // long
                long l1 = Long.parseLong(input1);
                long l2 = Long.parseLong(input2);
                calculate(l1, l2, operator);
                break;
            default:
                System.out.println("Invalid data type selection.");
        }
    }

    // Overloaded methods for calculation
    static void calculate(int a, int b, int op) {
        switch (op) {
            case 1: System.out.println("Result: " + (a + b)); break;
            case 2: System.out.println("Result: " + (a - b)); break;
            case 3: System.out.println("Result: " + (a * b)); break;
            case 4:
                if (b != 0) System.out.println("Result: " + (a / b));
                else System.out.println("Division by zero error!");
                break;
            default: System.out.println("Invalid operator");
        }
    }

    static void calculate(float a, float b, int op) {
        switch (op) {
            case 1: System.out.println("Result: " + (a + b)); break;
            case 2: System.out.println("Result: " + (a - b)); break;
            case 3: System.out.println("Result: " + (a * b)); break;
            case 4:
                if (b != 0.0f) System.out.println("Result: " + (a / b));
                else System.out.println("Division by zero error!");
                break;
            default: System.out.println("Invalid operator");
        }
    }

    static void calculate(double a, double b, int op) {
        switch (op) {
            case 1: System.out.println("Result: " + (a + b)); break;
            case 2: System.out.println("Result: " + (a - b)); break;
            case 3: System.out.println("Result: " + (a * b)); break;
            case 4:
                if (b != 0.0) System.out.println("Result: " + (a / b));
                else System.out.println("Division by zero error!");
                break;
            default: System.out.println("Invalid operator");
        }
    }

    static void calculate(long a, long b, int op) {
        switch (op) {
            case 1: System.out.println("Result: " + (a + b)); break;
            case 2: System.out.println("Result: " + (a - b)); break;
            case 3: System.out.println("Result: " + (a * b)); break;
            case 4:
                if (b != 0L) System.out.println("Result: " + (a / b));
                else System.out.println("Division by zero error!");
                break;
            default: System.out.println("Invalid operator");
        }
    }
}
