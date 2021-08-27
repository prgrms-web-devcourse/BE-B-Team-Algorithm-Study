package boj.q15649;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] combination;
    private static int N;
    private static int M;

    private static void findCombination(int level, boolean[] used) throws IOException {
        if (level >= M) {
            StringBuilder sb = new StringBuilder();
            for (int element : combination) {
                sb.append(element + " ");
            }
            bw.write(sb.toString());
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            combination[level] = i;
            findCombination(level + 1, used);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        combination = new int[M];

        boolean[] used = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            used[i] = true;
            combination[0] = i;
            findCombination(1, used);
            used[i] = false;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
