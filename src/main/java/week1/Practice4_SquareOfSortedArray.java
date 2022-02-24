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
        //Assert.assertArrayEquals(findSquareOfSortedArray(nums),
        //        new int[] {4,16,36,64,81});
        Assert.assertArrayEquals(findSquareOfSortedArray_twoPointer(nums),
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
        int[] nums = new int[] {-4,-1,0,3,4,10};
        // output : [0,1,9,16,100]
        /*Assert.assertArrayEquals(findSquareOfSortedArray(nums),
                new int[] {0,1,9,16,100});*/
        Assert.assertArrayEquals(findSquareOfSortedArray_twoPointer(nums),
                new int[] {0,1,9,16,16,100});
    }

    private int[] findSquareOfSortedArray(int[] nums){
        for(int i=0;i<nums.length;i++) nums[i] *= nums[i];
        Arrays.sort(nums);
        return nums;
    }

    //Time Complexity ->

    // Time complexity -> O[n]
    private int[] findSquareOfSortedArray_twoPointer(int[] nums){
        int left = 0, right = nums.length-1;
        while (right > 0) {
            if(Math.abs(nums[left])<Math.abs(nums[right])) right--;
            else if(Math.abs(nums[left])>Math.abs(nums[right])){
                nums[left] = nums[left] + nums[right];
                nums[right] = nums[left] - nums[right];
                nums[left] = nums[left] - nums[right];
                right--;
            }
        }

        for(int i=0;i<nums.length;i++) nums[i] *= nums[i];

        return nums;
    }

    @Test //Edge
    public void example4() {
        int[] nums = new int[]{-7, -5, 0, 2, 3, 7, 8};
        System.out.println(Arrays.toString(findSquareOfSortedArray_twoPointer(nums)));
    }

    public int[] squareOfSorted_1(int[] nums){
        int left =0, right = nums.length-1;

        while(left<right){
            if((nums[left]*nums[left])<=(nums[right]*nums[right])) right--;
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right--] = temp;
            }
        }
        return nums;
    }

}
