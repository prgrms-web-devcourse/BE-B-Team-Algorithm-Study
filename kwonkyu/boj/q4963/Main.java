package boj.q4963;

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
    private static int w;
    private static int h;
    private static int[][] map;
    private static boolean[][] visited;
    private static int island;

    public static void main(String[] args) throws IOException {
        while (true) {
            island = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int row = 0; row < h; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < w; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            for (int row = 0; row < h; row++) {
                for (int col = 0; col < w; col++) {
                    if (visited[row][col] || !isLand(row, col))
                        continue;

                    island++;
                    Deque<int[]> queue = new LinkedList<>();
                    queue.add(new int[] { row, col });
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];
                        if (isValidPosition(x, y) && isLand(x, y) && !visited[x][y]) {
                            visited[x][y] = true;
                            queue.add(new int[] { x + 1, y + 1 });
                            queue.add(new int[] { x + 1, y });
                            queue.add(new int[] { x + 1, y - 1 });
                            queue.add(new int[] { x, y + 1 });
                            queue.add(new int[] { x, y - 1 });
                            queue.add(new int[] { x - 1, y + 1 });
                            queue.add(new int[] { x - 1, y });
                            queue.add(new int[] { x - 1, y - 1 });
                        }

                    }
                }
            }

            bw.write(String.valueOf(island));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w;
    }

    private static boolean isLand(int x, int y) {
        return map[x][y] == 1;
    }
}
