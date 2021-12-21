package week2;

import org.junit.Assert;
import org.junit.Test;

public class Practice5_MaximumAverage {
    /*
    Pseudocode -
    1) Take average first k elements and have a sum
    2) loop from k element until end
           a) subtract the first element from the sum
            b) add the new element to the sum
            c) compare with existing sum --> whichever max --> make it max
     */

    @Test  //Positive
    public void example1(){
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 4;
        Assert.assertEquals((float)12.75,maximumAverage(nums,k),0.001);
    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[]{};
        int k = 0;
        Assert.assertEquals((float)0,maximumAverage(nums,k),0.001);
    }

    @Test //Edge
    public void example3(){
        int[] nums = new int[]{5};
        int k = 1;
        Assert.assertEquals((float)5.00000,maximumAverage(nums,k),0.001);
    }

    //Time Complexity -> O[n]
    //Space Complexity -> O[1]
    private double maximumAverage(int[] nums,int k){
        int left=0, right=k;
        double windowAvg = 0, maxAvg = 0;
        for(int i=0;i<k;i++)
            windowAvg += nums[i]/(double)k;

        maxAvg = windowAvg;
        while(right<nums.length) {
            windowAvg = windowAvg - nums[left++]/(float)k + nums[right++]/(double)k;
            maxAvg = Math.max(maxAvg, windowAvg);
        }
        return maxAvg;
    }

}
