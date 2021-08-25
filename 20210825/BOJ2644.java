import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2644 {

    static int num;
    static int start,end;
    static List<Integer>[] graph;
    static boolean[] visit;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        num = Integer.parseInt(br.readLine());  // 총 인구 받기
        st = new StringTokenizer(br.readLine());  //2번째 입력값 나누기
        start = Integer.parseInt(st.nextToken()); // 첫째 사람
        end = Integer.parseInt(st.nextToken()); // 둘째 사람
        int M = Integer.parseInt(br.readLine()); // 총 촌수 관계 숫자 받기


        graph = new ArrayList[num+1]; // 사람 리스트 만들기 -> 0을 제외하기 위해 (num+1)
        for(int i=1;i<=num;i++){   // i=1 -> 0인 사람이 없기 때문에
            graph[i]=new ArrayList<>(); //   사람 별 리스트 생성
        }


        for(int i=0;i<M;i++) {  // 각 해당 사람에 대한 관계있는 사람들 리스트 주입
            st=new StringTokenizer(br.readLine());
            int parents=Integer.parseInt(st.nextToken());
            int child=Integer.parseInt(st.nextToken());
            graph[parents].add(child);
            graph[child].add(parents);
        }
        System.out.println(Bfs(start,end));

    }

    private static int Bfs(int start, int end) {  //너비 우선 탐색 사용 (BFS)
        int answer=0;
        visit = new boolean[num+1];  // 방문 여부 리스트 (dafualt : false 로 생성)
        queue = new LinkedList<Integer>();  // 연결된 노드

        visit[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){  // 기준 노드에서 연결된 노드 방문 반복문
                int now = queue.poll();
                if (now == end)
                    return answer;

                for (int next : graph[now]) {
                    if (!visit[next]) {    // 해당 노드가 false이면 (방문한 적이 없으면)
                        queue.offer(next);  // 연결 노드 queue에 삽입
                        visit[next] = true;
                    }
                }
            }

            answer++;
        }


        return -1;  // start 와 end 가 연결되지 않았을 경우
    }
}
