package boj.q18405;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class VirusStatus implements Comparable<VirusStatus> {

    int x;
    int y;
    int id;
    int time;

    @Override
    public int compareTo(VirusStatus o) {
        if (this.time == o.time)
            return this.id - o.id;
        else
            return this.time - o.time;
    }

    public VirusStatus(int x, int y, int id, int time) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.time = time;
    }

}

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int K;
    private static int S;
    private static int X;
    private static int Y;
    private static int[][] map;
    private static final PriorityQueue<VirusStatus> heap = new PriorityQueue<>();

    private static boolean infect(int x, int y, int virus) {
        if (x < 0 || y < 0 || x >= N || y >= N || map[x][y] != 0)
            return false;
        map[x][y] = virus;
        return true;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    heap.add(new VirusStatus(i, j, map[i][j], 0));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        while (S-- > 0) {
            int limit = heap.size();
            while (limit-- > 0) {
                VirusStatus current = heap.poll();
                if (infect(current.x + 1, current.y, current.id)) {
                    heap.add(new VirusStatus(current.x + 1, current.y, current.id, current.time + 1));
                }
                if (infect(current.x - 1, current.y, current.id)) {
                    heap.add(new VirusStatus(current.x - 1, current.y, current.id, current.time + 1));
                }
                if (infect(current.x, current.y + 1, current.id)) {
                    heap.add(new VirusStatus(current.x, current.y + 1, current.id, current.time + 1));
                }
                if (infect(current.x, current.y - 1, current.id)) {
                    heap.add(new VirusStatus(current.x, current.y - 1, current.id, current.time + 1));
                }
            }
        }

        bw.write(String.valueOf(map[X][Y]));
        bw.flush();
    }
}
