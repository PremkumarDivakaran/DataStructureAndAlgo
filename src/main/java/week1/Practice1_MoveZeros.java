package week1;

import org.junit.Assert;
import org.junit.Test;

public class Practice1_MoveZeros {

    /*
    Psuedocode -
    1. Traverse through an array
    2. Set int start as '0'
    3. If element is not equal to zero,
        add to same array with index starting from start,
        increment start
    4. Check if start less than array length
        if yes, iterate from array from start index and to length of array and store '0'
     */

    @Test //Positive
    public void example1(){
        int[] nums = new int[] {0,1,0,3,12};
        //Output: [1,3,12,0,0]
        Assert.assertArrayEquals(moveZerosToEnd(nums),new int[] {1,3,12,0,0});
    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[] {};
        Assert.assertArrayEquals(moveZerosToEnd(nums),new int[] {});
    }

    @Test //Negative
    public void example3(){
        int[] nums = new int[] {3,6,9,54,21,33};
        Assert.assertArrayEquals(moveZerosToEnd(nums),new int[] {3,6,9,54,21,33});
    }

    @Test //Edge
    public void example4(){
        int[] nums = new int[] {0};
        //Output: [0]
        Assert.assertArrayEquals(moveZerosToEnd(nums),new int[] {0});
    }

    private int[] moveZerosToEnd(int[] nums){
        if(nums.length<=1) return nums;

        int start = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[start] = nums[i];
                start++;
            }
        }

        if(start< nums.length){
            for(int i=start;i<nums.length;i++) nums[i] = 0;
        }

        return nums;
    }


}
