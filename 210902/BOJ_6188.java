import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] vi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringTokenizer st = new StringTokenizer(br.readLine());;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vi = new int[N+1];
        Arrays.fill(vi, -1);
        adj = new ArrayList<>();
        for(int i=0; i<=N; i++) adj.add(new ArrayList<>());

        int a,b;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int resNum = -1;
        int resDist = bfs();
        int resCnt = 0;
        for(int i=1; i<=N; i++){
            if(vi[i]!=resDist) continue;
            if(resNum==-1) resNum = i;
            resCnt++;
        }

        bw.write(resNum + " " + resDist + " " + resCnt);
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        Queue<Pii> q = new ArrayDeque<>();
        q.add(new Pii(1,0));
        vi[1] = 0;

        int dist = 0;
        while (!q.isEmpty()) {
            Pii poll = q.poll();
            int cn = poll.n;
            int cd = poll.d;
            dist = Math.max(dist, cd);

            for (Integer next : adj.get(cn)) {
                if(vi[next]>=0) continue;
                q.add(new Pii(next, cd+1));
                vi[next] = cd+1;
            }
        }
        return dist;
    }

    static class Pii{
        int n,d;

        public Pii(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }

}
