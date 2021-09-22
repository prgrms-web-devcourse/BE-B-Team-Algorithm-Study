import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, ans=0;
    static Pii[] m;
    static boolean[] vi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        m = new Pii[N];
        vi = new boolean[N+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            m[i] = new Pii(a,b);
        }

        dfs(0);

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int dpt){
        if(vi[dpt]) { // 예외처리
            dfs(dpt+1);
            return;
        }
        if(dpt==N) {
            int res = 0;
            for(int i=0; i<N; i++){
                if(vi[i]) res++;
            }
            ans = Math.max(ans, res);
            return;
        }

        int curDmg = m[dpt].dmg;
        for(int i=0; i<=N; i++){
            if(i==N) {dfs(N); continue;} // 예외처리
            if(i==dpt || vi[i]) continue;
            int nextDmg = m[i].dmg;

            m[i].hp -= curDmg;
            m[dpt].hp -= nextDmg;
            if(m[i].hp<=0) vi[i] = true;
            if(m[dpt].hp<=0) vi[dpt] = true;
            dfs(dpt+1);
            // 백트래킹
            m[dpt].hp += nextDmg;
            m[i].hp += curDmg;
            if(m[dpt].hp>0) vi[dpt] = false;
            if(m[i].hp>0) vi[i] = false;
        }

    }

    static class Pii{
        int hp, dmg;

        public Pii(int hp, int dmg) {
            this.hp = hp;
            this.dmg = dmg;
        }
    }

}
