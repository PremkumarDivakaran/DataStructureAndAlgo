package week6;

import org.junit.Test;

import java.util.Stack;

public class Practice4_SimplifyPath {
    /*
    Pseudocode -




     */

    @Test  //Positive
    public void example1(){
        String path = "/home/";
        System.out.println(simplifyPath(path));
    }

    @Test //Positive
    public void example2(){
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

    @Test //Edge
    public void example3(){
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }

    @Test //Edge
    public void example4(){
        String path = "/home/../";
        System.out.println(simplifyPath(path));
    }

    public String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] pathArr = path.toCharArray();

        for(int i=0; i<pathArr.length;i++){

            if(!stack.isEmpty() && pathArr[i]=='/' && stack.peek()=='/'){

            } else if(pathArr[i]=='.' && stack.peek()=='.'){
                stack.pop();
                stack.pop();
                if(!stack.isEmpty()){
                    while(stack.peek()!='/') stack.pop();
                    stack.pop();
                }
            }else stack.push(pathArr[i]);

        }

        while(stack.size()>1 && stack.peek()=='/') stack.pop();
        while(!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().toString();
    }


}
