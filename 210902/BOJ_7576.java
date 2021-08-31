import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static int[][] m;
    static boolean[][] vi;
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringTokenizer st = new StringTokenizer(br.readLine());;

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Queue<Tiii> q = new ArrayDeque<>();
        m = new int[N][M];
        vi = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());;
            for(int j=0; j<M; j++){
                m[i][j] = Integer.parseInt(st.nextToken());
                if(m[i][j]==1) { // 익은 토마토 큐에 삽입
                    q.add(new Tiii(0, i, j));
                    vi[i][j] = true;
                }
            }
        }

        int ans = 0;
        while (!q.isEmpty()) { // bfs
            Tiii poll = q.poll();
            int cd = poll.d;
            int cy = poll.y;
            int cx = poll.x;

            ans = Math.max(ans, cd);

            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny<0 || nx<0 || ny>=N || nx>=M || vi[ny][nx] || m[ny][nx]==-1) continue;
                q.add(new Tiii(cd + 1, ny, nx));
                vi[ny][nx] = true;
            }
        }

        int res = ans;
        for(int i=0; i<N; i++){ // 익지않은 토마토 검사
            for(int j=0; j<M; j++){
                if(m[i][j]==-1) continue;
                if(!vi[i][j]) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Tiii{ // 시간, y좌표, x좌표
        int d,y,x;

        public Tiii(int d, int y, int x) {
            this.d = d;
            this.y = y;
            this.x = x;
        }
    }

}
