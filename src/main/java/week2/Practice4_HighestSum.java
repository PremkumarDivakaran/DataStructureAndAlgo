package week2;

import org.junit.Assert;
import org.junit.Test;

public class Practice4_HighestSum {
    /*
    Pseudocode -
    1) Add first k elements and have a sum
    2) loop from k element until end
           a) subtract the first element from the sum
            b) add the new element to the sum
            c) compare with existing sum --> whichever max --> make it max
     */

    @Test  //Positive
    public void example1(){
        int[] nums = new int[]{4,5,39,90,8,100,4,3,987};
        int k = 2;
        Assert.assertEquals(12,highestSum(nums,k));
    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[]{};
        int k = 0;
        Assert.assertEquals(0,highestSum(nums,k));
    }

    @Test //Edge
    public void example3(){
    }

    private int highestSum(int[] nums,int k){
        int left=0, right=k, windowSum = 0, maxSum = 0;
        for(int i=0;i<k;i++) windowSum += nums[i];

        maxSum = windowSum;
        while(right<nums.length) {
            windowSum = windowSum - nums[left++] + nums[right++];
            maxSum = Math.max(maxSum, windowSum );
        }

        return maxSum;
    }

}
