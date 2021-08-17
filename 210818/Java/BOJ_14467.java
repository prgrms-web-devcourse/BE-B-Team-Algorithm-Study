import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int m[] = new int[11];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Arrays.fill(m,-1);
        int a,b, res=0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(m[a]==-1) m[a] = b;
            else {
                if(m[a]!=b) {
                    res++;
                    m[a] = b;
                }
            }
        }
        System.out.println(res);
    }
}