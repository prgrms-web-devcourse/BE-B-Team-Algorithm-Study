package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/14467
 * silver5
 * 소가 길을 건너간 이유1
 */

public class BOJ_14467 {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int taseCase = Integer.parseInt(br.readLine());

        Map<String,Integer> cowInfo = new HashMap<>();
        for (int i = 0; i < taseCase; i++) {
            String input = br.readLine();
            String[] s = input.split(" ");
            int cowPosition = Integer.parseInt(s[1]);
            if (cowInfo.containsKey(s[0])){
                if (cowInfo.get(s[0]) != cowPosition){
                    cowInfo.put(s[0],cowPosition);
                    count++;
                }
            }
            cowInfo.put(s[0], cowPosition);
        }

        System.out.println(count);
    }
}
