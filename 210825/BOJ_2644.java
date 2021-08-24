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
    static int N,M,A,B;
    static ArrayList<ArrayList<Integer>> adj; // 인접 리스트
    static boolean[] vi; // 방문처리하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 사람 수 (=노드 개수)
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); // 촌수를 계산해야 하는 사람 A
        B = Integer.parseInt(st.nextToken()); // 촌수를 계산해야 하는 사람 B
        M = Integer.parseInt(br.readLine()); // 부모자식 관계 수 (=간선 개수)

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

        bw.write(bfs(A,B)+""); // bfs 메소드의 반환값 출력
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int A, int B){
        Queue<Pair> q = new ArrayDeque<>(); // 데이터가 많아지면 LinkedList 보다 더 빠르다고 함
        q.add(new Pair(A,0)); // bfs 시작노드 X로 부터 시작
        vi[A] = true; // 방문처리

        while(!q.isEmpty()){ // q가 빌때까지 계속 수행
            Pair poll = q.poll(); // pop
            int cn = poll.node; // current node
            int cd = poll.dist; // current distance
            
            if(cn == B) return cd; // 탐색도중 B노드를 발견하면 거리 반환
            
            for (int next : adj.get(cn)) { // cn과 연결된 노드들 탐색
                if(vi[next]) continue; // 방문했으면 넘김
                q.add(new Pair(next, cd+1)); // next는 cn과 연결된 다음노드 이므로 (next노드, 현재거리+1)로 삽입
                vi[next] = true; // 삽입한 노드 방문처리
            }
        }
        // 친척 관계가 없으면 -> 즉, A로부터 시작하여 B를 발견하지 못하면 -1 반환
        return -1;
    }

    static class Pair{
        int node = 0; // 현재 노드 번호
        int dist = 0; // X로 부터의 거리

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

}
