package week6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Practice2_DecodeString {
    /*
    Pseudocode -
    // 3(ab) -> ababab

    1. Convert to char Array
    2. Iterate through loop,
        a. if Character is not closing bracket, push it stack
        b. if character is closing bracket,
             then pop the stack
             loop it till i get digit (k) and store it in string builder
             do not store open bracket
        c. Push to stack k times into stack
    3. Traverse stack and print



     */

    @Test  //Positive
    public void example1(){
        String str = "13(ab)";
        System.out.println(decodeString(str));

    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){

    }

    private String decodeString(String str) {
        Stack<Character> stack = new Stack<>();
        List<Character> lst = new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder();
        char[] charArr = str.toCharArray();

        for(int i=0;i<charArr.length;i++){
            if(charArr[i]==')'){
                while(!Character.isDigit(stack.peek())){
                    Character temp = stack.pop();
                    if (temp!='(') lst.add(temp);
                }

                String frequency = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    frequency = stack.pop() + frequency;

                int k =1;
                if(frequency!="") k= Integer.parseInt(frequency);
                while (k > 0) {
                    for(int j=lst.size()-1;j>=0;j--) strBuilder.append(lst.get(j));
                    k--;
                }
            }else stack.push(charArr[i]);
        }

        return strBuilder.toString();
    }


}
