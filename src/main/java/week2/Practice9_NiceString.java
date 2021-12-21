package week2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class Practice9_NiceString {
    /*
    Pseudocode -
    Check IsNiceString :
    1. Put each characters of given String in Treeset
    2. For String from set & validate first half of string is uppercase of 2nd half
    3. If yes, return true. or return false

    1. Intialize left = 0, right = string.length
    2. Traverse loop till left < string.length-1
    3. Check substring(left,right) is nice
        a. if Yes, store length & String if length is greater than previous length
           Increment left & reset right to string.length
        b. if no, decrement right
    4. Return stored string
     */

    @Test  //Positive
    public void example1(){
        String s = "YazaAay";
        Assert.assertEquals("aAa",findLongestNiceString_bruteForce(s));
        Assert.assertEquals("aAa",findLongestNiceString(s));
    }

    @Test //Negative
    public void example2(){
        String s = "c";
        Assert.assertEquals("",findLongestNiceString_bruteForce(s));
        Assert.assertEquals("",findLongestNiceString(s));
    }

    @Test //Edge
    public void example3(){
        String s = "dDzeE";
        Assert.assertEquals("dD",findLongestNiceString_bruteForce(s));
        Assert.assertEquals("dD",findLongestNiceString(s));
    }

    @Test //Edge
    public void example4(){
        String s = "bB";
        Assert.assertEquals("bB",findLongestNiceString_bruteForce(s));
        Assert.assertEquals("bB",findLongestNiceString(s));
    }

    //Time Complexity -> O[n^2]
    //Space Complexity -> O[n]
    private String findLongestNiceString_bruteForce(String s){
        String longestNiceString = "";
        int longestNiceStringLength = 0;

        if(s.length()==1) return longestNiceString;

        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(isNiceString(s.substring(i,j+1))){
                    int currentLength = j-i+1;
                    if(currentLength>longestNiceStringLength) longestNiceString = s.substring(i,j+1);
                    longestNiceStringLength = Math.max(longestNiceStringLength,currentLength);
                }
            }
        }
        return longestNiceString;
    }

    //Time Complexity -> O[n]
    //Space Complexity -> O[n]
    private String findLongestNiceString(String s){
        String longestNiceString = "";
        int longestNiceStringLength = 0, left = 0, right = s.length();

        if(s.length()==1) return longestNiceString;

        while(left<s.length()-1){
            if(isNiceString(s.substring(left,right))){
                int currentLength = right-left;
                if(currentLength>longestNiceStringLength) longestNiceString = s.substring(left,right);
                longestNiceStringLength = Math.max(longestNiceStringLength,currentLength);
                left++;
                right = s.length();
            }else right--;

            if(left==right){
                left++;
                right = s.length();
            }
        }

        return longestNiceString;
    }

    //Time Complexity -> O[n]
    //Space Complexity -> O[n]
    private boolean isNiceString(String s){
        Set<String> tSet = new TreeSet<>();
        String sortedString = "";
        for(String eachChar:s.split("")) tSet.add(eachChar);
        if(tSet.size()%2!=0) return false;

        for (String eachStr:tSet) sortedString += eachStr;

        if(sortedString.substring(0,sortedString.length()/2).toLowerCase()
                .equals(sortedString.substring(sortedString.length()/2))) return true;

        return false;
    }

}
