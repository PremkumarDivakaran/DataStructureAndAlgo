package week8;

import org.junit.Assert;
import org.junit.Test;

public class Practice8_ShortestDistanceToCharacter {

    @Test
    public void example1(){
        String s = "loveleetcode";
        char c = 'e';
        Assert.assertArrayEquals(new int[]{3,2,1,0,1,0,0,1,2,2,1,0}, shortestToChar(s,c));
    }

    @Test
    public void example2(){
        String s = "aaab";
        char c = 'b';
        Assert.assertArrayEquals(new int[]{3,2,1,0}, shortestToChar(s,c));
    }

    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];

        int left = s.indexOf(c);
        int right = left;

        for(int i=0; i<s.length();i++){
            if(s.charAt(i)==c) {
                answer[i] = 0;
                if(i<s.length()-1) {
                    left = right;
                    right = s.indexOf(c, left + 1);
                }
            }else {
                answer[i] = Math.min(Math.abs(i - left), Math.abs(i - right));
            }
        }

        return answer;
    }



}
