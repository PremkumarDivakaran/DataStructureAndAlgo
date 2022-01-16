package week6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Practice3_RemoveOuterMostParenthesis {
    /*
    Pseudocode -
    1. Initialize stack
    2. Convert string into char array
    3. Iterate through array
          a. Check character is closing bracket and stack size is even
              -- pop the stack using loop till stack is empty & store it in string builder
          b. else push into stack



     */

    @Test  //Positive
    public void example1(){
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    @Test //Positive
    public void example2(){
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }

    @Test //Edge
    public void example3(){
        String s = "()()";
        System.out.println(removeOuterParentheses(s));
    }

    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder strBuilder = new StringBuilder();
        List<Character> lst = new ArrayList<>();
        char[] charArr = s.toCharArray();
        int open = 0, close = 0;

        for(int i=0;i<charArr.length;i++){
            if(charArr[i]=='(') open++;
            else close++;

            stack.push(charArr[i]);
            if(charArr[i]==')' && stack.size()%2==0 && open==close){
                stack.pop();
                while(!stack.isEmpty()) lst.add(stack.pop());
                lst.remove(lst.size()-1);
                for (int j = lst.size()-1; j >= 0; j--) strBuilder.append(lst.get(j));
                lst.clear();
                open = 0;
                close = 0;
            }

        }

        return strBuilder.toString();
    }


}
