package boj.q6118;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Map<Integer, List<Integer>> roads = new HashMap<>();
    private static int N;
    private static int M;
    private static Deque<int[]> queue = new LinkedList<>();
    private static int[] distance;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            List<Integer> connected = roads.getOrDefault(from, new LinkedList<>());
            connected.add(to);
            roads.put(from, connected);

            connected = roads.getOrDefault(to, new LinkedList<>());
            connected.add(from);
            roads.put(to, connected);
        }

        queue.add(new int[] { 1, 0 }); // node, distance.
        while (!queue.isEmpty()) {
            int[] elem = queue.pop();
            int currentHut = elem[0];
            if (visited[currentHut])
                continue;
            visited[currentHut] = true;

            int hutDistance = elem[1];
            distance[currentHut] = hutDistance;

            List<Integer> connected = roads.getOrDefault(currentHut, new ArrayList<>(0));
            for (Integer hut : connected) {
                queue.add(new int[] { hut, hutDistance + 1 });
            }
        }

        int maxDistance = Integer.MIN_VALUE;
        for (int dist : distance) {
            if (maxDistance < dist)
                maxDistance = dist;
        }

        int highestPriority = -1;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == maxDistance) {
                count++;
                if (highestPriority < 0) {
                    highestPriority = i;
                }
            }
        }

        bw.write(String.format("%d %d %d", highestPriority, maxDistance, count));
        bw.flush();
    }

}
