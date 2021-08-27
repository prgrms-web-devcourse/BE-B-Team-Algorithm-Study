package boj.q2644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int relations = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> relatives = new HashMap<>();
        while (relations-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            List<Integer> r1Relative = relatives.getOrDefault(r1, new LinkedList<>());
            r1Relative.add(r2);
            relatives.put(r1, r1Relative);

            List<Integer> r2Relative = relatives.getOrDefault(r2, new LinkedList<>());
            r2Relative.add(r1);
            relatives.put(r2, r2Relative);
        }

        List<Integer> start = relatives.getOrDefault(p1, new ArrayList<>(0));
        Deque<int[]> queue = new LinkedList<>();
        start.forEach(r -> queue.add(new int[] { r, 1 })); // other relative, relation count.
        Set<Integer> visited = new HashSet<>();

        int relationCount = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (visited.contains(current[0])) {
                continue;
            } else {
                visited.add(current[0]);
            }

            if (current[0] == p2) {
                relationCount = current[1];
                break;
            }
            List<Integer> myRelatives = relatives.getOrDefault(current[0], new ArrayList<>(0));
            myRelatives.forEach(r -> queue.add(new int[] { r, current[1] + 1 }));
        }

        bw.write(relationCount == 0 ? "-1" : String.valueOf(relationCount));
        bw.flush();
    }
}
