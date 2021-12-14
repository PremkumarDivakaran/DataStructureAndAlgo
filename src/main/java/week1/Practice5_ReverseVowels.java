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

    @Test  //Positive
    public void example1(){
        String s = "leetcode";
        //Output : leotcede
        Assert.assertEquals(reverseVowels(s), "leotcede");
    }

    @Test //Negative
    public void example2(){
        String s = "";
        //Output :
        Assert.assertEquals(reverseVowels(s), "");
    }

    @Test //Edge
    public void example3(){
        String s = "AeIoU";
        //Output : UoIeA
        Assert.assertEquals(reverseVowels(s), "UoIeA");
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



}
