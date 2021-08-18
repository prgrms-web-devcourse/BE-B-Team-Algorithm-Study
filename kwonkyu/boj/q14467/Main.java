package boj.q14467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> cows = new HashMap<>();
        int crossed = 0;

        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            String[] state = br.readLine().split(" ");
            int cow = Integer.parseInt(state[0]);
            int newPosition = Integer.parseInt(state[1]);

            int previousPosition = cows.getOrDefault(cow, newPosition);
            if (newPosition != previousPosition)
                crossed++;
            cows.put(cow, newPosition);
        }

        System.out.println(crossed);
    }
}
