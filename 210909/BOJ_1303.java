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
    static char[][] m;
    static boolean[][] vi;
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        vi = new boolean[N][M];
        m = new char[N][M];
        for(int i=0; i<N; i++){
            m[i] = br.readLine().toCharArray();
        }

        int whiteSum=0, blueSum=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(vi[i][j]) continue;
                if(m[i][j]=='W') whiteSum += bfs(i,j);
                else blueSum += bfs(i,j);
            }
        }

        bw.write(whiteSum+" "+blueSum);
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int sty, int stx){
        Queue<Pii> q = new ArrayDeque<>();
        q.add(new Pii(sty,stx));
        vi[sty][stx] = true;

        int ret = 1;
        while (!q.isEmpty()){
            Pii poll = q.poll();
            int cy = poll.y;
            int cx = poll.x;

            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny<0 || nx<0 || ny>=N || nx>=M || vi[ny][nx] || m[ny][nx]!=m[sty][stx]) continue;
                q.add(new Pii(ny,nx));
                vi[ny][nx] = true;
                ret++;
            }
        }

        return ret*ret;
    }

    static class Pii{
        int y,x;

        public Pii(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
