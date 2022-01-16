package week6;

import org.junit.Test;

import java.util.Stack;

public class Practice1_RemoveAdjacentDuplicates {
    /*
    Pseudocode -
    1. Convert String to char Array
    2. Iterate through loop
           a) Check character is present in stack
                if yes, push it in stack
                if no, check if it is peek, if yes pop it
                        else push it
     */

    @Test  //Positive
    public void example1(){
        String str = "abbaca";
        //System.out.println(removeAdajcentDuplicate(str));
        System.out.println(removeAdajcentDuplicate_1(str));
    }

    @Test //Negative
    public void example2(){
        String str = "azxxzy";
        System.out.println(removeAdajcentDuplicate_1(str));

    }

    @Test //Edge
    public void example3(){
    }

    private String removeAdajcentDuplicate(String str) {
        Stack<Character> removeAdj = new Stack<>();
        char[] charArr = str.toCharArray();
        String out = "";

        for(int i=0;i<charArr.length;i++){
            if(!removeAdj.contains(charArr[i])){
                removeAdj.push(charArr[i]);
            }else{
                if(removeAdj.peek()==charArr[i]) removeAdj.pop();
                else removeAdj.push(charArr[i]);
            }
        }

        for (Character eachChar:removeAdj) out += eachChar;

        return out;
    }

    private String removeAdajcentDuplicate_1(String str) {
        Stack<Character> removeAdj = new Stack<>();
        char[] charArr = str.toCharArray();
        String out = "";

        for(int i=0;i<charArr.length;i++){
            if(removeAdj.contains(charArr[i]) && removeAdj.peek()==charArr[i]) removeAdj.pop();
            else removeAdj.push(charArr[i]);
        }

        for (Character eachChar:removeAdj) out += eachChar;

        return out;
    }

}
