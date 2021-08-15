package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/3048
 * silver4
 * 개미
 */

public class BOJ_3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase = br.readLine();
        String antGroup[] = testCase.split(" ");
        int n1 = Integer.parseInt(antGroup[0]);
        int n2 = Integer.parseInt(antGroup[1]);
        String ant1 = br.readLine();
        String ant2 = br.readLine();
        int second = Integer.parseInt(br.readLine());

        // 개미들 저장
        List<Character> ants = new ArrayList<>();

        // 각 개미들의 이동 방향 저장
        Map<Character, String> antInfo = new HashMap<>();
        for (int i = ant1.length() - 1; i >= 0; i--) {
            ants.add(ant1.charAt(i));
            antInfo.put(ant1.charAt(i), "right");
        }
        for (int i = 0; i < ant2.length(); i++) {
            ants.add(ant2.charAt(i));
            antInfo.put(ant2.charAt(i), "left");
        }

        // 지정한 횟수만큼 이동
        for (int i = 0; i < second; i++) {
            boolean checked = true;
            for (int j = 0; j < ants.size() - 1; j++) {
                if (!checked) {
                    checked = true;
                    continue;
                }
                // 서로에게 진행방향이 막히는 경우
                if (antInfo.get(ants.get(j)).equals("right") && antInfo.get(ants.get(j + 1)).equals("left")) {
                    // 위치 변경
                    Collections.swap(ants, j, j + 1);
                    // 다음 개미 부터 확인하기 위한 flag
                    checked = false;
                }
            }
        }

        // 정답 출력
        StringBuilder sb = new StringBuilder();
        for (Character character : ants) {
            sb.append(character);
        }
        System.out.println(sb);
    }
}
