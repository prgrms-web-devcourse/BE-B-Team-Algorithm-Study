import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ArrayList<String> arr = new ArrayList<>();
        String str;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            str += ".";
            int start = -1;
            for(int k=0; k<str.length(); k++){
                if(chkNum(str.charAt(k))){
                    if(start==-1 && str.charAt(k)!='0') start = k;
                } else {
                    if(k==0) continue;
                    if(chkNum(str.charAt(k-1))){
                        if(start==-1) arr.add("0");
                        else arr.add(str.substring(start, k));
                        start = -1;
                    }
                }

            }
        }

        Collections.sort(arr, (a, b) -> {
            if(a.length()==b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<arr.size(); i++) {
            ans.append(arr.get(i));
            ans.append('\n');
        }

        System.out.print(ans);
    }

    static boolean chkNum(char ch){
        if(ch>='0' && ch<='9') return true;
        else return false;
    }
}