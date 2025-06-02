import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("This calculator supports +, -, *, / with operator precedence.");
        while (true) {
            System.out.print("\nEnter expression (or 'exit' to quit): ");
            String expression = sc.nextLine();
            if (expression.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }
            try {
                // Tokenize the expression
                List<String> tokens = tokenizeExpression(expression);
                System.out.println("Tokens: " + tokens); 
                List<String> postfix = infixToPostfix(tokens);
                System.out.println("Postfix: " + postfix); 
                double result = evaluatePostfix(postfix);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter a valid arithmetic expression.");
            }
        }
        sc.close();
    }
    private static int getPrecedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0; // For parentheses and other non-operators
        };
    }
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    private static List<String> tokenizeExpression(String expression) {
        List<String> tokens = new ArrayList<>();
        // Regular expression to match numbers (integers or doubles), operators, and parentheses
        Pattern pattern = Pattern.compile("(\\d+\\.?\\d*)|([+\\-*/()])");
        Matcher matcher = pattern.matcher(expression.replaceAll("\\s+", ""));
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        if (tokens.isEmpty() && !expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid characters in expression.");
        }
        return tokens;
    }
    private static List<String> infixToPostfix(List<String> tokens) {
        List<String> postfix = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (token.matches("\\d+\\.?\\d*")) { // If it's a number
                postfix.add(token);
            } else if (isOperator(token)) { // If it's an operator
                while (!operatorStack.isEmpty() && isOperator(operatorStack.peek()) &&
                       getPrecedence(token) <= getPrecedence(operatorStack.peek())) {
                    postfix.add(operatorStack.pop());
                }
                operatorStack.push(token);
            } else if (token.equals("(")) { // If it's an opening parenthesis
                operatorStack.push(token);
            } else if (token.equals(")")) { // If it's a closing parenthesis
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    postfix.add(operatorStack.pop());
                }
                if (operatorStack.isEmpty()) {
                    throw new IllegalArgumentException("Mismatched parentheses: No opening parenthesis found.");
                }
                operatorStack.pop(); // Pop the opening parenthesis
            } else {
                throw new IllegalArgumentException("Unknown token: " + token);
            }
        }

        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek().equals("(")) {
                throw new IllegalArgumentException("Mismatched parentheses: Unclosed opening parenthesis.");
            }
            postfix.add(operatorStack.pop());
        }
        return postfix;
    }
    private static double evaluatePostfix(List<String> postfix) {
        Stack<Double> operandStack = new Stack<>();

        for (String token : postfix) {
            if (token.matches("\\d+\\.?\\d*")) { // If it's a number
                operandStack.push(Double.parseDouble(token));
            } else if (isOperator(token)) { // If it's an operator
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: Not enough operands for operator " + token);
                }
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result;
                switch (token) {
                    case "+": result = operand1 + operand2; break;
                    case "-": result = operand1 - operand2; break;
                    case "*": result = operand1 * operand2; break;
                    case "/":
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero!");
                        }
                        result = operand1 / operand2;
                        break;
                    default: throw new IllegalArgumentException("Unknown operator: " + token);
                }
                operandStack.push(result);
            }
        }
        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: Too many operands or operators left.");
        }
        return operandStack.pop();
    }
}