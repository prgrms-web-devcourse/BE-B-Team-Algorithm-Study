import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str;
        while(true){
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            if(str.equals("end")) break;

            boolean res = true;
            boolean mo = false;
            for(int i=0; i<str.length(); i++){
                if(chkMo(str.charAt(i))) mo = true;
                if(i<str.length()-1){
                    if(str.charAt(i)==str.charAt(i+1)) {
                        if(str.charAt(i)=='e' || str.charAt(i)=='o');
                        else {
                            res = false;
                            break;
                        }
                    }
                }
                if(i<str.length()-2){
                    boolean x = chkMo(str.charAt(i));
                    boolean y = chkMo(str.charAt(i+1));
                    boolean z = chkMo(str.charAt(i+2));
                    if((x && y && z) || (!x && !y && !z)){
                        res = false;
                        break;
                    }
                }
            }

            if(res==true && mo) System.out.println('<' + str + '>' + " is acceptable.");
            else System.out.println('<' + str + '>' + " is not acceptable.");
        }

    }

    static boolean chkMo(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
        return false;
    }
}