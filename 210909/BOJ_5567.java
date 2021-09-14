import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] vi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        vi = new int[N+1];
        adj = new ArrayList<>();
        for(int i=0; i<=N; i++) adj.add(new ArrayList<>());

        int a,b;
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b); // 무방향 그래프 이므로
            adj.get(b).add(a); // 무방향 그래프 이므로
        }

        bw.write(bfs()+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        Queue<Pii> q = new ArrayDeque<>();
        q.add(new Pii(1,0));

        int ret = 0; // 반환값
        while (!q.isEmpty()){
            Pii poll = q.poll();
            int cn = poll.n;
            int cd = poll.d;
            if(cd>=2) continue; // 친구의 친구까지만 탐색 -> 친구의 친구이니까 자신으로부터 거리가 2인 노드들만 탐색하면 됨

            for (int next : adj.get(cn)) {
                if(vi[next]!=0 || next==1) continue;
                q.add(new Pii(next, cd+1));
                vi[next] = cd+1;
                ret++; // 결혼식에 초대할 사람 수 ++
            }

        }

        return ret;
    }

    static class Pii{
        int n,d; // node, distance

        public Pii(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
}
