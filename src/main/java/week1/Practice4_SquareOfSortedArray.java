package week1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Practice4_SquareOfSortedArray {
    /*
    Pseudocode -
    1. Traverse through the array
    2. Multiply each element & store it in same index
    3. Sort the resulted array
    4. Return array
     */

    @Test  //Positive
    public void example1(){
        int[] nums = new int[] {2,4,6,8,9};
        // output : [4,16,36,64,81]
        Assert.assertArrayEquals(findSquareOfSortedArray(nums),
                new int[] {4,16,36,64,81});
    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[] {};
        // output : []
        Assert.assertArrayEquals(findSquareOfSortedArray(nums),
                new int[] {});
    }

    @Test //Edge
    public void example3(){
        int[] nums = new int[] {-4,-1,0,3,10};
        // output : [0,1,9,16,100]
        Assert.assertArrayEquals(findSquareOfSortedArray(nums),
                new int[] {0,1,9,16,100});
    }

    private int[] findSquareOfSortedArray(int[] nums){
        for(int i=0;i<nums.length;i++) nums[i] *= nums[i];
        Arrays.sort(nums);
        return nums;
    }

}
