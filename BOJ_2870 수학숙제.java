import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       StringBuilder result = new StringBuilder();
       ArrayList<BigInteger> paper = new ArrayList<>(); // 각 줄은 최대 100글자이고, 항상 알파벳 소문자와 숫자로만 이루어져 있다.
       String[] line = null;
       int i, j = 0;
       int n = Integer.parseInt(sc.nextLine());

       for (i = 0; i < n; i++) {
           line = sc.nextLine().split("\\D");
           for (j = 0; j < line.length; j++) {
               System.out.println("- [ " + line[j] + "]");
               if (!line[j].equals(""))
                   paper.add(new BigInteger(line[j]));
           }
       }

       paper.sort(null);
       for (i = 0; i < paper.size(); i++) {
           result.append(paper.get(i)).append("\n");
       }
       System.out.println(result);
       sc.close();
    }
}
