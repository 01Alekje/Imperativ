import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.System.out;

/*
 *
 *  Use a Stack to check parentheses (balanced and correct nesting)
 *  The parentheses are: (), [] and {}
 *
 *  See:
 *  - ex2shortforswitch/SwitchStatement
 *  - ex5collections/C4Stack
 *  - ex5collections/C5Palindrome
 */
public class Ex4CheckParen {

    public static void main(String[] args) {
        new Ex4CheckParen().program();
    }

    void program() {
        // All should be true
        /*
        out.println(checkParentheses("()"));
        out.println(checkParentheses("(()())"));
        out.println(!checkParentheses("(()))")); // Unbalanced
        out.println(!checkParentheses("((())")); // Unbalanced

        out.println(checkParentheses("({})"));
        out.println(!checkParentheses("({)}"));  // Bad nesting
        out.println(checkParentheses("({} [()] ({}))"));
        out.println(!checkParentheses("({} [() ({)})"));  // Unbalanced and bad nesting
        */
    }

    // ---------------- Methods --------------------



    // This is interesting because method has to return, but what if no match?!?
    char matching(char ch) {
        switch (ch) {
            case ')':
                return '(';  // c = '('
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                // If throwing exception don't need to return
                throw new IllegalArgumentException("No match found");
        }
    }
}
