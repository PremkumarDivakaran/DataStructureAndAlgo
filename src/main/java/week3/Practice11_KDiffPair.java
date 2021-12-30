package week3;

import org.junit.Test;

import java.util.Arrays;

public class Practice11_KDiffPair {
    /*
    Pseudocode -
    1. Initialize left = 0, right = 1, count = 0
    2. Sort given array using Arrays.sort
    3. Traverse through loop till right < nums.length
    4. Check if diff = k, increment count, left, right & continue
    5. Check if diff > k, increment left, right & continue
    6. Add one more condition, to check if next element is same, move left pointer to next
    7. Else increment right
    8. return count
     */

    @Test  //Positive
    public void example1(){
        int[] nums = new int[]{3,1,4,1,5};
        int k = 2;
        System.out.println(findPairs(nums,k));
    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[]{1,4,1,2,3};
        int k = 4;
        System.out.println(findPairs(nums,k));
    }

    @Test //Edge
    public void example3(){
        int[] nums = new int[]{1,3,1,5,4};
        int k = 0;
        System.out.println(findPairs(nums,k));
    }

    @Test //Edge
    public void example4(){
        int[] nums = new int[]{1,1,1,1,1};
        int k = 0;
        System.out.println(findPairs(nums,k));
    }


    private int findPairs(int[] nums, int k) {
        int left = 0, right = 1, count = 0;
        Arrays.sort(nums);

        while(right<nums.length){
            if(Math.abs(nums[left]-nums[right])>k || Math.abs(nums[left]-nums[right])==k){
                if(Math.abs(nums[left]-nums[right])==k) count++;
                while(left<nums.length-1 && nums[left]==nums[left+1]) left++;
                left++;
                right=left+1;
                continue;
            }else{
                right++;
            }
        }

        return count;
    }

}
