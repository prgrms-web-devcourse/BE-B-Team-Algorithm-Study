package boj.q7576;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;
    private static int map[][];
    private static boolean[][] touched;
    private static int notRottenTomatoes;
    private static int rottenTomatoes;

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int rotDay;

        public Coordinate(int x, int y, int rotDay) {
            this.x = x;
            this.y = y;
            this.rotDay = rotDay;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        touched = new boolean[N][M];

        Deque<Coordinate> rottenTomatoes = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    notRottenTomatoes++;
                if (map[i][j] == 1) {
                    rottenTomatoes.add(new Coordinate(i, j, 0));
                }
            }
        }

        int days = Integer.MIN_VALUE;
        while (!rottenTomatoes.isEmpty()) {
            Coordinate c = rottenTomatoes.pop();
            touched[c.x][c.y] = true;
            if (rot(c.x + 1, c.y))
                rottenTomatoes.add(new Coordinate(c.x + 1, c.y, c.rotDay + 1));
            if (rot(c.x - 1, c.y))
                rottenTomatoes.add(new Coordinate(c.x - 1, c.y, c.rotDay + 1));
            if (rot(c.x, c.y + 1))
                rottenTomatoes.add(new Coordinate(c.x, c.y + 1, c.rotDay + 1));
            if (rot(c.x, c.y - 1))
                rottenTomatoes.add(new Coordinate(c.x, c.y - 1, c.rotDay + 1));

            days = c.rotDay > days ? c.rotDay : days;
        }

        if (isAllRotten())
            bw.write(String.valueOf(days));
        else
            bw.write("-1");

        bw.flush();
    }

    private static boolean rot(int i, int j) {
        if (i >= N || i < 0 || j >= M || j < 0 || isWall(map[i][j]) || isRottenTomato(map[i][j]))
            return false;

        if (map[i][j] != 1)
            rottenTomatoes++;
        map[i][j] = 1;
        return true;
    }

    private static boolean isWall(int value) {
        return value == -1;
    }

    private static boolean isNormalTomato(int value) {
        return value == 0;
    }

    private static boolean isRottenTomato(int value) {
        return value == 1;
    }

    private static boolean isAllRotten() {
        return rottenTomatoes == notRottenTomatoes;
    }
}
