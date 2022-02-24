package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReverseOnlyLetters {

    @Test
    public void example1(){
        String s = "ab-cd";
        System.out.println(reverseOnlyLetters(s));
    }

    @Test
    public void example2(){

    }

    @Test
    public void example3(){

    }

    public String reverseOnlyLetters(String s) {
        char[] sArr = s.toCharArray();
        int left = 0, right = sArr.length-1;

        while(left<right){
            if(Character.isAlphabetic(sArr[left]) && Character.isAlphabetic(sArr[right])){
                char temp = sArr[left];
                sArr[left++] = sArr[right];
                sArr[right--] = temp;
            }else if(!Character.isAlphabetic(sArr[left])) left++;
            else right--;
        }

        return new String(sArr);
    }


    @Test
    public void example4(){
        String s = "covid2019";
        System.out.println(reformat(s));
    }

    public String reformat(String s) {
        if(s.length()==0) return "";

        List<Integer> numList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) numList.add(Character.getNumericValue(ch));
            else charList.add(ch);
        }

        if(numList.size()==0 || charList.size()==0) return "";

        int index=0;

        while(index<numList.size() && index<charList.size()){
            if(numList.size()>=charList.size())
                sb.append(numList.get(index)).append(charList.get(index));
            else
                sb.append(charList.get(index)).append(numList.get(index));
            index++;
        }

        if(numList.size()-index>1 || charList.size()-index>1) return "";
        else if(charList.size()>index) sb.append(charList.get(index));
        else if(numList.size()>index) sb.append(numList.get(index));

        return sb.toString();

    }
}
