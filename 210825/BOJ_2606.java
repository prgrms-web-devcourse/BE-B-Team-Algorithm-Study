import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static ArrayList<ArrayList<Integer>> adj; // 인접 리스트
    static boolean[] vi; // 방문처리하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 컴퓨터 개수
        M = Integer.parseInt(br.readLine()); // 연결선 개수

        adj = new ArrayList<>();
        for(int i=0; i<=N; i++) adj.add(new ArrayList<>()); // 동적배열로 인접리스트 만듦
        vi = new boolean[N+1];

        int a,b;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b); // a-b 간선 추가
            adj.get(b).add(a); // b-a 간선 추가
        }

        bw.write(bfs(1)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int st){
        Queue<Integer> q = new ArrayDeque<>(); // 데이터가 많아지면 LinkedList보다 더 빠르다고 함
        q.add(st); // bfs 시작노드. 항상1임
        vi[st] = true; // 방문처리

        int ans = 0;
        while(!q.isEmpty()){ // q가 빌때까지 계속 수행
            int cn = q.poll(); // current Node, pop
            for (int next : adj.get(cn)) { // cn과 연결된 노드들 탐색
                if(vi[next]) continue; // 방문했으면 넘김
                q.add(next); // 방문안했으면 큐에 삽입
                vi[next] = true; // 삽입한 노드 방문처리
                ans++; // 1과 연결이 되어 있는 노드이므로 결과에 + 1
            }
        }
        return ans;
    }

}
