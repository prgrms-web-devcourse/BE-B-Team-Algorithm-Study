package boj.q2870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;

public class Main {
    private static String checkZeros(StringBuilder sb) {
        boolean allZero = true; // check if all string is zeros.
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                allZero = false;
                break;
            }
        }

        if (allZero)
            return "0";
        else { // remove preceding zeros.
            int zeroIndex = -1;
            while (zeroIndex < sb.length() - 1 && sb.charAt(zeroIndex + 1) == '0')
                zeroIndex++;
            return sb.toString().substring(zeroIndex + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> numbers = new LinkedList<>();

        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            char[] line = br.readLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char ch : line) {
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                } else {
                    if (sb.length() > 0) {
                        numbers.add(checkZeros(sb));
                        sb = new StringBuilder();
                    }
                }
            }

            if (sb.length() > 0) {
                numbers.add(checkZeros(sb));
            }
        }

        numbers.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return 1;
                } else if (s1.length() < s2.length()) {
                    return -1;
                }

                for (int numIndex = 0; numIndex < s1.length(); numIndex++) {
                    int compared = s1.charAt(numIndex) - s2.charAt(numIndex);
                    if (compared == 0)
                        continue;
                    else
                        return compared;
                }

                return 0;
            }
        });

        numbers.forEach(System.out::println);
    }
}
