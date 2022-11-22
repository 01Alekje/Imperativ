import java.util.Arrays;

import static java.lang.System.out;

/*
    Find three elements in sorted array that adds up to 0.
    Return indices to the elements as an array.
 */
public class Ex5ThreeSumToZero {

    public static void main(String[] args) {
        new Ex5ThreeSumToZero().program();
    }


    void program() {
        int[] arr1 = {-25, -10, -7, -3, 2, 4, 8, 10}; // Must be sorted
        int[] arr2 = {0, 1, 2, 4, 8, 10};
        int[] arr3 = {-2, 1, 1};
        int[] arr4 = {0, 0, 0, 0};

        out.println(Arrays.toString(getThreeSum(arr1)));    // [1, 4, 6]
        out.println(Arrays.toString(getThreeSum(arr2)));    // []
        out.println(Arrays.toString(getThreeSum(arr3)));    // [0, 1, 2]
        out.println(Arrays.toString(getThreeSum(arr4)));    // [ 0, 1 ,3 ] or any (fast nej det ska vara [0,1,2]. de första som blir 0 ska returneras!)
    }

    // NOTE: Solution may not contain nested loops
    // arr[0] + arr[1] + arr[2] == 0 {return [0,1,2]} else arr[0] + arr[1] + arr[3] == 0 {return [0,1,3]} else ....} för varje tal i listan... :(
    int[] getThreeSum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j != i && j+1 < arr.length) {
                    if (arr[i] + arr[j] + arr[j+1] == 0) {
                        return (new int[3]);
                    }
                }
            }
        }
        return null;
    }
}
