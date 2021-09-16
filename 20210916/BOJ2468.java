import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2468
// 18476KB	252ms
public class BOJ2468 {

    static int[][] map;
    static int N;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine()); // 행,열의 수
        int max = 0;
        map = new int[N+1][N+1];

        for (int i = 0; i < N; i++) {  // 입력값을 통해 각 영역 높이를 배열로 표현
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);   // 가장 높은 영역의 높이 |편리하다
            }
        }



        int ans = 0;



        for (int sea = 1; sea <= max; sea++) {  // 1부터 가장 높은 높이 까지 물이 차오르는 조건 설정
            visit = new boolean[N + 1][N + 1];  // 방문처리를 위한 배열
            int cnt = 0;
            for (int x = 0; x < N; x++) {
                for (int y =0; y < N; y++) {
                    if(map[x][y]>sea && !visit[x][y]){   // 방문을 하지 않았거나 해수면보다 높은 영역 탐색
                        cnt++;   // 해당 해수면 높이에 따른 영역 개수 => 재귀함수를 돌면서 상하좌우로 연결된 노드들은 하나로 카운트
                        dfs(sea,x,y);  // 해수면 높이, map 좌표
                    }
                }
            }
            //System.out.println(cnt);
            ans = Math.max(ans, cnt);   // 여러 해수면 높이중 가장 높은 영역 횟수 구하기
        }

        System.out.println(ans==0 ? 1:ans);  // 아무 지역도 물에 잠기지 않을수 있다가 밑에 조그만하게 적혀있었음 / 람다식 한번 써봄
    }
   static void dfs(int sea, int x, int y) {
       visit[x][y] =true;  // 방문처리

       for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];  // 좌우
            int ny = y + dy[i];  // 상하

           //기준 좌표에서 상하좌우에 있는 노드 탐색
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {  // 좌표 평면을 벗어나지 않는 노드
                if(!visit[nx][ny] && map[nx][ny]>sea){  // 방문한적 없고 해수면 높이보다 높은 노드
                    dfs(sea,nx,ny);  // 재귀 호출 => 위의 조건을 만족하는 상하좌우의 노드들을 계속해서 탐색
                }

            }
        }

    }


}

