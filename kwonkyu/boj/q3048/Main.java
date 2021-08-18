package boj.q3048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class AntDirection {
    String antName;
    boolean antDirection; // true: left, false: right

    public AntDirection(String antName, boolean antDirection) {
        this.antName = antName;
        this.antDirection = antDirection;
    }

    @Override
    public boolean equals(Object ant) {
        return this.antDirection == ((AntDirection) ant).antDirection;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int groupASize = Integer.parseInt(init[0]);
        int groupBSize = Integer.parseInt(init[1]);

        List<AntDirection> ants = new ArrayList<>(groupASize + groupBSize);
        String[] groupAAnts = br.readLine().split("");
        String[] groupBAnts = br.readLine().split("");
        int tick = Integer.parseInt(br.readLine());

        for (int index = groupAAnts.length - 1; index >= 0; index--) {
            ants.add(new AntDirection(groupAAnts[index], false));
        }
        for (String ant : groupBAnts) {
            ants.add(new AntDirection(ant, true));
        }

        while (tick-- > 0) {
            AntDirection previous = ants.get(0);
            for (int index = 1; index < ants.size(); index++) {
                AntDirection current = ants.get(index);
                // if (!previous.equals(current)) {
                if (previous.antDirection == false && current.antDirection == true) {
                    AntDirection buffer = current;
                    ants.remove(index);
                    ants.add(index, previous);
                    ants.remove(index - 1);
                    ants.add(index - 1, buffer);
                    index++;
                    if (index < ants.size())
                        previous = ants.get(index);
                } else {
                    previous = current;
                }
            }
        }

        ants.forEach(ant -> System.out.print(ant.antName));
    }
}
