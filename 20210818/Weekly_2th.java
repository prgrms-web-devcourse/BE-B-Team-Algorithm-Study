package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/**
 * 코딩테스트 연습 https://programmers.co.kr/learn/courses/30/lessons/83201?language=java
 * 위클리 챌린지
 * 2주차
 */
public class Weekly_2th {

    public static boolean isSameNumber(List<Integer> personScore, int num) {
        int cnt = 1;

        for (int i = 0; i < personScore.size(); i++) {

            if (personScore.get(i) == num) {
                if (cnt >= 2) {
                    return true;
                }
                cnt++;
            }

        }
        return false;
    }

    public static OptionalInt findMaxNumberIndex(List<Integer> personScore, int num) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < personScore.size(); i++) {
            if (personScore.get(i) > max) {
                max = personScore.get(i);
                index = i;
            }
        }

        if (personScore.get(num) != max) {
            return OptionalInt.empty();
        }

        boolean result = isSameNumber(personScore, max);
        if (!result) {
            return OptionalInt.of(index);
        }
        return OptionalInt.empty();
    }

    public static OptionalInt findMinNumberIndex(List<Integer> personScore, int num) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < personScore.size(); i++) {
            if (min > personScore.get(i)) {
                min = personScore.get(i);
                index = i;
            }
        }

        if (personScore.get(num) != min) {
            return OptionalInt.empty();
        }

        boolean result = isSameNumber(personScore, min);
        if (!result) {
            return OptionalInt.of(index);
        }
        return OptionalInt.empty();
    }

    public static String classifyGrade(float avg) {
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public String solution(int[][] scores) {

        float[] avg = new float[scores.length];

        for (int i = 0; i < scores[0].length; i++) {
            List<Integer> personScore = new ArrayList<>();
            for (int j = 0; j < scores.length; j++) {
                int score = scores[j][i];
                personScore.add(score);
            }

            OptionalInt maxIndex = findMaxNumberIndex(personScore, i);
            OptionalInt minIndex = findMinNumberIndex(personScore, i);

            if (maxIndex.isPresent()) {
                personScore.remove(maxIndex.getAsInt());
            }
            if (minIndex.isPresent()) {
                personScore.remove(minIndex.getAsInt());
            }

            int sum = 0;
            for (int j = 0; j < personScore.size(); j++) {
                sum += personScore.get(j);
            }
            avg[i] = (float) sum / (float) personScore.size();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < avg.length; i++) {
            String grade = classifyGrade(avg[i]);
            sb.append(grade);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        //int score[][] = {{50, 90}, {50, 87}};
        //int score[][] = {{70, 49, 90}, {68, 50, 38}, {73, 31, 100}};
        int score[][] =
                {{100, 90, 98, 88, 65},
                        {50, 45, 99, 85, 77},
                        {47, 88, 95, 80, 67},
                        {61, 57, 100, 80, 65},
                        {24, 90, 94, 75, 65}};
        Weekly_2th solution14 = new Weekly_2th();
        String result = solution14.solution(score);
        System.out.println(result);
    }
}
