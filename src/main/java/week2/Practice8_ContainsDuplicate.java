package week2;

import org.junit.Assert;
import org.junit.Test;

public class Practice8_ContainsDuplicate {
    /*
    Pseudocode -

     */

    @Test  //Positive
    public void example1(){
        int[] nums = new int[]{1,2,3,1};
        int k=3;
        Assert.assertTrue(findDuplicateWithinKthElement_bruteForce(nums,k));
        Assert.assertTrue(findDuplicateWithinKthElement(nums,k));
    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[]{1,2,3,1,2,3};
        int k=2;
        Assert.assertFalse(findDuplicateWithinKthElement_bruteForce(nums,k));
        Assert.assertFalse(findDuplicateWithinKthElement(nums,k));
    }

    @Test //Edge
    public void example3(){
        int[] nums = new int[]{1,2,3,1,2,3,1};
        int k=3;
        Assert.assertTrue(findDuplicateWithinKthElement_bruteForce(nums,k));
        Assert.assertTrue(findDuplicateWithinKthElement(nums,k));
    }

    @Test //Edge
    public void example4(){
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,9};
        int target = 3;
        Assert.assertTrue(findDuplicateWithinKthElement_bruteForce(nums,target));
        Assert.assertTrue(findDuplicateWithinKthElement(nums,target));
    }

    //Time Complexity -> O[n^2]
    //Space Complexity -> O[1]
    private boolean findDuplicateWithinKthElement_bruteForce(int[] nums,int k){
        for(int i=0;i< nums.length-1;i++)
            for(int j=i+1;j<=i+k;j++)
                if(j<nums.length)
                    if (nums[i] == nums[j]) return true;


        return false;
    }

    //Time Complexity -> O[n]
    //Space Complexity -> O[1]
    private boolean findDuplicateWithinKthElement(int[] nums,int k){
        int left = 0, right = 1;
        while (right<nums.length || left<nums.length-1){
            if(right-left>k || right>=nums.length){
                left++;
                right = left+1;
                continue;
            }

            if(nums[left] == nums[right] && right-left<=k) return true;
            else right++;
        }

        return false;
    }

}