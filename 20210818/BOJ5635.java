package day1.birthday;


import java.io.IOException;
import java.util.Scanner;


class BOJ5635 {
    public static void main(String[] args) throws IOException {


        Scanner scan = new Scanner(System.in);

        int nums = Integer.parseInt(scan.nextLine());

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        String minNA = "";
        String maxNA = "";

        for(int i=0;i<nums;i++) {
            String exNa = scan.next();
            int day = 0;
            day += Integer.parseInt(scan.next());
            day += Integer.parseInt(scan.next())* 100;
            day += Integer.parseInt(scan.next()) * 10000;


            if(min<day) {
                min = day;
                minNA = exNa;
            }
            else if (max>day) {
                max = day;
                maxNA = exNa;
            }
        }

        System.out.println(minNA);
        System.out.println(maxNA);

        }
}
