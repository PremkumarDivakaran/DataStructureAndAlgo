package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Practice7_HappyNumbers {

    @Test
    public void example1(){
        int n = 19;
        Assert.assertEquals(true,isHappy2(n));
    }

    @Test
    public void example2(){
        int n = 2;
        Assert.assertEquals(false,isHappy2(n));
    }


    public boolean isHappy(int n) {
        if(findSumOfSquares(n)==1) return true;
        else return false;
    }

    private int findSumOfSquares(int n){
        if(n == 1) return n;
        int newNum=0;
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            do {
                newNum += (n % 10) * (n % 10);
                n = n / 10;
            } while (n == 0);
        }

        return findSumOfSquares(newNum);
    }

    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();

        //Find the next n only if it is not in the set.
        while (!set.contains(n)) {
            set.add(n);
            //Finding the sum of squares of the digits of number n.
            n = sumOfSq(n);
            //If n is equal to 1, meaning it is a happy number, so return true.
            if (n == 1) {
                return true;
            }
        }

        //If set already contains n, meaning n has come again which indicates cycle, so we will return false.
        return false;
    }

    //Function to find the sum of squares of the digits of number n.
    public int sumOfSq(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += (rem * rem);
            n = n / 10;
        }

        return sum;
    }

    public boolean isHappy2(int n) {
        if(n<=0) return false;

        while(true){
            int sum = 0;
            while (n>0) {
                int rem = n % 10;
                sum += (rem * rem);
                n = n / 10;
            }
            if(sum/10 ==0){
                if(sum==1 || sum==7) return true;
                else return false;
            }
            n = sum;
        }
    }
}
