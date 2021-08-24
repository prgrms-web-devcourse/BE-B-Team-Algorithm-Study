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
        
        // 15650코드와 아래 for문만 다름
        for(int i=1; i<=N; i++){
            arr[dpt] = i;
            func(dpt+1, i);
        }
    }
}
