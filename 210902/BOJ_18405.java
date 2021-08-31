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
    static int N, K, S, X, Y;
    static int[][] m;
    static boolean[][] vi;
    static ArrayList<ArrayList<Tiii>> adj; // 바이러스 1~K 의 위치 저장
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringTokenizer st = new StringTokenizer(br.readLine());;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        m = new int[N][N];
        vi = new boolean[N][N];
        adj = new ArrayList<>();
        for(int i=0; i<=K; i++) adj.add(new ArrayList<>());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                m[i][j] = Integer.parseInt(st.nextToken());
                // m[i][j]번 바이러스들의 위치를 adj.get(m[i][j])에 인접리스트 형태로 저장
                if(m[i][j] != 0) adj.get(m[i][j]).add(new Tiii(i,j,0)); // Tiii(y,x,d) : y축좌표, x축좌표, 현재 지난 시간(초)
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        bfs();

        bw.write(m[X-1][Y-1]+""); // 정답 bufferWriter에 저장
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        Queue<Tiii> q = new ArrayDeque<>();
        for(int i=1; i<=K; i++){
            for (Tiii next : adj.get(i)) { // 1번 바이러스들 부터 큐에 순차적으로 저장
                q.add(next);
                vi[next.y][next.x] = true; // 방문처리
            }
        }

        while(!q.isEmpty()){
            Tiii poll = q.poll();
            int cy = poll.y;
            int cx = poll.x;
            int cd = poll.d;

            if(cd == S) continue; // S초일때 답을 구해야 하므로 S초라면 증식 중지

            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny<0 || nx<0 || ny>=N || nx>=N || vi[ny][nx] || m[ny][nx]!=0) continue;
                q.add(new Tiii(ny,nx,cd+1)); // 증식할 수 있으면, 다음 y축과 x좌표 그리고 현재 지난시간(초)를 큐에 저장
                vi[ny][nx] = true;
                m[ny][nx] = m[cy][cx]; // 다음 위치에 바이러스 번호 업데이트
            }
        }
    }

    static class Tiii{ // y축, x축, 지난 시간(초)
        int y,x,d;

        public Tiii(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

}
