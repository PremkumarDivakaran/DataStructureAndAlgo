package week6;

import org.junit.Test;

import java.util.Stack;

public class Practice4_SimplifyPath {
    /*
    Pseudocode -
        1. Convert String to string array by splitting based on "/"
        2. Traverse through array
            a. Check string is equal to "." or "", if yes continue loop
            b. Check string is equal to "..", if yes stack.pop
            c. else push to stack
        3.



     */

    @Test  //Positive
    public void example1(){
        String path = "/home/";
        System.out.println(simplifyPath_1(path));
    }

    @Test //Positive
    public void example2(){
        String path = "/../";
        System.out.println(simplifyPath_1(path));
    }

    @Test //Edge
    public void example3(){
        String path = "/home//foo/";
        System.out.println(simplifyPath_1(path));
    }

    @Test //Edge
    public void example4(){
        String path = "/home/../";
        System.out.println(simplifyPath_1(path));
    }

    @Test //Edge
    public void example5(){
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath_1(path));
    }

    //wrong solution
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

    public String simplifyPath_1(String path) {
        Stack<String> stack = new Stack<>();
        String[] strArr = path.split("/");
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<strArr.length;i++){
            if(strArr[i].equals(".") || strArr[i].equals("")){
                continue;
            }else if(stack.isEmpty() && strArr[i].equals("..")){
                continue;
            }else if(!stack.isEmpty() && strArr[i].equals("..")){
                stack.pop();
            }else stack.push(strArr[i]);
        }
        if(stack.isEmpty()) return "/";

        for(int j=stack.size()-1; j>=0;j--) {
            sb.insert(0,stack.pop());
            sb.insert(0, "/");
        }

        return sb.toString();
    }


    }
