package day1;
// https://www.acmicpc.net/problem/14467
import java.util.Arrays;
import java.util.Scanner;

public class BOJ14467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ansewer =0;
        int all = sc.nextInt();
        int[] cow = new int[11];
        Arrays.fill(cow,-1);
        int key; int cross;

        for(int i=0;i<all;i++) {
            key = sc.nextInt();
            cross = sc.nextInt();

            if(cow[key]==-1) cow[key] = cross;
            else if(cow[key] != cross){
                ansewer += 1;
                cow[key] = cross;
            }
        }
        System.out.println(ansewer);


    }
}
