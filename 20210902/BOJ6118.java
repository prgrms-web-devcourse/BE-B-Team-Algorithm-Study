import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ6118 {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visit;
    static Queue<Integer> queue;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 헛간 개수
        M = Integer.parseInt(st.nextToken()); //  연결 개수

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int a_i, b_i = 0;

        for (int i = 0; i < M; i++) {   // 헛간간의 관계 리스트 생성
            st = new StringTokenizer(br.readLine());
            a_i = Integer.parseInt(st.nextToken());
            b_i = Integer.parseInt(st.nextToken());
            graph[a_i].add(b_i);
            graph[b_i].add(a_i);
        }

        Bfs(1);

    }

    private static void Bfs(int start) {

        visit = new boolean[N + 1];   // 방문 여부 배열
        queue = new LinkedList<Integer>(); // BFS 를 위한 큐
        dist = new int[N+1]; // 0에서 해당 헛간간의 거리 배열

        // 초기화
        visit[start] = true;
        queue.offer(start);
        Arrays.fill(dist, 0);

        //BFs 탐색
        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (int next : graph[now]) {
                if (!visit[next]) {
                    queue.offer(next);
                    visit[next] = true;
                    dist[next] = dist[now] +1;
                }
            }
        }

        int maxPlace = Integer.MIN_VALUE; //숨은 헛간 번호
        int maxDist = Integer.MIN_VALUE; // 숨은 헛간 거리
        int maxNum = 1; // 숨은 헛간과 같은 거리를 갖는 헛간의 개수

        // ditst[] 배열 탐색
        for (int i = 1; i <= N; i++) {
            if (maxDist < dist[i]) {
                maxDist = dist[i];
                maxPlace = i;
                maxNum = 1;
            } else if (maxDist == dist[i]) {
                maxNum++;
            }
        }
        System.out.println(maxPlace + " " + maxDist + " " + maxNum);

    }
}
