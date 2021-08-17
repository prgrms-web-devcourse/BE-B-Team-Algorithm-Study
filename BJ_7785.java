package baekjoon;

import java.util.*;
public class BJ_7785{
    public static void main(String[] args) {
        int N = 0;
        HashMap<String, String> hash=new HashMap<>();
        Scanner in=new Scanner(System.in);
        N=in.nextInt();
        String[][] map=new String[N][2];

        for(int i=0;i<N;i++) {
            map[i][0]=in.next();
            map[i][1]=in.next();
            hash.put(map[i][0],map[i][1]);
        }

        ArrayList<String> arr=new ArrayList<>();

        for(String str: hash.keySet())
            if(hash.get(str).equals("enter")) arr.add(str);


        Collections.sort(arr, Collections.reverseOrder());


        for(String str:arr)
            System.out.println(str);
    }

}