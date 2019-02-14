package _13CountTriplets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> secondCount = new HashMap<>();
        Map<Long, Long> thirdCount = new HashMap<>();

        long count = 0;

        if (r == 1) {
            for (Long num : arr) {
                secondCount.put(num,
                        secondCount.getOrDefault(num, 0L) + 1);
            }

            count = secondCount.values()
                    .stream()
                    .filter(v -> v >= 3)
                    .mapToLong(v -> {
                        long possibleMixes = 0;
                        for (int i = 0; i < v; i++) {
                            for (int j = i + 1; j < v; j++) {
                                for (int k = j + 1; k < v; k++) {
                                    possibleMixes++;
                                }
                            }
                        }

                        return possibleMixes;
                    })
                    .sum();

            return count;
        }


        for (Long num : arr) {

            count += thirdCount.getOrDefault(num, 0L);

            Long secondNumCount = secondCount.get(num);

            long nextNum = num * r;

            if (secondNumCount != null) {
                thirdCount.put(nextNum,
                        thirdCount.getOrDefault(nextNum, 0L) + secondNumCount);
            }

            secondCount.put(nextNum,
                    secondCount.getOrDefault(nextNum, 0L) + 1);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);

        bufferedReader.close();
    }
}
