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

    //Time Complexity -> O[n^2]
    //Space Complexity -> O[1]
    private boolean findDuplicateWithinKthElement_bruteForce(int[] nums,int k){
        for(int i=0;i< nums.length-k;i++)
            for(int j=i+1;j<=k;j++)
                if(nums[i]==nums[j]) return true;

        return false;
    }

    //Time Complexity -> O[n]
    //Space Complexity -> O[1]
    private boolean findDuplicateWithinKthElement(int[] nums,int k){
        int left = 0, right = 1;
        while (right<nums.length){
            if(nums[left] == nums[right] && right-left<=k) return true;
            else if(right-left>k){
                left++;
                right = left+1;
            }
            else right++;
        }

        return false;
    }

}
