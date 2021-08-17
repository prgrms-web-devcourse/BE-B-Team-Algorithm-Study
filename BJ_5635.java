package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_5635 {

    private String name;
    private String elderName;
    private String olderName;

    private int minDayOfAge,maxDayOfAge=0;
    private int minMonthOfAge,maxMonthOfAge=0;
    private int minYearOfAge,maxYearOfAge =0;


    public static void main(String[] args) throws IOException {

        BJ_5635 main = new BJ_5635();
        main.go();

    }

    public void go() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] info = new int[3];

        st = new StringTokenizer(br.readLine(), " ");

        olderName = st.nextToken();
        elderName = olderName;

        minDayOfAge = Integer.parseInt(st.nextToken());
        minMonthOfAge = Integer.parseInt(st.nextToken());
        minYearOfAge = Integer.parseInt(st.nextToken());

        maxDayOfAge = minDayOfAge;
        maxMonthOfAge = minMonthOfAge;
        maxYearOfAge = minYearOfAge;

        while(n > 1){

            st = new StringTokenizer(br.readLine(), " ");
            name = st.nextToken();

            for(int i=0; i<3; ++i){
                info[i]=Integer.parseInt(st.nextToken());
            }

            elderName = findMinAge(name, info);
            olderName = findMaxAge(name, info);
            n--;
        }

        System.out.println(elderName);
        System.out.println(olderName);

    }
    //나이 어린 사람
    public String findMinAge(String name, int[] info){

        if(minYearOfAge > info[2]){
            return elderName;

        }else if(minYearOfAge == info[2]){
            if(minMonthOfAge > info[1]){
                return elderName;

            }else if(minMonthOfAge == info[1]){
                if(minDayOfAge > info[0]){
                    return elderName;
                }else{
                    changeMinValue(info);
                    return name;
                }
            }else{
                changeMinValue(info);
                return name;
            }
        }else{
            changeMinValue(info);
            return name;
        }
    }

    //나이 많은 사람
    public String findMaxAge(String name, int[] info){

        if(maxYearOfAge < info[2]){
            return olderName;

        }else if(maxYearOfAge == info[2]){
            if(maxMonthOfAge < info[1]){
                return olderName;

            }else if(maxMonthOfAge == info[1]){
                if(maxDayOfAge < info[0]){
                    return olderName;
                }else{
                    changeMaxValue(info);
                    return name;
                }
            }else{
                changeMaxValue(info);
                return name;
            }
        }else{
            changeMaxValue(info);
            return name;
        }
    }

    public void changeMinValue(int[] info){

        this.minYearOfAge =info[2];
        this.minMonthOfAge = info[1];
        this.minDayOfAge =info[0];

    }

    public void changeMaxValue(int[] info){

        this.maxYearOfAge =info[2];
        this.maxMonthOfAge = info[1];
        this.maxDayOfAge =info[0];

    }
}