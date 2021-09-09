package boj.q1303;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;
    private static char[][] map;
    private static boolean[][] visited;
    private static int firePowerW = 0;
    private static int firePowerB = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j])
                    continue;
                queue.clear();
                queue.add(new int[] { i, j });
                int firePower = 0;
                char force = map[i][j];
                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    int x = current[0];
                    int y = current[1];
                    if (!isValidAndFriendly(x, y, force))
                        continue;
                    visited[x][y] = true;
                    firePower++;
                    queue.add(new int[] { x + 1, y });
                    queue.add(new int[] { x - 1, y });
                    queue.add(new int[] { x, y + 1 });
                    queue.add(new int[] { x, y - 1 });
                }

                if (force == 'W') {
                    firePowerW += (firePower * firePower);
                } else {
                    firePowerB += (firePower * firePower);
                }
            }
        }

        bw.write(String.format("%d %d", firePowerW, firePowerB));
        bw.flush();

    }

    private static boolean isValidAndFriendly(int x, int y, char friend) {
        return x >= 0 && y >= 0 && x < M && y < N && map[x][y] == friend && !visited[x][y];
    }
}
