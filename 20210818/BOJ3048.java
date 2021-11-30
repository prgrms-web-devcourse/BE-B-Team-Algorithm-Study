package day1.ant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3048 {
    public static void main(String[] args) throws IOException {

        System.out.println("입력 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        char[] ant1 = new char[a1];
        char[] ant2;

        String str = br.readLine();

        for(int i=0;i<a1;i++) {
            ant1[i] = str.charAt(a1-1- i);
        }

        ant2 = br.readLine().toCharArray();

        char[] all_ant = new char[a1 + a2];
        int[] idx = new int[a1 + a2];

        for(int i=0; i<all_ant.length;i++) {
            if(i<a1) {
                all_ant[i] = ant1[i];
                idx[i] = 0;
            }
            else {
                all_ant[i] = ant2[i - a1];
                idx[i] = 1;
            }
        }

        int cnt = Integer.parseInt(br.readLine());
        char tmp;
        int idx_tmp;

        while(cnt>0){
            cnt--;
            for(int i=0;i<all_ant.length-1;i++){
                if(idx[i]==0&&idx[i+1]==1) {
                    tmp = all_ant[i];
                    all_ant[i] = all_ant[i + 1];
                    all_ant[i + 1] = tmp;
                    idx_tmp = idx[i];
                    idx[i] = idx[i + 1];
                    idx[i+1] = idx_tmp;
                    i++;
                }
            }

        }

        for (char c : all_ant) {
            System.out.print(c);
        }

    }
}