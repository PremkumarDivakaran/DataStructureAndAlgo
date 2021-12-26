package week2;

import org.junit.Test;

public class Practice3_findSubArraySum {
    /*
    Pseudocode -
    1. Set left and right = 0
    2. Traverse loop till right<arr.length
    3. if sum is less than k, then move right
    4. if sum is more than k, then move left
    5. if sum is equal to k,
        and return left and right values
        then move left & right
     */

    @Test  //Positive
    public void example1(){
        int[] nums = {1,7,4,3,1,2,1,5,1};
        int k = 7;
    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
    }

    private void findSubArraySum_slidingWindow(int[] nums, int k){
        int left = 0, right1=0, sum=0;

        while(right1<nums.length){
            sum += nums[right1++];
            if(sum>k) sum -= nums[left++];
            if(sum==k) System.out.println(left + " " + right1);
        }

        /*for(int right=0;right<nums.length;right++){
            sum += nums[right];
            if(sum>k) sum -= nums[left++];
            if(sum==k) System.out.println(left + " " + right);
        }*/
    }

    @Test
    public void testRunner(){
        int[] nums = {1,7,4,3,1,2,1,5,1};
        int k = 4;

        findSubArraySum_slidingWindow(nums,k);
    }

}
