package baekjoon;

import java.util.*;
/*
 * 비밀번호 발음하기
 *
 * 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
 * 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
 * 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
 *
 * */
public class BJ_4659 {
    static final char[] vowels = {'a' ,'e' ,'i' ,'o' , 'u'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String word = sc.nextLine();
            StringBuilder ans = new StringBuilder("");

            if(word.equals("end")) break;

            ans.append("<").append(word).append("> ");

            if(!check(word)) {
                ans.append("is not acceptable.");
            }else {
                ans.append("is acceptable.");
            }
            System.out.println(ans.toString());
        }
    }

    private static boolean check(String word) {
        boolean hasVowel = false;
        int vowel = 0, consonant = 0;
        char pre = ' ';
        for(int i =0, l = word.length(); i<l; i++) {
            boolean isVowel = false;
            // 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
            for(int j = 0 ; j < 5 ; j++) {
                if(vowels[j]==word.charAt(i)) {
                    isVowel = true;         //  현재 모음임을 표시
                    hasVowel = true;        //  모음을 포함함을 표시
                    break;
                }
            }
            // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
            if(isVowel) { // 모음인 경우
                vowel++;
                consonant = 0;
            }else {      // 자음인 경우
                consonant++;
                vowel = 0;
            }
            if(vowel>=3 || consonant>=3) return false;

            // 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
            if(pre == word.charAt(i)&& pre != 'e' && pre != 'o') return false;
            pre = word.charAt(i);
        }
        if(hasVowel)return true;
        return false;
    }

}