import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] m;
    static boolean[][] vi;
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        m = new int[N+1][N+1];
        vi = new boolean[N+1][N+1];

        int M = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                m[i][j] = Integer.parseInt(st.nextToken());
                M = Math.max(M, m[i][j]);
            }
        }

        int maxArea = 1;
        for(int k=1; k<=M; k++){
            vi = new boolean[N+1][N+1];
            int curArea = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(vi[i][j] || m[i][j]<=k) continue;
                    bfs(i, j, k);
                    curArea++;
                }
            }
            maxArea = Math.max(maxArea, curArea);
        }

        bw.write(maxArea+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x, int k){
        Queue<Pii> q = new ArrayDeque<>();
        q.add(new Pii(y,x));
        vi[y][x] = true;

        while(!q.isEmpty()){
            Pii poll = q.poll();
            int cy = poll.y;
            int cx = poll.x;

            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny<0 || nx<0 || ny>=N || nx>=N || vi[ny][nx] || m[ny][nx]<=k) continue;
                q.add(new Pii(ny,nx));
                vi[ny][nx] = true;
            }
        }
    }

    static class Pii{
        int y,x;

        public Pii(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
