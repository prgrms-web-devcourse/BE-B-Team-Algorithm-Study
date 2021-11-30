import java.io.*;

public class BOJ19940 {

    static int N,M;
    static int sixty, ten, one;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());  // 반복 횟수



        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());  // 입력값
            answer = new int[5];  // 정답 배열 => +60 , +10, -10, +1, -1

            sixty = M / 60;
            ten = (M % 60) / 10;
            one = M % 10;

            if(one >5){
                ten += 1;
                one -= 10;
            }

            if (ten > 3) {
                sixty += 1;
                ten -= 6;
            }
            if (one == 5 && ten<0) {   // 45, 55의 예외적인 경우
                ten += 1;
                one -= 10;
            }


            answer[0] = sixty;
            if(ten>0) answer[1] = ten;
            if(ten<0) answer[2] = Math.abs(ten);
            if(one>0) answer[3] = one;
            if(one<0) answer[4] = Math.abs(one);

            for(int j = 0 ; j < 5 ; j++) bw.write(answer[j] + " ");
            bw.write("\n");
            bw.flush();


        }








    }
}
