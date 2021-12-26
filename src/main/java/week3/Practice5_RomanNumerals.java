package week3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Practice5_RomanNumerals {
    /*
    Pseudocode -
    1. Add given Roman symbol and corresponding numerals in map
    2. Covert given string into charArray & intialize sum=0
    3. int left =0, right =1
    4. Traverse through each character array till left<charArray.length
    5. Check charArray[left] in map, and add numerals to sum
            a. If charArray[left] is 'I', then check charArray[right]
                if charArray[right] is 'V', multiply (-1) * numerals of I and add to sum
            b. If charArray[left] is 'X', then check charArray[right]
                if charArray[right] is 'L', multiply (-1) * numerals of X and add to sum
            c. If charArray[left] is 'C', then check charArray[right]
                if charArray[right] is 'D', multiply (-1) * numerals of C and add to sum
    6. return sum
    */

    @Test  //Positive
    public void example1(){
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
    }

    private int romanToInt(String s) {
        int sum = 0, left = 0, right = 1;

        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        char[] sArray = s.toCharArray();

        while(left<sArray.length){

            if(sArray.length==1){
                sum += romanMap.get(sArray[left++]);
                continue;
            }

            if((sArray[left]=='I' && sArray[right]=='V') || (sArray[left]=='I' && sArray[right]=='X'))
                sum -= romanMap.get(sArray[left]);
            else if((sArray[left]=='X' && sArray[right]=='L') || (sArray[left]=='X' && sArray[right]=='C'))
                sum -= romanMap.get(sArray[left]);
            else if((sArray[left]=='C' && sArray[right]=='D') || (sArray[left]=='C' && sArray[right]=='M'))
                sum -= romanMap.get(sArray[left]);
            else
                sum += romanMap.get(sArray[left]);

            left++;
            if(right<sArray.length-1) right++;
        }

        return sum;
    }

}
