package boj.q15651;

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
    private static int[] combinated;

    private static void findCombination(int level) throws IOException {
        if (level >= M) {
            StringBuilder sb = new StringBuilder();
            for (int c : combinated) {
                sb.append(c + " ");
            }
            bw.write(sb.toString());
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            combinated[level] = i;
            findCombination(level + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        combinated = new int[M];

        for (int i = 1; i <= N; i++) {
            combinated[0] = i;
            findCombination(1);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
