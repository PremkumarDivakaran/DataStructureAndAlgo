package week6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Practice8_BaseballGame {
    /*
    Pseudocode -
    1. Initialize stack and iterate through given string array
    2. If string is "C", pop the stack
    3. If string is "+",
        a. pop the stack & store in temp
        b. add temp + peek() and save it sum
        c. push temp, sum in order
    4. If string is "D", get peek & multiply with 2 and push it stack
    5. else push value to stack as Integer value
    6. Iterate stack and store sum and return
     */

    @Test  //Positive
    public void example1(){
        String[] ops = {"5","2","C","D","+"};
        Assert.assertEquals(30, calPoints(ops));
    }

    @Test //Positive
    public void example2(){
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        Assert.assertEquals(27, calPoints(ops));
    }

    @Test //Edge
    public void example3(){
        String[] ops = {"1"};
        Assert.assertEquals(1, calPoints(ops));
    }

    private int calPoints(String[] ops){
        int sum = 0, temp, last2Sum;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("C")) stack.pop();
            else if(ops[i].equals("+")){
                temp = stack.pop();
                last2Sum = stack.peek() + temp;
                stack.push(temp);
                stack.push(last2Sum);
            }else if(ops[i].equals("D")) stack.push(stack.peek() * 2);
            else stack.push(Integer.parseInt(ops[i]));
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }

}
