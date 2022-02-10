package week6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Practice9_DailyTemperature {
    /*
    Pseudocode -
    1. Initialize output array with same length of input
    2. Traverse through input array
        a. if temperatures[i] < temperatures[i+1], then add 1 to output array
        and increment index
        b. if temperatures[i] > temperatures[i+1], check next largest number using
        while loop till end of array
            -- if present, get diff of index and store in output array and increment index
            -- if not present, add 0
     3. return output array
     */

    @Test  //Positive
    public void example1(){
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] out = {1,1,4,2,1,1,0,0};
        Assert.assertArrayEquals(out,dailyTemperatures(temperatures));
        Assert.assertArrayEquals(out,dailyTemperatures_stack(temperatures));
    }

    @Test //Positive
    public void example2(){
        int[] temperatures = {30,40,50,60};
        int[] out = {1,1,1,0};
        Assert.assertArrayEquals(out,dailyTemperatures(temperatures));
    }

    @Test //Positive
    public void example4(){
        int[] temperatures = {73,74,75,76,69,72,71,73};
        int[] out = {1,1,1,0,1,2,1,0};
        Assert.assertArrayEquals(out,dailyTemperatures(temperatures));
    }


    @Test //Edge
    public void example3(){
        int[] temperatures = {30,40,50,50};
        int[] out = {1,1,0,0};
        Assert.assertArrayEquals(out,dailyTemperatures(temperatures));
    }

    private int[] dailyTemperatures(int[] temperatures) {
        int[] out = new int[temperatures.length];
        int start = 0;

        for(int i=0;i<temperatures.length-1;i++){
            if(temperatures[i]<temperatures[i+1]) out[start++]=1;
            else{
                int next = i+1;
                boolean flag = false;
                while(next<temperatures.length){
                    if(temperatures[i]<temperatures[next]) {
                        out[start++]=next-i;
                        flag = true;
                        break;
                    }
                    next++;
                }
                if(!flag) out[start++]=0;
            }
        }

        return out;
    }

    private int[] dailyTemperatures_stack(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int start = 0;

        for(int i=0;i<temperatures.length-1;i++){
            if(temperatures[i]<temperatures[i+1]){
                stack.push(1);
            }else{
                start = i+2;
                boolean flag = true;
                while(start<temperatures.length){
                    if(temperatures[start]>temperatures[i]) {
                        stack.push(start - i);
                        break;
                    }else flag = false;
                    start++;
                }

                if(!flag) stack.push(0);
            }
            temperatures[i] = stack.pop();

            if(i==temperatures.length-2) temperatures[i+1] = 0;
        }
        System.out.println(Arrays.toString(temperatures));
        return temperatures;
    }

}
