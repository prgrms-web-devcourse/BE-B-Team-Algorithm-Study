import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static int[] arr = new int[9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        func(0, 1);

        System.out.println(sb);  // BufferedWriter를 사용하는것이 좋음, BufferedWriter를 알기전 코드임
    }

    public static void func(int dpt, int pos){
        if(dpt == M){
             // BufferedWriter를 사용하는것이 좋음, BufferedWriter를 알기전 코드임
            for (int i=0; i<M; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append('\n');
            return;
        }

        // note : pos
        //  - 오름차순으로 나타내기 위해 탐색하고 있는 다음의 수 부터 다음 func의 pos로 탐색.
        //  - 이렇게 하면 항상 탐색하는 수 보다 큰 수가 다음 탐색의 대상이 되므로 방문처리가 필요없음.
        //  - 따라서 구현형태는 dfs와 비슷하지만 단순 백트래킹만 필요로 함
        for(int i=pos; i<=N; i++){
            arr[dpt] = i;
            func(dpt+1, i+1);
        }
    }
}
