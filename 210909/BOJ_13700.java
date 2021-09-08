import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N, S, D, F, B, K;
    static boolean[] vi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 마포구 건물의 개수 N,
        S = Integer.parseInt(st.nextToken()); // 털린 금은방 S,
        D = Integer.parseInt(st.nextToken()); // 대도 X의 집 D,
        F = Integer.parseInt(st.nextToken()); // 앞으로 한 번에 달릴 수 있는 건물 수 F,
        B = Integer.parseInt(st.nextToken()); // 뒤로 한 번에 달릴 수 있는 건물 수 B,
        K = Integer.parseInt(st.nextToken()); // 마포구 경찰서의 개수 K
        vi = new boolean[N+1];

        if(K>0) { // K가 0인경우 입력값이 주어지지 않으므로 NPE가 발생할 수 있음
            st = new StringTokenizer(br.readLine());
        }
        int t;
        for(int i=0; i<K; i++){
            t = Integer.parseInt(st.nextToken());
            vi[t] = true; // 경찰서는 방문하지 않도록 모두 방문처리함
        }

        int res = bfs(S,D); // 방법이 없으면 -1을 반환하도록 함
        if(res==-1) {
            bw.write("BUG FOUND");
        } else {
            bw.write(res+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // +F, -B
    static int bfs(int st, int ed){
        Queue<Pii> q = new ArrayDeque<>();
        if(!vi[st]) q.add(new Pii(st, 0)); // 시작지점(st)에 경찰서가 있을수도 있음!
        vi[st] = true;

        while (!q.isEmpty()){
            Pii poll = q.poll();
            int cn = poll.cn;
            int cd = poll.cd;

            if(cn == ed) return cd; // 도착지점(집)을 만나면 bfs종료

            int next = cn;
            int nexta = next + F; // 현재위치에서 앞으로 갈 경우
            if(nexta >= 1 && nexta<=N && !vi[nexta]){
                q.add(new Pii(nexta, cd+1));
                vi[nexta] = true;
            }

            int nextb = next - B; // 현재위치에서 뒤로 갈 경우
            if(nextb>=1 && nextb<=N && !vi[nextb]){
                q.add(new Pii(nextb, cd+1));
                vi[nextb] = true;
            }
        }

        return -1;
    }

    static class Pii{
        int cn, cd;

        public Pii(int cn, int cd) {
            this.cn = cn;
            this.cd = cd;
        }
    }
}
