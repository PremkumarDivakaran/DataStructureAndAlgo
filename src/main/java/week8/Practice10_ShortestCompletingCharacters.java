package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Practice10_ShortestCompletingCharacters {

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
        Assert.assertEquals("pest", shortestCompletingWord(licensePlate,words));
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
}
