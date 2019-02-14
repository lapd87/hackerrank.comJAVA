package _02CountingValleys;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int valeyCount = 0;

        for (int i = 0; i < n - 1; i = hike(s, i, n)) {

            if (s.charAt(i) == 'D') {
                valeyCount++;
            }
        }

        return valeyCount;
    }

    private static int hike(String s, int i, int n) {
        int elevation = 0;

        while (i < n) {
            boolean isDownhill = s.charAt(i) == 'D';

            if (isDownhill) {
                elevation--;
            } else {
                elevation++;
            }

            i++;

            if (elevation == 0) {
                break;
            }
        }
        return i;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
