package boj.q4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean vowelCheck(String s) {
        return s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u");
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static boolean duplicatedCheck(String s) {
        char[] chars = s.toCharArray();
        boolean isPreviousVowel = isVowel(chars[0]);
        int count = 1;
        for (int index = 1; index < chars.length; index++) {
            boolean isCurrentVowel = isVowel(chars[index]);
            if (isCurrentVowel == isPreviousVowel) {
                count++;
                if (count >= 3)
                    return false;
            } else {
                isPreviousVowel = isCurrentVowel;
                count = 1;
            }
        }

        return count < 3;
    }

    private static boolean continuousCheck(String s) {
        char[] chars = s.toCharArray();
        char previous = chars[0];
        for (int index = 1; index < chars.length; index++) {
            if (chars[index] != 'e' && chars[index] != 'o' && chars[index] == previous)
                return false;
            else
                previous = chars[index];
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String password = br.readLine();

            if ("end".equals(password))
                return;

            if (!vowelCheck(password) || !duplicatedCheck(password) || !continuousCheck(password))
                System.out.printf("<%s> is not acceptable.%n", password);
            else
                System.out.printf("<%s> is acceptable.%n", password);
        }
    }
}
