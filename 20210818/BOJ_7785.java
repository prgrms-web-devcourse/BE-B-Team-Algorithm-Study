package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/7785
 * silver5
 * 회사에 있는 사람
 */
public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        Map<String, String> record = new HashMap<>();
        List<String> results = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String staff = br.readLine();
            String[] staffInfo = staff.split(" ");
            record.put(staffInfo[0],staffInfo[1]);
        }

        Set<String> names = record.keySet();

        for (String name : names) {

            if (record.get(name).equals("enter")) {
                results.add(name);
            }
        }
        results.sort(Collections.reverseOrder());
        results.forEach(System.out::println);
    }
}
