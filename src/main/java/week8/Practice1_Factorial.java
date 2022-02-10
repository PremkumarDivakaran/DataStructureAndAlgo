package week8;

import org.junit.Test;

public class Practice1_Factorial {

    @Test
    public void example1(){
        System.out.println(findFactorial(5));
    }


    private int findFactorial(int n){
        int out = 1;
        while(n>0){
            out = out * n;
            n--;
        }
        return out;
    }
}
