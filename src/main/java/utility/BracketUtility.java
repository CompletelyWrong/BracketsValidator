package utility;

import java.util.Stack;

import static java.util.Objects.isNull;

public final class BracketUtility {

    public static boolean isValidByMath(String brackets) {
        validateInput(brackets);

        if (brackets.isEmpty() || brackets.charAt(0) != '(') {
            return false;
        }

        int counter = 0;
        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(') {
                counter++;
            } else if (brackets.charAt(i) == ')') {
                if (counter == 0) {
                    return false;
                }
                counter--;
            }
        }

        return counter == 0;
    }

    public static boolean isValidByRegEx(String brackets) {
        validateInput(brackets);

        if (brackets.isEmpty() || brackets.charAt(0) != '(') {
            return false;
        }

        while (brackets.contains("()")) {
            brackets = brackets.replace("()", "");
        }

        return brackets.length() == 0;
    }

    public static boolean isValidByStack(String brackets) {
        validateInput(brackets);

        if (brackets.isEmpty() || brackets.charAt(0) != '(') {
            return false;
        }

        char[] chars = brackets.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char bracket : chars) {
            if (bracket == '(') {
                stack.push('(');
            } else if (bracket == ')') {
                if (!stack.empty() && bracket != stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static boolean isValidByTree(String brackets) {
        return false;
    }

    private static void validateInput(String brackets) {
        if (isNull(brackets)) {
            throw new IllegalArgumentException("Parameter is null");
        }
    }

    private BracketUtility() {
    }
}
