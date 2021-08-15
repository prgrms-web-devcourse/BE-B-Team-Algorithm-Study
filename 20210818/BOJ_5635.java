package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 백준 https://www.acmicpc.net/problem/5635
 * silver5
 * 생일
 */

public class BOJ_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] testString = new String[testCase];
        for (int i = 0; i < testCase; i++) {
            testString[i] = br.readLine();
        }

        Map<LocalDate, String> nameAndBDay = new HashMap<>();
        List<LocalDate> localDates = new ArrayList<>();
        for (int i = 0; i < testString.length; i++) {
            String s = testString[i];
            String[] personInfo = s.split(" ");
            LocalDate personBirthDay = LocalDate.of(
                    Integer.parseInt(personInfo[3]),
                    Integer.parseInt(personInfo[2]),
                    Integer.parseInt(personInfo[1]));
            localDates.add(personBirthDay);
            nameAndBDay.put(personBirthDay, personInfo[0]);
        }

        localDates.sort(LocalDate::compareTo);

        System.out.println(nameAndBDay.get(localDates.get(localDates.size() - 1)));
        System.out.println(nameAndBDay.get(localDates.get(0)));



    }
}
