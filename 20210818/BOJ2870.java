package bjon2870;
//https://par3k.tistory.com/86

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> answer = new ArrayList<>();
        String[] line;

        for(int i=0;i<N;i++) {
            line = br.readLine().split("\\D");
            for(int j=0;j<line.length;j++) {
                if(!line[j].equals("")) answer.add(new BigInteger(line[j]));
            }
        }
        Collections.sort(answer);

        for(int i=0;i<answer.size();i++) {
            System.out.println(answer.get(i));
        }

    }
}
