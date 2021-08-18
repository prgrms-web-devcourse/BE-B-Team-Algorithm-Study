package boj.q7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Boolean> employees = new TreeMap<>(Collections.reverseOrder());

        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            String[] employee = br.readLine().split(" ");
            switch (employee[1]) {
                case "enter":
                    employees.put(employee[0], true);
                    break;

                case "leave":
                    employees.put(employee[0], false);
                    break;
            }
        }

        employees.forEach((name, state) -> {
            if (state)
                System.out.println(name);
        });
    }
}
