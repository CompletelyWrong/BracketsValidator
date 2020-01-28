package utility;

import java.util.Objects;
import java.util.Stack;

public final class BracketUtility {
    private static final String REG_EX = "\\(|\\)";

    public static boolean isValidByMath(String brackets) {
        validate(brackets);

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
        validate(brackets);

        if (brackets.isEmpty() || brackets.charAt(0) != '(') {
            return false;
        }

        int length = brackets.length();
        int newLength = brackets.replaceAll(REG_EX, "").length();
        int diff = length - newLength;

        return diff % 2 == 0;
    }

    public static boolean isValidByStack(String brackets) {
        validate(brackets);

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

    private static void validate(String brackets) {
        if (Objects.isNull(brackets)) {
            throw new IllegalArgumentException("Parameter is null");
        }
    }

    private BracketUtility() {
    }
}
