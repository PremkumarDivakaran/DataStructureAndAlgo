package week8;

import org.junit.Assert;
import org.junit.Test;

public class Practice7_HappyNumbers {

    @Test
    public void example1(){
        int n = 19;
        Assert.assertEquals(true,isHappy(n));
    }

    @Test
    public void example2(){
        int n = 2;
        Assert.assertEquals(false,isHappy(n));
    }


    public boolean isHappy(int n) {
        if(findSumOfSquares(n)==1) return true;
        else return false;
    }

    private int findSumOfSquares(int n){
        if(n/10 == 0) return n;
        int newNum=0;
        do{
            newNum += (n%10) * (n%10);
            n=n/10;
        }while (n==0);

        return findSumOfSquares(newNum);
    }
}
