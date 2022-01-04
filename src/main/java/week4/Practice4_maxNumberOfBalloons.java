package week4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Practice4_maxNumberOfBalloons {
    /*
    Pseudocode -
    1. intialize counter
    2. Put character of given string into list
    3. Intialize char[] and put all character of string 'baloon'
    3. Traverse through loop till list.size()>=char[].length
    4. Iterate through char[] and check list contains corresponding character
            a) if character is present and it is 'n', increment counter
            b) if character is present, remove character from list
            c) if character is not present, break loop
     5. return counter
     */

    @Test  //Positive
    public void example1(){
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text));
    }

    @Test //Negative
    public void example2(){
        String text = "leetcode";
        System.out.println(maxNumberOfBalloons(text));
    }

    @Test //Edge
    public void example3(){
        String text = "balloon";
        System.out.println(maxNumberOfBalloons(text));
    }

    private int maxNumberOfBalloons(String text) {
        int count = 0;

        List<Character> inputList = new ArrayList<>();
        for (char eachChar : text.toCharArray()) inputList.add(eachChar);
        char[] target = {'b', 'a', 'l', 'l', 'o', 'o', 'n'};

        outer:
        while (inputList.size() >= target.length){
            for (char eachChar : target) {
                if (inputList.contains(eachChar)) {
                    if (eachChar == 'n') count++;
                    inputList.remove(inputList.indexOf(eachChar));
                } else break outer;
            }
        }

        return count;
    }

}
