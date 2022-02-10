package week8;

import org.junit.Test;

public class Practice4_ReplaceStringWithEmpty {

    @Test
    public void example1(){
        String s1 = "Welcome to the interview. All the best to your interview";
        String s2 = "to";

        System.out.println(replaceString(s1,s2));

        System.out.println(addStrings("123","123"));
    }

    private String replaceString(String s1, String s2) {
        if(!s1.contains(s2)) return s1;
        return replaceString(s1.replaceFirst(s2+" ",""), s2);
        //return replaceString(s1.substring(0, s1.indexOf(s2)) + s1.substring(s1.indexOf(s2)+s2.length()+1), s2);
    }

    public String addStrings(String num1, String num2) {
        return String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2));
    }


}
