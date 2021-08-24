import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static int[] arr = new int[9];
    static boolean[] vi = new boolean[9];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0);

        System.out.println(sb); // BufferedWriter를 사용하는것이 좋음, BufferedWriter를 알기전 코드임
    }

    public static void dfs(int dpt){ // dfs이용
        if(dpt == M){ // 깊이가 M이랑 같을때
             // BufferedWriter를 사용하는것이 좋음, BufferedWriter를 알기전 코드임
            for (int i=0; i<M; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=1; i<=N; i++){
            if(vi[i]) continue;
            vi[i] = true; // 방문처리
            arr[dpt] = i;
            dfs(dpt+1);
            // 백트래킹
            vi[i] = false;
            // arr은 인덱스로 접근하므로 따로 되돌려 주지 않아도 됨
        }
    }
}
