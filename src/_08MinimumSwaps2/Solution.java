package _08MinimumSwaps2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int swaps = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                swap(arr, i);
                swaps++;
                i--;
            }
        }

        return swaps;
    }

    private static void swap(int[] arr, int i) {
        int temp = arr[i];
        int correctIndex = temp - 1;
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
