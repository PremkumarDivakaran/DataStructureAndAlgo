package week1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Practice5_ReverseVowels {
    /*
    Pseudocode -
    1. Convert String to char array
    2. Traverse through array and store only vowels in another array
    3. Traverse through array and replace vowels with new array in reverse order
     */

    /*
    Pseudocode -
    1. intialize left =0 and right = array.length
    2. Traverse loop till left<right
    3. if left = vowel & right = vowel
        swap it
    4. if left = vowel & right != vowel
        right --
    5. if left != vowel & right == vowel
        left ++
     */

    @Test  //Positive
    public void example1(){
        String s = "leetcode";
        //Output : leotcede
        //Assert.assertEquals(reverseVowels(s), "leotcede");
        Assert.assertEquals(reverseVowels_twoPointer(s), "leotcede");
    }

    @Test //Negative
    public void example2(){
        String s = "";
        //Output :
        //Assert.assertEquals(reverseVowels(s), "");
        Assert.assertEquals(reverseVowels_twoPointer(s), "");
    }

    @Test //Edge
    public void example3(){
        String s = "AeIoU";
        //Output : UoIeA
        //Assert.assertEquals(reverseVowels(s), "UoIeA");
        Assert.assertEquals(reverseVowels_twoPointer(s), "UoIeA");
    }

    private String reverseVowels(String s){
        String[] sArr = s.split("");
        List<String> ls = new ArrayList<>();

        for(String eachStr : sArr){
            if(eachStr.equalsIgnoreCase("a") || eachStr.equalsIgnoreCase("e") ||
                    eachStr.equalsIgnoreCase("i") || eachStr.equalsIgnoreCase("o") ||
                    eachStr.equalsIgnoreCase("u")) ls.add(eachStr);
        }

        int end = ls.size()-1;

        for(int i=0;i< sArr.length;i++){
            if(sArr[i].equalsIgnoreCase("a") || sArr[i].equalsIgnoreCase("e") ||
                    sArr[i].equalsIgnoreCase("i") || sArr[i].equalsIgnoreCase("o") ||
                    sArr[i].equalsIgnoreCase("u")){
                sArr[i] = ls.get(end);
                end--;
            }
        }

        String returnString = "";

        for (String eachString:sArr) {
            returnString += eachString;
        }

        return returnString;

    }

    //Time Complexity -> O[n]

    //Time Complexity - O[n/2]
    private String reverseVowels_twoPointer(String s){
        String[] sArr = s.split("");
        int left = 0, right = sArr.length-1;

        while(left<right){
            if(isVowel(sArr[left]) && isVowel(sArr[right])){
                String temp = sArr[left];
                sArr[left++] = sArr[right];
                sArr[right--] = temp;
            }
            else if(!isVowel(sArr[right])) right--;
            else left++;
        }

        String returnString = "";

        for (String eachString:sArr) {
            returnString += eachString;
        }

        return returnString;


    }

    private boolean isVowel(String str){
        if(str.equalsIgnoreCase("a") || str.equalsIgnoreCase("e") ||
                str.equalsIgnoreCase("i") || str.equalsIgnoreCase("o") ||
                str.equalsIgnoreCase("u")) return true;

        return false;
    }



}
