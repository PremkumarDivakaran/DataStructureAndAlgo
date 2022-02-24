package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice10_ShortestCompletingCharacters {

    // Convert licensePlate to list by removing numbers and spaces
    // Iterate through string array and iterate list and check each chars present in string
    // If present, remove it from string
    // If all chars present, note the length and string
    // Check length is less than previous string length, replace string
    // After all iteration, min length string should be returned

    @Test
    public void example1(){
        String licensePlate = "1s3 PSt";
        String[] words = new String[]{"step","steps","stripe","stepple"};
        Assert.assertEquals("steps", shortestCompletingWord(licensePlate,words));
    }

    @Test
    public void example2(){
        String licensePlate = "1s3 456";
        String[] words = new String[]{"looks","pest","stew","show"};
        Assert.assertEquals("pest", shortestCompletingWord_1(licensePlate,words));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.replaceAll("[^A-Za-z]","").toLowerCase();
        List<String> licensePlateLst = new ArrayList<>();
        String out = "";
        int minLength = Integer.MAX_VALUE;

        for(String eachChar:licensePlate.split("")) licensePlateLst.add(eachChar);

        for(String eachWord:words){
            boolean isPresent = false;
            int length = eachWord.length();
            String temp = eachWord;
            for(int i=0;i<licensePlateLst.size();i++){
                if(temp.contains(licensePlateLst.get(i)) ||
                        temp.contains(licensePlateLst.get(i).toUpperCase())) {
                    isPresent = true;
                    temp = temp.replaceFirst(licensePlateLst.get(i),"");
                }
                else {
                    isPresent = false;
                    break;
                }
            }

            if(isPresent) {
                if(length<minLength) out = eachWord;
                minLength = Math.min(length,minLength);
            }
        }

        return out;
    }

    @Test
    public void example3(){
        String licensePlate = "1s3 PSt";
        String[] words = new String[]{"step","steps","stripe","stepple"};
        Assert.assertEquals("steps", shortestCompletingWord_1(licensePlate,words));
    }

    public String shortestCompletingWord_1(String licensePlate, String[] words) {

        licensePlate = licensePlate.replaceAll("[^A-Za-z]","").toLowerCase();
        List<String> lst = new ArrayList<>();
        Map<Character,Integer> licensePlateMap = new HashMap<>();
        for(char eachChar:licensePlate.toCharArray())
            licensePlateMap.put(eachChar,licensePlateMap.getOrDefault(eachChar,0)+1);

        for(String eachString:words){
            boolean isPresent = true;
            Map<Character,Integer> wordMap = new HashMap<>();
            for(char eachChar:eachString.toCharArray())
                wordMap.put(eachChar,wordMap.getOrDefault(eachChar,0)+1);

            for(Map.Entry<Character,Integer> eachEntry: licensePlateMap.entrySet()){
                if(eachEntry.getValue() != wordMap.get(eachEntry.getKey())){
                    isPresent = false;
                    break;
                }
            }

            if(isPresent) lst.add(eachString);
        }
        String out = "";
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<lst.size();i++){
            int curLength = lst.get(i).length();
            if(curLength<minLength) out= lst.get(i);
            minLength = Math.min(minLength,curLength);
        }

        return out;
    }
}
