package boj.q21736;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int people;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        int playerX = 0, playerY = 0;
        for (int row = 0; row < N; row++) {
            char[] cells = br.readLine().toCharArray();
            for (int col = 0; col < M; col++) {
                map[row][col] = cells[col];
                if (cells[col] == 'I') {
                    playerX = row;
                    playerY = col;
                }
            }
        }

        dfs(playerX, playerY);

        bw.write(people == 0 ? "TT" : String.valueOf(people));
        bw.flush();
        bw.close();
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static boolean isBlockedPosition(int x, int y) {
        return map[x][y] == 'X';
    }

    private static void dfs(int currentX, int currentY) {
        if (!isValidPosition(currentX, currentY) || visited[currentX][currentY]
                || isBlockedPosition(currentX, currentY))
            return;
        else
            visited[currentX][currentY] = true;

        if (map[currentX][currentY] == 'P')
            people++;

        dfs(currentX + 1, currentY);
        dfs(currentX - 1, currentY);
        dfs(currentX, currentY + 1);
        dfs(currentX, currentY - 1);
    }
}
