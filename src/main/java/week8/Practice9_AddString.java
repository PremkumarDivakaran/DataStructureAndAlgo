package week8;

import org.junit.Assert;
import org.junit.Test;

public class Practice9_AddString {

    @Test
    public void example1(){
        String num1 = "456";
        String num2 = "77";
        Assert.assertEquals("533",addStrings(num1,num2));
    }

    @Test
    public void example2(){
        String num1 = "1235";
        String num2 = "24";
        Assert.assertEquals("1259",addStrings(num1,num2));
    }

    @Test
    public void example3(){
        String num1 = "0";
        String num2 = "0";
        Assert.assertEquals("0",addStrings(num1,num2));
    }

    @Test
    public void example4(){
        String num1 = "1";
        String num2 = "9";
        Assert.assertEquals("10",addStrings(num1,num2));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder out = new StringBuilder();
        StringBuilder input1 = new StringBuilder(num1);
        StringBuilder input2 = new StringBuilder(num2);

        String mergedInput = input1.reverse().append(input2.reverse()).toString();
        int left = 0;
        int right = num1.length();
        int remainder = 0;

        while(left<num1.length() || right<mergedInput.length()){
            int currentDigitsSum = 0;
            if(left<num1.length() && right<(num1.length()+num2.length()))
                currentDigitsSum = Character.getNumericValue(mergedInput.charAt(left)) +
                        Character.getNumericValue(mergedInput.charAt(right)) + remainder;
            else if(left<num1.length())
                currentDigitsSum = Character.getNumericValue(mergedInput.charAt(left)) + remainder;
            else
                currentDigitsSum = Character.getNumericValue(mergedInput.charAt(right)) + remainder;

            out.append(currentDigitsSum % 10);
            remainder = currentDigitsSum/10;

            left++;
            right++;
        }

        if(remainder!=0) out.append(remainder);

        return out.reverse().toString();
    }



}
