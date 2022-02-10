package week1;

import org.junit.Test;

import java.util.Arrays;

public class Practice8_ShortestCompletingWord {
    /*
    Pseudocode -
    1. Convert String 'licenseplate' to string array
    2. Traverse through array and compare each string in licenseplate
        with each String in given array
    3. Intialize Arraylist and put each characters in string in list
    4. If 'licenseplate' each character present in the list, remove that
        character & continue

     */

    @Test  //Positive
    public void example1(){
    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
        //licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
        findShortestCompletingWord("1s3 PSt", new String[] {"step","steps"});
    }

    private String findShortestCompletingWord(String licensePlate, String[] words){
        String out = "";
        String inputStr = sortString(licensePlate.replaceAll("[^A-Za-z]","").toLowerCase());
        int prevLength = Integer.MAX_VALUE;

        for(String eachStr: words){
            if(eachStr.length()<inputStr.length()) continue;

            if(sortString(eachStr).contains(inputStr)) {
                int currentLength = eachStr.length();
                if(currentLength<prevLength) out = eachStr;
                prevLength = Math.min(currentLength,prevLength);
            }
        }
        return out;
    }

    private String sortString(String input){
        char[] inputArr = input.toCharArray();
        Arrays.sort(inputArr);
        return new String(inputArr);
    }

    @Test
    public void testRunner(){
        //"1s3 456"
        //["looks","pest","stew","show"]
        System.out.println(findShortestCompletingWord("1s3 456",
                new String[]{"looks","pest","stew","show"}));
    }

    //Time Complexity -> O[n*m]

}
