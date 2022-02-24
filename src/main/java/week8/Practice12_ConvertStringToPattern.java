package week8;

import org.junit.Test;

public class Practice12_ConvertStringToPattern {
    @Test
    public void example1(){
        String s = "aaabbcdee";
        char[] sArr = s.toCharArray();
        int left =0, right =0;
        StringBuilder sb = new StringBuilder();

        while(right<s.length()){
            if(right==s.length()-1){
                sb.append(sArr[left]).append(right-left+1);
                break;
            }
            if(sArr[left]==sArr[right]) right++;
            else{
                sb.append(sArr[left]).append(right-left);
                left=right;
            }
        }

        System.out.println(sb.toString());
    }

    @Test
    public void example2(){
        String s = "aaabbcdee";
        int[] occurance = new int[26];
        for(int i=0;i<s.length();i++) occurance[s.charAt(i)-'a']++;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){

        }

    }
}
