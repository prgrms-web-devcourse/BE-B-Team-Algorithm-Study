package bjon4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp;

        while(!(tmp=br.readLine()).equals(("end"))){

            if(total(tmp))
                System.out.println("<"+tmp+">"+" is acceptable.");
            else
                System.out.println("<"+tmp+">"+" is not acceptable.");


        }
    }
    static boolean total(String tmp){
        if(rule_vowel(tmp)){
            if(rule_chain(tmp)){
                if(rule_same(tmp))
                    return true;
            }
        }
        return false;
    }

    static boolean rule_vowel_ch(char ch) {
        if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        return false;
    }


    static boolean rule_vowel(String tmp) {

        for(int i=0;i<tmp.length();i++) {
            if(rule_vowel_ch(tmp.charAt(i)))
                return true;
        }
        return false;
    }

    static boolean rule_chain(String tmp) {
        int mcnt =0; int jcnt=0;
        for(int i=0;i<tmp.length();i++) {
            if(rule_vowel_ch(tmp.charAt(i))) {
                mcnt++;
                jcnt = 0;
            }
            else {
                jcnt++;
                mcnt = 0;
            }
            if(mcnt==3 || jcnt==3)
                return false;
        }
        return true;

    }

    static boolean rule_same(String tmp) {
        if(tmp.length()>1){
            for(int i=0; i<tmp.length()-1;i++){
                if(tmp.charAt(i)==tmp.charAt(i+1)){
                    if(tmp.charAt(i)!='e'&& tmp.charAt(i)!='o')
                        return false;
                }
            }
        }
        return true;
    }
}
