import java.util.Scanner;

public class PrimeCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        // Check for prime
        if (number <= 1) {
            isPrime = false;
        } else {
            // Only check up to square root of number
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        // Output result
        if (isPrime) {
            System.out.println(number + " is a Prime number.");
        } else {
            System.out.println(number + " is NOT a Prime number.");
        }

        scanner.close();
    }
}
