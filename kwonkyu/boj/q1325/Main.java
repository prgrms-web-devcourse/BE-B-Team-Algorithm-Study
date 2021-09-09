package boj.q1325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;
    private static int[] score;
    private static boolean[] hacked;
    private static Map<Integer, List<Integer>> trust = new HashMap<>();

    private static void dfs(int source, int current) {
        hacked[current] = true;
        score[source]++;

        trust.getOrDefault(current, new ArrayList<>(0)).forEach(connected -> {
            if (!hacked[connected])
                dfs(source, connected);
        });
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        score = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int trusting = Integer.parseInt(st.nextToken());
            int trusted = Integer.parseInt(st.nextToken());

            List<Integer> trustView = trust.getOrDefault(trusted, new ArrayList<>());
            trustView.add(trusting);
            trust.put(trusted, trustView);
        }

        for (int i = 1; i <= N; i++) {
            hacked = new boolean[N + 1];
            dfs(i, i);
        }

        int max = Integer.MIN_VALUE;
        for (int s : score) {
            max = Math.max(max, s);
        }

        for (int i = 1; i <= N; i++) {
            if (score[i] == max)
                bw.write(String.valueOf(i) + " ");
        }

        bw.flush();
    }
}
