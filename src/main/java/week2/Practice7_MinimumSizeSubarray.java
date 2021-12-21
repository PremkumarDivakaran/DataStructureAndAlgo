package week2;

import org.junit.Assert;
import org.junit.Test;

public class Practice7_MinimumSizeSubarray {
    /*
    Pseudocode -
    1. Intialize left, right, sum as '0' & store Maximum integer value to variable minSubArraySize
    2. Traverse loop till left is less than given array
    3. check if sum is less than target,
        add right th element to sum & increment right
    4. if sum is more than or equal to target,
        store min value in minSubArraySize (minSubArraySize, right-left)
        subtract left th element to sum & increment left
    5. Return minSubArraySize
     */

    @Test  //Positive
    public void example1(){
        int[] nums = new int[]{2,3,1,2,4,3,7};
        int target = 7;
        Assert.assertEquals(1,findMinimumSizeSubarray(nums,target));
        Assert.assertEquals(1,findMinimumSizeSubarray_bruteForce(nums,target));
    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[]{1,4,4};
        int target = 4;
        Assert.assertEquals(1,findMinimumSizeSubarray(nums,target));
        Assert.assertEquals(1,findMinimumSizeSubarray_bruteForce(nums,target));
    }

    @Test //Edge
    public void example3(){
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int target = 11;
        Assert.assertEquals(0,findMinimumSizeSubarray(nums,target));
        Assert.assertEquals(0,findMinimumSizeSubarray_bruteForce(nums,target));
    }

    //Time Complexity -> O[n^2]
    //Space Complexity -> O[1]
    private int findMinimumSizeSubarray_bruteForce(int[] nums, int target){
        int minSubArraySize = Integer.MAX_VALUE;
        for(int i=0;i< nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(sum>=target){
                    minSubArraySize = Math.min(j-i+1,minSubArraySize);
                    break;
                }
            }
            if(minSubArraySize==1) return minSubArraySize;
        }
        if (minSubArraySize==Integer.MAX_VALUE) return 0;

        return minSubArraySize;
    }

    //Time Complexity -> O[n]
    //Space Complexity -> O[1]
    private int findMinimumSizeSubarray(int[] nums, int target){
        int left = 0, right = 0, sum = 0, minSubArraySize = Integer.MAX_VALUE;

        int totalSum = 0;
        for(int eachInt:nums){
            totalSum += eachInt;
        }
        if(totalSum<target) return 0;
        else if(totalSum==target) return nums.length;

        while(left<nums.length){
            if(sum>=target){
                minSubArraySize = Math.min(minSubArraySize,right-left);
                sum = sum - nums[left++];
            }
            else sum += nums[right++];
        }

        return minSubArraySize;
    }


}
