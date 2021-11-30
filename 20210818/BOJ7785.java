package bjon7785;
// https://www.acmicpc.net/problem/7785
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<String> answer = new ArrayList<>();

        Map<String, String> map = new HashMap<>();



        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            map.put(name, state);
        }

        for(String key : map.keySet()) {
            if(map.get(key).equals("enter")) answer.add(key);
        }
        Collections.sort(answer, Collections.reverseOrder());

        for(int i=0; i<answer.size();i++) {
            System.out.println(answer.get(i));
        }

    }
}
