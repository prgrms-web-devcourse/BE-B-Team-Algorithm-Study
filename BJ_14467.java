package baekjoon;

import java.util.*;

public class BJ_14467 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;

        for(int i=0; i<101; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++){
            int num = scanner.nextInt();
            int dir = scanner.nextInt();

            list.get(num).add(dir);
        }

        for(int i=0; i<101; i++){
            if(!(list.get(i).size() <= 1)){
                int k = list.get(i).get(0);
                for(int j=1; j<list.get(i).size(); j++){
                    if(k != list.get(i).get(j)){
                        k = list.get(i).get(j);
                        sum++;
                    }
                }
            }
        }

        System.out.print(sum);
    }
}