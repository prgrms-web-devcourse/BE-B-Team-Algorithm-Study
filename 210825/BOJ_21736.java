import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static char[][] m;
    static int sty=0, stx=0;
    static int[] dy = {-1,1,0,0}; // 상하좌우 y좌표
    static int[] dx = {0,0,-1,1}; // 상하좌우 x좌표
    static boolean[][] vi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        m = new char[N][M];
        vi = new boolean[N][M];
        for(int i=0; i<N; i++){
            // String.toCharArray() : 한 Line을 char형 배열로 바로 받아 올 수 있음, i행에 한번에 저장됨
            m[i] = br.readLine().toCharArray(); 
            for(int j=0; j<M; j++){
                if('I' == m[i][j]){ // char형 리터럴 비교이므로 그냥 ==으로
                    sty = i;
                    stx = j;
                }
            }
        }

        int ans = bfs(); // bfs의 결과로 만난 사람수 출력
        if(ans==0) bw.write("TT");
        else bw.write(ans+"");
        bw.flush(); // BufferedWriter 사용시 한번만 호출
        bw.close();
        br.close();
    }

    static int bfs(){
        int ret = 0;
        Queue<Point> q = new LinkedList<>(); // 큐 구현체는 LinkedList보다 ArrayDeque가 더 좋다고 함 
        q.add(new Point(sty,stx));

        while(!q.isEmpty()){
            Point pt = q.poll(); // pop
            int cy = pt.y; // 현재 y좌표
            int cx = pt.x; // 현재 x좌표
            for(int i=0; i<4; i++){ // 4방향 탐색
                int ny = cy + dy[i]; // 다음 y좌표
                int nx = cx + dx[i]; // 다음 x좌표
                // 좌표범위 벗어나거나, 이미 방문한 좌표이거나, 벽(X)이면 넘김
                if(ny<0 || nx<0 || ny>=N || nx>=M || vi[ny][nx] || 'X' == m[ny][nx]) continue;
                if('P' == m[ny][nx]) ret++; // 다음좌표에서 사람만나면 답 + 1
                q.add(new Point(ny,nx)); // 다음좌표 큐에 삽입
                vi[ny][nx] = true; // 다음좌표 방문처리
            }
        }

        return ret; // 만난 사람 수 반환
    }

    static class Point{
        int y=0;
        int x=0;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
