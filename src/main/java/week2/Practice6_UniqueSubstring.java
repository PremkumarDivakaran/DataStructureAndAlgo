package week2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Practice6_UniqueSubstring {
    /*
    Pseudocode -
    1. Write function to determine given string of length 3 contains only unique character
        a. Put it in Set and check size is 3
    2. intialize counter = 0
    3. Check every 3 character in string till end
        a. if unique, increment counter

     */

    @Test  //Positive
    public void example1(){
        String s = "aababcabc";
        Assert.assertEquals(4,findCountOfUniqueSubstring(s));
    }

    @Test //Negative
    public void example2(){
        String s = "";
        Assert.assertEquals(0,findCountOfUniqueSubstring(s));
    }

    @Test //Edge
    public void example3(){
        String s = "abca";
        Assert.assertEquals(2,findCountOfUniqueSubstring(s));
    }

    private int findCountOfUniqueSubstring(String s){
        int right = 3, counter = 0;

        for(int left=0;left<s.length()-2;left++)
            if(isUniqueCharacter(s.substring(left,right++))) counter++;

        return counter;
    }

    private boolean isUniqueCharacter(String substring) {
        char[] charArr = substring.toCharArray();
        Set<Character> mySet = new HashSet<>();
        for (char eachChar:charArr) mySet.add(eachChar);
        if(mySet.size()==3) return true;

        return false;
    }

}
