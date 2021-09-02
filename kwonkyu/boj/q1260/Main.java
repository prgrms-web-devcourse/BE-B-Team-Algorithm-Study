package boj.q1260;

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

    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][N + 1];

        int V = Integer.parseInt(st.nextToken());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = map[to][from] = true;
        }

        dfs(V, new boolean[N + 1]);
        bw.write("\n");
        bfs(V, new boolean[N + 1], new LinkedList<>(List.of(V)));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int node, boolean[] visited) throws IOException {
        if (visited[node])
            return;
        else {
            visited[node] = true;
            bw.write(node + " ");
        }

        List<Integer> connected = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (map[node][i] && !visited[i]) {
                connected.add(i);
            }
        }

        for (Integer other : connected) {
            dfs(other, visited);
        }
    }

    private static void bfs(int node, boolean[] visited, Deque<Integer> connected) throws IOException {
        while (!connected.isEmpty()) {
            int other = connected.poll();
            if (visited[other]) {
                continue;
            } else {
                visited[other] = true;
                bw.write(other + " ");
            }

            for (int i = 1; i <= N; i++) {
                if (map[other][i] && !visited[i]) {
                    connected.add(i);
                }
            }
        }
    }
}
