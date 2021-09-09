package boj.q13700;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int S;
    private static int D;
    private static int F;
    private static int B;
    private static int K;
    private static Set<Integer> police = new HashSet<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // buildings
        S = Integer.parseInt(st.nextToken()); // init position
        D = Integer.parseInt(st.nextToken()); // destination
        F = Integer.parseInt(st.nextToken()); // front running distance
        B = Integer.parseInt(st.nextToken()); // backward running distance
        K = Integer.parseInt(st.nextToken()); // polices

        visited = new boolean[N + 1];

        if (K > 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                police.add(Integer.parseInt(st.nextToken()));
            }
        }

        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] { S, 0 }); // current building, running days
        int days = -1;
        while (!queue.isEmpty()) {
            int[] current = queue.pop();
            int position = current[0];
            int day = current[1];
            if (visited[position] || police.contains(position))
                continue;
            visited[position] = true;
            if (position == D) {
                days = day;
                break;
            }
            if (isForwardable(current[0]))
                queue.add(new int[] { current[0] + F, current[1] + 1 });
            if (isBackwardable(current[0]))
                queue.add(new int[] { current[0] - B, current[1] + 1 });
        }

        if (days < 0) {
            bw.write("BUG FOUND");
        } else {
            bw.write(String.valueOf(days));
        }
        bw.flush();
    }

    private static boolean isForwardable(int current) {
        return current + F <= N;
    }

    private static boolean isBackwardable(int current) {
        return current - B >= 1;
    }

}
