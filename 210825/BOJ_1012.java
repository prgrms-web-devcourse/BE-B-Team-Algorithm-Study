import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int T,N,M,K;
    static boolean[][] m;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] vi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){ // 테스크 개수만큼(T가 0보다 클때까지 반복문 실행)
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            m = new boolean[N][M]; // 테케마다 2차원 배열 생성
            vi = new boolean[N][M]; // 테케마다 2차원 배열 생성

            int x,y;
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken()); // x축 위치
                y = Integer.parseInt(st.nextToken()); // y축 위치
                m[y][x] = true; // 배추 있으면 true
            }

            int ans = 0; // 필요한 총 지렁이 개수
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(!m[i][j] || vi[i][j]) continue; // 배추가 없거나 이미 방문한 배추는 다시 탐색할 필요가 없으므로 넘김
                    bfs(i,j); // 탐색안한 배추의 (x,y)위치 : (i,j)로부터 bfs수행
                    ans ++; // 벌레개수 + 1
                }
            }

            bw.write(ans+"\n"); // 벌레개수 bw에 저장
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int sty, int stx){ // sty : 시작 y좌표, stx : 시작 x좌표
        Queue<Point> q = new LinkedList<>(); // 큐
        q.add(new Point(sty,stx)); // Point객체 큐에 삽입

        while(!q.isEmpty()){ // 큐에 원소가 없어질때까지 계속 탐색
            Point pt = q.poll(); // 맨 앞 원소 pop
            int cy = pt.y; // 현재 y축 좌표
            int cx = pt.x; // 현재 x출 좌표
            
            for(int i=0; i<4; i++){ // 현재 좌표로 부터 인접한 4개의 좌표 탐색 
                int ny = cy + dy[i]; // 다음 y좌표
                int nx = cx + dx[i]; // 다음 x좌표
                // 좌표범위 벗어나거나, 이미방문했거나, 배추가 없는 좌표는 Continue
                if(ny<0 || nx<0 || ny>=N || nx>=M || vi[ny][nx] || !m[ny][nx]) continue;
                q.add(new Point(ny,nx)); // 조건을 만족하는 좌표 큐에 삽입
                vi[ny][nx] = true; // 방문처리
            }
        }
    }
    // 좌표 클래스
    static class Point{
        int y=0;
        int x=0;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
