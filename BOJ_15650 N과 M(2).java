import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15650 {
    static int[] arr = null;  // 수열을 해당 길이만큼 담을 리스트 선언
    static int N, M = 0;    // N과 M을 저장할 변수 선언
    static StringBuilder sb = new StringBuilder();  // 문자열 저장을 위한 빌더 생성

    public static void main(String[] args) throws IOException { // IO입출력을 위한 예외처리 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // Scanner 대신 BufferedReader 사용
        StringTokenizer st = new StringTokenizer(br.readLine());    //들어온 입력값을 구분자로 구분(기본 delimiter는 공백 문자들인 " \t\n\r\t"입니다. )

        N = Integer.parseInt(st.nextToken());   // nextToken()으로 N에 정수로 담기
        M = Integer.parseInt(st.nextToken());   // nextToken()으로 M에 정수로 담기

        arr = new int[M];   // 배열 M 길이 선언
        dfs(1, 0); // dfs 메소드 시작
        System.out.println(sb); // stringbuilder 담은거 전부 출력
    }

    private static void dfs(int at, int depth) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' '); // 하나씩 출력
            }
            sb.append('\n');    // 구분
            return;
        }

        for (int i = at; i <= N; i++) {     // 1부터 N까지 수열을 늘림
            arr[depth] = i;
            dfs(i + 1, depth + 1);  // 재귀함수로 depth 아래로 그래프 내려가기
        }
    }
}
