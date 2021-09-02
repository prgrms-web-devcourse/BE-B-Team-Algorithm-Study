package boj.q13567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int boxSize = Integer.parseInt(init[0]);
        int count = Integer.parseInt(init[1]);

        int robotX = 0;
        int robotY = 0;
        // [0, 1]: east, [-1, 0]: south, [0, -1]: west, [1, 0]: north
        int[][] robotDirection = new int[][] { new int[] { 0, 1 }, new int[] { -1, 0 }, new int[] { 0, -1 },
                new int[] { 1, 0 } };
        int robotDirectionIndex = 0;

        while (count-- > 0) {
            // when robot position exceeds the map area, halt now.
            if (robotX >= boxSize || robotY >= boxSize || robotX < 0 || robotY < 0) {
                System.out.println("-1");
                return;
            }

            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "MOVE":
                    int tick = Integer.parseInt(command[1]);
                    while (tick-- > 0) {
                        robotX += robotDirection[robotDirectionIndex][0];
                        robotY += robotDirection[robotDirectionIndex][1];
                    }
                    break;

                case "TURN":
                    int direction = Integer.parseInt(command[1]);
                    if (direction == 1) {
                        robotDirectionIndex = (robotDirectionIndex + 1) % 4;
                    } else {
                        robotDirectionIndex = (robotDirectionIndex - 1 + 4) % 4;
                    }
                    break;
            }
        }

        if (robotX >= boxSize || robotY >= boxSize || robotX < 0 || robotY < 0) {
            System.out.println("-1");
        } else {
            System.out.printf("%d %d%n", robotY, robotX);
        }
    }
}
