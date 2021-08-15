package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 백준 https://www.acmicpc.net/problem/2870
 * silver5
 * 수학 숙제
 */

public class BOJ_2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] testString = new String[testCase];
        for (int i = 0; i < testCase; i++) {
            testString[i] = br.readLine();
        }

        List<BigDecimal> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testString.length; i++) {
            for (int j = 0; j < testString[i].length(); j++) {
                char temp = testString[i].charAt(j);

                // 문자가 숫자 형태일 경우
                if (Character.isDigit(temp)) {
                    sb.append(temp);
                    continue;
                } else if (sb.length() > 0) { // 현재 문자가 숫자 형태가 아닌데 그 전에 숫자가 저장되어 있는 경우
                    // list에 저장
                    numbers.add(new BigDecimal(sb.toString()));
                    // sb 지우기
                    sb.setLength(0);
                }
            }

            // 한줄에 대한 입력 끝났는데 숫자가 저장되어 있는 경우
            if (sb.length() > 0) {
                numbers.add(new BigDecimal(sb.toString()));

                // sb 지우기
                sb.setLength(0);
            }

        }
        Collections.sort(numbers);
        System.out.println("============");
        numbers.forEach(System.out::println);
    }
}
