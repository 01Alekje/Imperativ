import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Program to exercise arrays
 *
 * See:
 * - ex3arraysfor
 * - Check AF6AritmSeries
 */
public class Ex4Arrays {

    public static void main(String[] args) {
        new Ex4Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        int[] arr = new int[5];

        out.print("Input 5 integers (space between, then enter) > ");
        // turn into array
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        out.println("Array is " + Arrays.toString(arr));

        out.print("Input a value to find > ");
        int valToFind = sc.nextInt();
        //find value
        for (int i = 0; i < 5; i++) {
            if (arr[i] == valToFind) {
                out.print("Value " + valToFind + " is at index " + i);
                return;
            }
        }
        out.print("Value not found");
    }
}
