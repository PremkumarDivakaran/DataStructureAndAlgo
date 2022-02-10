package week8;

import org.junit.Test;

public class Practice2_FibonocciSeries {

    // 0 1 1 2 3
    int firstNum = 0, secondNum = 1;

    @Test
    public void example1(){
        fibonocciSeries_BruteForce(5);
    }

    private void fibonocciSeries_BruteForce(int n){
        System.out.println(firstNum);
        System.out.println(secondNum);

        for(int i=2; i<n; i++){
            int nextNum = firstNum + secondNum;
            System.out.println(nextNum);
            firstNum = secondNum;
            secondNum = nextNum;
        }
    }

    @Test
    public void example2(){
        System.out.println(firstNum);
        System.out.println(secondNum);
        fibonocciSeries_Recurssion(5);
    }

    private int fibonocciSeries_Recurssion(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        int nextNum = fibonocciSeries_Recurssion(n-1) + fibonocciSeries_Recurssion(n-2);

        return nextNum;
    }

}
