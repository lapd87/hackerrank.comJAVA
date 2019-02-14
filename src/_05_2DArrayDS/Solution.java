package _05_2DArrayDS;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        List<Integer> sums = new ArrayList<>();

        for (int row = 0; row < arr.length - 2; row++) {
            for (int col = 0; col < arr.length - 2; col++) {

                sums.add(calcHourglassSum(row, col, arr));
            }
        }

        return Collections.max(sums);
    }

    private static Integer calcHourglassSum(int row, int col, int[][] arr) {

        int[][] moves = {
                {row, col},
                {row, col + 1},
                {row, col + 2},
                {row + 1, col + 1},
                {row + 2, col},
                {row + 2, col + 1},
                {row + 2, col + 2},
        };

        int sum = 0;

        for (int[] move : moves) {
            sum += arr[move[0]][move[1]];
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
