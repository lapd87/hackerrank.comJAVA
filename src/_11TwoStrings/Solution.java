package _11TwoStrings;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        Set<Character> s1Chars = s1.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toSet());

        Set<Character> s2Chars = s2.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toSet());

        boolean hasMatch = s1Chars.retainAll(s2Chars);

        for (Character s1Char : s1Chars) {
            if (s2Chars.contains(s1Char)) {
                return "YES";
            }
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            stringBuilder.append(result)
                    .append(System.lineSeparator());
        }

        System.out.println(stringBuilder);

        scanner.close();
    }
}
