package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ_13567 {

    int mapSize, cmdCnt, curX, curY, dir;
    int dx[] = { 1, 0, -1, 0 }, dy[] = { 0, 1, 0, -1 };

    void solve() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            mapSize = Integer.parseInt(st.nextToken());
            cmdCnt = Integer.parseInt(st.nextToken());
            for (int i = 0; i < cmdCnt; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int dis = Integer.parseInt(st.nextToken());
                if (cmd.equals("MOVE")) {
                    curX += dx[dir] * dis;
                    curY += dy[dir] * dis;
                } else if (cmd.equals("TURN")) {
                    if (dis == 0) dir = (dir + 1) % 4;
                    else dir = (dir + 3) % 4;
                }
                if (curX < 0 || curX >= mapSize || curY < 0 || curY >= mapSize) {
                    System.out.println(-1);
                    return;
                }
            }
            System.out.println(curX + " " + curY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BJ_13567().solve();
    }
}