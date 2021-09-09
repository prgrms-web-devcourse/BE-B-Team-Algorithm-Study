package boj.q5567;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<List<Integer>> friendship;
    private static boolean[] visited;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        friendship = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            friendship.add(new LinkedList<>());
        }

        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            friendship.get(from).add(to);
            friendship.get(to).add(from);
        }

        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 1, 0 }); // node, level
        int count = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.pop();
            if (visited[current[0]] || current[1] > 2)
                continue;
            visited[current[0]] = true;
            count++;
            for (int f : friendship.get(current[0])) {
                queue.add(new int[] { f, current[1] + 1 });
            }
        }

        bw.write(String.valueOf(count - 1));
        bw.flush();
    }
}
