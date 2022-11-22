import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Program to calculate sum and average for non-negative integers
 *
 * See:
 * - ex2ifwhile
 * - IW5LoopAndAHalf in particular.
 *
 */
public class Ex3SumAvg {

    public static void main(String[] args) {
        new Ex3SumAvg().program();
    }

    final Scanner sc = new Scanner(in);

    public double calcAvg (int tot, int count) {
        return (tot / count);
    }

    void program() {
        // Write your code here
        int input;
        int sum = 0;
        int i = 0;
        // -- Input (and bookkeeping)
        while (true) {
            out.print("> ");
            input = sc.nextInt();
            if (input < 0) {
                break;
            }
            sum += input;
            i += 1;
        }

        // -- Process---

        // -- Output ----

        out.println("Sum = " + sum + ", Avg = " + calcAvg(sum, i));

    }

}
