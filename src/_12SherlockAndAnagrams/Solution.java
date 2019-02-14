package _12SherlockAndAnagrams;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        Map<String, Integer> letterCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                String key = s.substring(i, j).chars()
                        .sorted()
                        .mapToObj(letter -> String.valueOf((char) letter))
                        .collect(Collectors.joining());

                letterCount.putIfAbsent(key, 0);

                letterCount.put(key, letterCount.get(key) + 1);
            }
        }

        return letterCount.values()
                .stream()
                .mapToInt(count -> count * (count - 1) / 2)
                .sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            stringBuilder.append(String.valueOf(result))
                    .append(System.lineSeparator());
        }

        System.out.println(stringBuilder);

        scanner.close();
    }
}
