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
        Assert.assertEquals(4,findCountOfUniqueSubstring_bruteForce(s));
        Assert.assertEquals(4,goodSubstringCount(s));
    }

    @Test //Negative
    public void example2(){
        String s = "";
        Assert.assertEquals(0,findCountOfUniqueSubstring(s));
        Assert.assertEquals(0,findCountOfUniqueSubstring_bruteForce(s));
        Assert.assertEquals(0,goodSubstringCount(s));
    }

    @Test //Edge
    public void example3(){
        String s = "abca";
        Assert.assertEquals(2,findCountOfUniqueSubstring(s));
        Assert.assertEquals(2,findCountOfUniqueSubstring_bruteForce(s));
        Assert.assertEquals(2,goodSubstringCount(s));
    }

    //Time Complexity -> O[n^2]
    //Space Complexity -> O[n]
    private int findCountOfUniqueSubstring_bruteForce(String s){
        int counter = 0;
        for(int i=0;i<s.length()-2;i++)
            for(int j=i+3;j-i==3;j++)
                if(isUniqueCharacter(s.substring(i,j))) counter++;

        return counter;
    }

    //Time Complexity -> O[n]
    //Space Complexity -> O[n]
    private int findCountOfUniqueSubstring(String s){
        int right = 3, counter = 0;

        for(int left=0;left<s.length()-2;left++)
            if(isUniqueCharacter(s.substring(left,right++))) counter++;

        return counter;
    }

    //Time Complexity -> O[n]
    //Space Complexity -> O[n]
    private boolean isUniqueCharacter(String substring) {
        char[] charArr = substring.toCharArray();
        Set<Character> mySet = new HashSet<>();
        for (char eachChar:charArr) mySet.add(eachChar);
        if(mySet.size()==3) return true;

        return false;
    }

    /*
    Pseudocode -
    1. Intialize left = 0, right = 2, count = 0, HashSet
    2. Traverse through loop till right < s.length()
    3. Check substring (left,right) is unique
            a. if yes, increment count
    4. increment left and right always
     */

    private int goodSubstringCount(String s){
        int left = 0, right = 2, count = 0, start = 0;
        Set<Character> hSet = new HashSet<>();

        while(right<s.length()){
            boolean isUnique = false;
            while(left<=right){
                if(hSet.add(s.charAt(left++))) isUnique = true;
                else {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) count++;
            hSet.clear();
            left=++start;
            right++;
        }
        return count;
    }

}
