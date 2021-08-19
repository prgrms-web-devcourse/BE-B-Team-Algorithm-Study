import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int cDir = 0;
    static int cy = 0;
    static int cx = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String str = "";
        int t;
        boolean flag = true;
        while(N-- >0 && flag){
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            t = Integer.parseInt(st.nextToken());

            if(str.equals("MOVE")){
                cy += t*dy[cDir];
                cx += t*dx[cDir];
                if(cy<0 || cx<0 || cy>M || cx>M) {
                    System.out.println(-1);
                    flag = false;
                }
            } else {
                if(t==0) cDir = (cDir+1)%4;
                else cDir = (cDir+3)%4;
            }
        }
        if(flag) System.out.println(cx+" "+cy);
    }
}