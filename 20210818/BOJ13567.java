package day1.robot;
// https://www.acmicpc.net/problem/13567

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13567 {
    static int M, N;
    static int dx[] = { 1, 0, -1, 0 }; // 동남서북
    static int dy[] = { 0, -1, 0, 1 };



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        String action;
        int num;
        int x=0; int y=0;
        int dir =0;

        for(int i=0; i< N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            action = st2.nextToken();
            num = Integer.parseInt(st2.nextToken());


            if(action.equals("MOVE")) {
                x += dx[dir]*num;
                y += dy[dir]*num;
                if(ifOut(x,y,M)){
                    System.out.println(-1);
                    return;
                }
            }
            else if(action.equals("TURN")) {
                if(num==0){
                    dir = (dir + 4-1)%4;
                }
                else{
                    dir = (dir+1)%4;
                }
            }


        }

        System.out.println(x+" "+y);

    }

    public static boolean ifOut(int x, int y, int m) {
        return x>=m || y>=m || x<0 || y<0;
    }
}
