package week3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Practice1_findAnagrams {
    /*
    Pseudocode -
    1. Iterate each character of p and put it in pMap
    2. Convert s to charArray
    3. Intialize left =0, right = p.length-1
    4. Traverse through loop till right < s.length
        a. put it in sMap and check sMap equals pMap
        b. remove left element in sMap and increment left
        c. increment right and add right element
     */

    @Test  //Positive
    public void example1(){
        String s = "cbaebabacd";
        String p = "abc";
        findAnagram_slidingWindow(s,p);
    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
    }

    private void findAnagram_slidingWindow(String s, String p){
        int sLength = s.length(), pLength = p.length();

        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> pMap = new HashMap<>();

        if(pLength>sLength) throw new RuntimeException("Input is wrong");

        for(int i=0;i<pLength;i++){
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0)+1);
        }

        for(int j=0;j<s.length();j++){
            sMap.put(s.charAt(j),sMap.getOrDefault(s.charAt(j),0)+1);
            if(j>=pLength){
                char ch = s.charAt(j-pLength);
                if(sMap.get(ch)==1) sMap.remove(ch);
                else sMap.put(ch,sMap.get(ch)-1);
            }
            if(sMap.equals(pMap)) System.out.println("Anagram");
        }

    }

}
