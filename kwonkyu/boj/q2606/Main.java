package boj.q2606;

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

    public static void main(String[] args) throws IOException {
        int computers = Integer.parseInt(br.readLine());
        int connects = Integer.parseInt(br.readLine());
        boolean[][] connections = new boolean[computers + 1][computers + 1];

        while (connects-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            connections[c1][c2] = connections[c2][c1] = true;
        }

        int infected = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < connections[1].length; i++) {
            if (connections[1][i])
                queue.add(i);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        while (!queue.isEmpty()) {
            int computer = queue.poll();
            if (visited.contains(computer)) {
                continue;
            } else {
                visited.add(computer);
                infected++;
            }

            for (int i = 0; i < connections[computer].length; i++) {
                if (connections[computer][i])
                    queue.add(i);
            }
        }

        bw.write(String.valueOf(infected));
        bw.flush();
    }
}
