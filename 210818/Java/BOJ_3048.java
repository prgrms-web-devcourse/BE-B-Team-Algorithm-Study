import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static String a,b;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        st = new StringTokenizer(br.readLine());
        b = st.nextToken();
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i=a.length()-1; i>=0; i--) sb.append(a.charAt(i));
        a = sb.toString();

        ArrayList<Ant> arr = new ArrayList<>();
        int tmp = K;
        for(int i=N-1; i>=0; i--){
            arr.add(new Ant(i+tmp, a.charAt(i)));
            if(tmp == 0) continue;
            else tmp--;
        }

        tmp = K;
        for(int i=0; i<M; i++){
            arr.add(new Ant(i+N-tmp, b.charAt(i)));
            if(tmp == 0) continue;
            else tmp--;
        }

        Collections.sort(arr, Comparator.comparingInt(a -> a.pos));

        for (Ant ant : arr) {
            System.out.print(ant.ch);
        }
    }
}

class Ant {
    public int pos;
    public char ch;

    public Ant(int pos, char ch) {
        this.pos = pos;
        this.ch = ch;
    }

}