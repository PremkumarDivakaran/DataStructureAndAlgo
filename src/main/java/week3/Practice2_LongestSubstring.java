package week3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Practice2_LongestSubstring {
    /*
    Pseudocode -
    1. Create HashMap<Character,Integer> and intialize maxSize = Integer.MIN_VALUE
    2. Traverse through loop till length of given string
    3. If map not contains character, add character in map and increment right
    4. If map contains character,
            a. store right-left in window length
            b. compare maxsize using Math.Max(windowlength,maxSize)
            c. reset right = left
            d. add element to map
     */

    @Test  //Positive
    public void example1(){
        //String s = "cababcbb";
        String s = "pwwkew";
        System.out.println(findLongestSubstring(s));
    }

    @Test //Negative
    public void example2(){
        String s = "bbbbb";
        System.out.println(findLongestSubstring(s));
    }

    @Test //Edge
    public void example3(){
    }

    private int findLongestSubstring(String s){
        Map<Character,Integer> sMap = new HashMap<>();
        int maxSize = 0;
        int left = 0;
        int right = 0;

        while(right<s.length()){
            if(sMap.containsKey(s.charAt(right))){
                int currentWinLength = right-left;
                maxSize = Math.max(currentWinLength,maxSize);
                right = ++left;
                sMap.clear();
            }else{
                sMap.put(s.charAt(right),right);
                right++;
            }
        }
        return maxSize;
    }

}
