import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
        String a,b;
        while(N-- >0){
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            if(b.equals("enter")) set.add(a);
            else set.remove(a);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}