package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Postfix {

    static boolean VERBOSE = true;

    static void log(String s) {
        if (VERBOSE) {
            System.out.println(s);
        }
    }

    static HashMap<Character, Integer> operators = new HashMap<Character, Integer>(Map.of(
            '+', 11,
            '-', 11,
            '*', 12,
            '/', 12,
            '^', 13,
            '(', 1,
            ')', 1));


    public static String fromInfix(String infix) throws Exception {

        Stack<Character> stack = new Stack<>();
        ArrayList<Character> postfix = new ArrayList<>();

        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);
            log("");
            log(postfix.toString());
            log(String.valueOf(current));
            if (isOperand(current)) {
                log("Is operand");
                postfix.add(current);
            } else if (isOperator(current)) {
                log("Is operator");
                while (shouldContinue(stack, current)) {
                    log("Adding to postfix form");
                    postfix.add(stack.pop());
                }
                stack.push(current);
            } else if (isLeftParen(current)) {
                stack.push(current);
            } else if (isRightParen(current)) {
                while (!stack.isEmpty() && !isLeftParen(stack.peek())) {
                    postfix.add(stack.pop());
                }
                try {
                    if (!isLeftParen(stack.pop())) {
                        throw new Exception("Expresia avea paranteze gresite");
                    }
                } catch (Exception e) {
                    throw new Exception("Expresia avea paranteze gresite");
                }
            }
        }

         while (!stack.isEmpty() && !isLeftParen(stack.peek())) {
             postfix.add(stack.pop());
         }
         if (!stack.isEmpty()) {
             throw new Exception("Expresia avea paranteze gresite");
         }

        return postfix.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    public static int eval(String postfix) throws Exception {
        String[] entities = postfix.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < entities.length; i++) {
            char current = entities[i].charAt(0);
            if (isOperand(current)) {
                stack.push(Character.getNumericValue(current));
            } else if (isOperator(current)) {
                log("Is operator");
                int op1 = stack.pop();
                int op2 = stack.pop();
                log(String.valueOf(op1));
                log(String.valueOf(op2));
                int result = applyOperand(current, op1, op2);
                stack.push(result);
            }
        }

        int result = stack.pop();

        if (!stack.isEmpty()) {
            throw new Exception("Expresia postfixata este gresita");
        } else {
            return result;
        }
    }

    private static int applyOperand(char operand, int op1, int op2) {
        if (operand == '-') {
            return op2 - op1;
        } else if (operand == '+') {
            return op2 + op1;
        } else if (operand == '/') {
            return op2 / op1;
        } else if (operand == '*') {
            return op2 * op1;
        } else if (operand == '^') {
            return (int) Math.pow(op2, op1);
        }
        return -1;
    }



    private static boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    private static boolean isOperator(char c) {
        return operators.containsKey(c) && !isParen(c);
    }

    private static boolean isParen(char c) {
        return c == '(' || c == ')';
    }

    private static boolean isLeftParen(char c) {
        return c == '(';
    }

    private static boolean isRightParen(char c) {
        return c == ')';
    }

    private static boolean shouldContinue(Stack<Character> stack, char o1) {
        if (stack.isEmpty()) {
            return false;
        }
        char o2 = stack.peek();
        boolean hasOperator = isOperator(o2);
        boolean isNotLeftParen = !isLeftParen(o2);
        boolean prec1 = operators.get(o1) < operators.get(o2);
        boolean prec2 = (operators.get(o1) == operators.get(o2)) && isLeftAsoc(o2);

        return hasOperator && isNotLeftParen && (prec1 || prec2);
    }

    private static boolean isLeftAsoc(char c) {
        return c != '^';
    }
}
