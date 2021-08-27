package boj.q15650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;

    private static void findCombination(int level, boolean[] used, List<Integer> output) throws IOException {
        if (level >= M && output.size() == M) {
            StringBuilder sb = new StringBuilder();
            output.forEach(integer -> sb.append(integer + " "));
            bw.write(sb.toString());
            bw.write("\n");
            return;
        }

        for (int i = level + 1; i <= N; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            output.add(i);
            findCombination(i, used, output);
            output.remove(Integer.valueOf(i));
            used[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[] used = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            used[i] = true;
            findCombination(i, used, new ArrayList<>(List.of(i)));
            used[i] = false;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
