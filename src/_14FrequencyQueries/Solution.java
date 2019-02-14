package _14FrequencyQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {

        Map<Integer, Integer> valueCount = new HashMap<>();
        Map<Integer, Set<Integer>> countValues = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {

            int num = query[1];

            switch (query[0]) {

                case 1:
                    Integer oldValue = valueCount.getOrDefault(num, 0);
                    Integer newValue = oldValue + 1;

                    countValues.getOrDefault(oldValue, new HashSet<>())
                            .remove(num);

                    Set<Integer> newSet = countValues.getOrDefault(newValue, new HashSet<>());
                    newSet.add(num);

                    countValues.put(newValue, newSet);

                    valueCount.put(num, newValue);
                    break;
                case 2:
                    oldValue = valueCount.getOrDefault(num, 0);

                    if (oldValue > 0) {
                        newValue = oldValue - 1;

                        countValues.getOrDefault(oldValue, new HashSet<>())
                                .remove(num);

                        newSet = countValues.getOrDefault(newValue, new HashSet<>());
                        newSet.add(num);

                        countValues.put(newValue, newSet);

                        valueCount.put(num, newValue);
                    }
                    break;
                case 3:
                    int nums = countValues
                            .getOrDefault(num, new HashSet<>())
                            .size();

                    if (nums <= 0) {
                        result.add(0);
                    } else {
                        result.add(1);
                    }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<int[]> queries = new ArrayList<>(q);
        Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
        for (int i = 0; i < q; i++) {
            int[] query = new int[2];
            Matcher m = p.matcher(bufferedReader.readLine());
            if (m.matches()) {
                query[0] = Integer.parseInt(m.group(1));
                query[1] = Integer.parseInt(m.group(2));
                queries.add(query);
            }
        }
        List<Integer> ans = freqQuery(queries);

//        List<List<Integer>> queries = new ArrayList<>();
//
//        IntStream.range(0, q).forEach(i -> {
//            try {
//                queries.add(
//                        Stream.of(bufferedReader.readLine()
//                                .replaceAll("\\s+$", "")
//                                .split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        List<Integer> ans = freqQuery(queries);

        System.out.println(ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n");

        bufferedReader.close();
    }
}
