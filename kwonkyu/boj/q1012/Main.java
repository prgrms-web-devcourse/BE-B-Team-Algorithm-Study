package boj.q1012;

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
    private static int T;
    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int worm;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            worm = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];

            int K = Integer.parseInt(st.nextToken());
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (visited[row][col] || !isCabbage(row, col))
                        continue;

                    worm++;
                    Deque<int[]> queue = new LinkedList<>();
                    queue.add(new int[] { row, col });
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];
                        if (isValidPosition(x, y) && isCabbage(x, y) && !visited[x][y]) {
                            visited[x][y] = true;
                            queue.add(new int[] { x + 1, y });
                            queue.add(new int[] { x - 1, y });
                            queue.add(new int[] { x, y + 1 });
                            queue.add(new int[] { x, y - 1 });
                        }

                    }
                }
            }

            bw.write(String.valueOf(worm));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static boolean isCabbage(int x, int y) {
        return map[x][y] == 1;
    }
}
