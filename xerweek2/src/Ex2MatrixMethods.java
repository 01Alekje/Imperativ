import java.util.Arrays;

import static java.lang.StrictMath.round;
import static java.lang.StrictMath.sqrt;
import static java.lang.System.out;

/*
 * Methods with array/matrix params and/or return value. Implement methods.
 *
 *  See:
 *  ex2references
 *  ex5matrix
 */
public class Ex2MatrixMethods {

    public static void main(String[] args) {
        new Ex2MatrixMethods().program();
    }

    void program() {
        int[][] m = {           // Hard coded test data
                {-1, 0, -5, 3},
                {6, 7, -2, 0},
                {9, -2, -6, 8},
                {0, 0, 5, -6}
        };

        // Return array with all negatives in m
        int[] negs = getNegatives(m);
        out.println(negs.length == 6);
        out.println(Arrays.toString(negs).equals("[-1, -5, -2, -2, -6, -6]")); // Possibly other ordering!


        test();
        // Mark all negatives with a 1, others as 0
        // (create matrix on the fly)
        /*
        int[][] marked = markNegatives(new int[][]{
                {1, -2, 3,},
                {-4, 5, -6,},
                {7, -8, 9,},
        });
        */
        /* marked should be
        { {0, 1, 0},
          {1, 0, 1},
          {0, 1, 0} }
        */
        //out.println(Arrays.toString(marked[0]).equals("[0, 1, 0]"));
        //out.println(Arrays.toString(marked[1]).equals("[1, 0, 1]"));
        //out.println(Arrays.toString(marked[2]).equals("[0, 1, 0]"));

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Create matrix from array
        //int[][] matrix = toMatrix(arr);
        /* matrix should be
        { {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9} }
        */
        //plot(matrix);  // If manual inspection
        //out.println(Arrays.toString(matrix[0]).equals("[1, 2, 3]"));
        //out.println(Arrays.toString(matrix[1]).equals("[4, 5, 6]"));
        //out.println(Arrays.toString(matrix[2]).equals("[7, 8, 9]"));

        // Sum of all directly surrounding elements to some element in matrix
        // (not counting the element itself)
        // NOTE: Should be possible to expand method to include more distant neighbours
        //out.println(sumNeighbours(matrix, 0, 0) == 11);
        //out.println(sumNeighbours(matrix, 1, 1) == 40);
        //out.println(sumNeighbours(matrix, 1, 0) == 23);
    }

    // -------- Write methods below this -----------------------

/*    int[] getNegatives (int[][] arr) {
        int[] negArr = new int[(arr.length)*arr[0].length]; // not optimal
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < 0) {
                    out.println(arr[i][j]);
                    negArr[j] = arr[i][j];
                }
            }
        }
        out.println(Arrays.toString(negArr));
        //return negArr;
        return rmZeros(negArr);
    }*/


    void test() {
        int[] hej = {0,0};
        for (int i = 0; i < 10; i++) {
            hej[1]++;
            out.println(hej[1]);
        }
    }
    int[] getNegatives (int[][] arr) {
        int[] shitArray = toArray(arr);
        int[] sluta = new int[zuperEazy(shitArray)];
        int k = 0;
        for (int i = 0; i < toArray(arr).length; i++) {
            if (shitArray[i] < 0) {
                sluta[k] = shitArray[i];
                k++;
            }
        }
        out.println(Arrays.toString(sluta));
        return sluta;
    }

    int[] toArray (int[][] arr) {
        int[] newArr = new int[(arr.length)*arr[0].length]; // not optimal
        int thing = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[thing] = arr[i][j];
                thing++;
            }
        }
        return newArr;
    }

    int zuperEazy (int[] arr) {
        int count = 0;
        for (int el : arr) {
            if (el < 0) {
                count++;
            }
        }
        return count;
    }


    boolean isValidLocation(int size, int row, int col) {
        return row >= 0 && col >= 0 && row < size && col < size;
    }


    // Use if you like (during development)
    void plot(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }


}
