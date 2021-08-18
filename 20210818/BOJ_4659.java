package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/4659
 * silver5
 * 비밀번호 발음하기
 */
public class BOJ_4659 {

    private static boolean vowelCheck(String password) {
        if (password.contains("a")) {
            return true;
        } else if (password.contains("e")) {
            return true;
        } else if (password.contains("i")) {
            return true;
        } else if (password.contains("o")) {
            return true;
        } else if (password.contains("u")) {
            return true;
        }
        return false;
    }

    private static boolean continuousPassword(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            char first = password.charAt(i);
            char second = password.charAt(i + 1);
            if (first == second) {
                if (first == 'e' || first == 'o') {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    // 모음이면 true 자음이면 false
    private static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    private static boolean continuousCharCheck(String password) {
        int limit = 3;

        boolean status = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            // 현재 문자가 모음일 때
            if (isVowel(c)) {
                // 이전 문자가 모음인 경우
                if (status) {
                    limit--;
                } else {
                    limit = 2;
                }
                status = true;

                // 현재 문자가 자음일 때
            } else {
                // 이전 문자가 자음인 경우
                if (!status) {
                    limit--;
                } else {
                    limit = 2;
                }
                status = false;
            }
            if (limit == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean validationCheck(String password) {
        boolean validationChecked = vowelCheck(password);
        if (!validationChecked) {
            return false;
        }

        validationChecked = continuousPassword(password);
        if (!validationChecked) {
            return false;
        }

        validationChecked = continuousCharCheck(password);
        if (!validationChecked) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String password = br.readLine();
            if (password.equals("end")) {
                break;
            }
            if (validationCheck(password)) {
                sb.append("<").append(password).append("> is acceptable.\n");
                continue;
            }
            sb.append("<").append(password).append("> is not acceptable.\n");
        }
        System.out.println(sb);
    }
}
