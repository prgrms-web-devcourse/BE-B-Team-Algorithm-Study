package boj.q19940;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static boolean[] clicked = new boolean[61];
    private static Deque<OvenStatus> queue = new LinkedList<>();
    private static OvenStatus answer;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());
        while (test-- > 0) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            Arrays.fill(clicked, false);
            queue.clear();
            answer = null;

            int[] initDial = new int[5];
            while (target >= 60) {
                int count = target / 60;
                target %= 60;
                initDial[0] += count;
            }

            queue.add(new OvenStatus(0, initDial));
            int dialThreshold = Integer.MAX_VALUE;

            OvenStatus current;
            while (!queue.isEmpty()) {
                current = queue.pop();
                if (current.time > 60)
                    continue;

                if (current.time == target && current.getTries() <= dialThreshold) {
                    if (answer == null || current.compareTo(answer) < 0) {
                        answer = current;
                    }
                    dialThreshold = Math.min(dialThreshold, current.getTries());
                    continue;
                }

                if (clicked[current.time] || current.time < 0 || current.getTries() > dialThreshold)
                    continue;

                clicked[current.time] = true;

                if (current.time + 60 > 0) {
                    int[] newDial = Arrays.copyOf(current.dial, current.dial.length);
                    newDial[0]++;
                    queue.add(new OvenStatus(current.time + 60, newDial));
                }

                if (current.time + 10 > 0) {
                    int[] newDial = Arrays.copyOf(current.dial, current.dial.length);
                    newDial[1]++;
                    queue.add(new OvenStatus(current.time + 10, newDial));
                }

                if (current.time - 10 > 0) {
                    int[] newDial = Arrays.copyOf(current.dial, current.dial.length);
                    newDial[2]++;
                    queue.add(new OvenStatus(current.time - 10, newDial));
                }

                if (current.time + 1 > 0) {
                    int[] newDial = Arrays.copyOf(current.dial, current.dial.length);
                    newDial[3]++;
                    queue.add(new OvenStatus(current.time + 1, newDial));
                }
                if (current.time - 1 > 0) {
                    int[] newDial = Arrays.copyOf(current.dial, current.dial.length);
                    newDial[4]++;
                    queue.add(new OvenStatus(current.time - 1, newDial));
                }
            }

            bw.write(answer.printDial());
        }
        bw.flush();
    }

}

class OvenStatus implements Comparable<OvenStatus> {
    int[] dial;
    int time;

    public OvenStatus(int time, int[] dial) {
        this.time = time;
        this.dial = dial;
    }

    @Override
    public int compareTo(OvenStatus o) {
        return (10000 * dial[0] + 1000 * dial[1] + 100 * dial[2] + 10 * dial[3] + dial[4])
                - (10000 * o.dial[0] + 1000 * o.dial[1] + 100 * o.dial[2] + 10 * o.dial[3] + o.dial[4]);
    }

    public int getTries() {
        return dial[0] + dial[1] + dial[2] + dial[3] + dial[4];
    }

    public String printDial() {
        return String.format("%s %s %s %s %s%n", dial[0], dial[1], dial[2], dial[3], dial[4]);
    }
}