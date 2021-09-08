import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N, T;
    static boolean[] vi; // 0~60분 방문처리할 배열
    static int[] dt = {-1, 1, -10, 10, 60};
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while(T-- >0){
            N = Integer.parseInt(br.readLine());
            vi = new boolean[61];
            // 버튼을 누른횟수가 같을때 ADDH부터 MINO까지의 순서로 개수가 작을 수록 높은 우선순위를 가짐
            // 따라서 dt = {-1, 1, -10, 10, 60}순서로 bfs탐색을 하면 최적의 조건으로 탐색을 할 수 있음
            // 즉, N분을 방문했을때의 ADDH~MINO까지의 버튼 개수가 정답으로 출력될 수 있음

            int addh = N/60; 
            // +60이 가장 큰 이동거리이므로 60을 주기라고 볼 수 있음
            // 따라서 60보다 큰 수라면 +60으로 탐색하는것이 항상 버튼개수가 가장 적은, 최적의 이동경로라고 볼 수 있음
            
            N%=60;
            // N을 60으로 나눈 나머지의 분위치까지, 가기위해 필요한 버튼의 최소의 개수를 bfs를 이용하여 구해낼 수 있음
            bfs(N, addh);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int ed, int addh) throws IOException {
        Queue<Btn> q = new ArrayDeque<>();
        q.add(new Btn(0,0,0,0,0,0,0));
        vi[0] = true;

        while (!q.isEmpty()) {
            Btn poll = q.poll();
            if(poll.cp == ed) {
                poll.b4 += addh;
                bw.write(poll.b4+" "+poll.b3+" "+poll.b2+" "+poll.b1+" "+poll.b0 + '\n');
                break;
            }

            for(int i=0; i<5; i++){
                int np = poll.cp + dt[i];
                if(np<0 || np>60) continue; // 위의 코드에서 탐색할 범위를 줄였기 때문에 해당 범위만 탐색하면 됨
                if(vi[np]) continue;
                Btn next = new Btn(np,poll.cd+1, poll.b0, poll.b1, poll.b2, poll.b3, poll.b4);
                
                // 누른 버튼에 해당하는 변수 +1해줌
                if(i==0) next.b0 += 1;
                else if(i==1) next.b1 += 1;
                else if(i==2) next.b2 += 1;
                else if(i==3) next.b3 += 1;
                else next.b4 += 1;

                q.add(next);
                vi[next.cp] = true;
            }
        }
    }

    static class Btn{
        int cp,cd,b0,b1,b2,b3,b4; // 본문이랑 순서 반대로 저장했음 b4가 addh임

        public Btn(int cp, int cd, int b0, int b1, int b2, int b3, int b4) {
            this.cp = cp;
            this.cd = cd;
            this.b0 = b0;
            this.b1 = b1;
            this.b2 = b2;
            this.b3 = b3;
            this.b4 = b4;
        }
    }
}
