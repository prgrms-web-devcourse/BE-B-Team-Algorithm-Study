package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/13567
 * silver5
 * 로봇
 */

public class BOJ_13567 {
    private static int direction = 0;
    private static int x = 0;
    private static int y = 0;
    private static int squareSize = 0;
    private static boolean checked = false;

    public static void move(int action) {
        // System.out.println("move 실행");
        switch (direction) {
            case 0:
                x += action;
                // System.out.println(x +" "+y);
                break;
            case 1:
                y -= action;
                // System.out.println(x +" "+y);
                break;
            case 2:
                x -= action;
                // System.out.println(x +" "+y);
                break;
            case 3:
                y += action;
                // System.out.println(x +" "+y);
                break;
            default:
                System.out.println("방향 에러 : " + direction);
                break;
        }
    }

    // 동 0, 남 1, 서 2, 북 3
    public static void turn(int change) {
        // System.out.println("turn 실행");
        if (change == 1) {
            direction++;
        } else {
            direction--;
        }

        if (direction > 3) {
            direction = 0;
        } else if (direction < 0) {
            direction = 3;
        }
        // System.out.println("direction : " + direction);
    }

    public static void validationCheck() {
        if (x > squareSize || x < 0) {
            checked = true;
        }
        if (y > squareSize || y < 0) {
            checked = true;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] testCase = input.split(" ");
        squareSize = Integer.parseInt(testCase[0]);
        String[] testString = new String[Integer.parseInt(testCase[1])];
        for (int i = 0; i < testString.length; i++) {
            testString[i] = br.readLine();
        }
        for (int i = 0; i < testString.length; i++) {
            String[] operation = testString[i].split(" ");
            operation[0] = operation[0].toUpperCase();
            if (operation[0].equals("MOVE")) {
                move(Integer.parseInt(operation[1]));
            } else if (operation[0].equals("TURN")) {
                turn(Integer.parseInt(operation[1]));
            }

            validationCheck();
            if (checked) {
                System.out.println(-1);
                break;
            }
        }
        if (!checked) {
            System.out.println(x + " " + y);
        }
    }
}
