package week2;

import org.junit.Assert;
import org.junit.Test;

public class Practice2_MergeSort {
    /*
    Pseudocode -
    1. Intialize new array out with size arr1+arr2
    2. set left =0 for 1st array and set right=0 for 2nd array
    3. Traverse and check left and right less than corresponding size
    4.check arr1[left]<arr2[right]
        if yes, add arr1[left] to new array and move left pointer to next
        if no, add arr1[right] to new array and move right pointer to next
    5. check size of new array is not filled,
        if left < arr1.length, fill all remaining element in out
        if right < arr2.length, fill all remaining element in out
    6. return out
     */

    @Test  //Positive
    public void example1(){
    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
    }

    // Time Complexity - O[n]
    private int[] mergeSort_twoPointer(int[] nums1, int[]nums2){
        int left =0, right =0, start = 0;

        int[] out = new int[nums1.length+nums2.length];

        /*while(left<nums1.length && right<nums2.length){
            if(nums1[left]<nums2[right]) out[start++] = nums1[left++];
            else out[start++] = nums2[right++];
        }

        if(start<out.length){
            for (int i = start; i < out.length; i++) {
                if(left<nums1.length) out[i] = nums1[left++];
                if(right<nums2.length) out[i] = nums2[right++];
            }
        }*/

        //alternate approach
        while(left<nums1.length || right<nums2.length){
            if(left== nums1.length) out[start++] = nums2[right++];
            else if(right == nums2.length) out[start++] = nums1[left++];
            else if(nums1[left]<nums2[right]) out[start++] = nums1[left++];
            else out[start++] = nums2[right++];
        }

        return out;
    }

    @Test
    public void testRunner(){
        int[] nums1 = new int[]{2,4,5,9};
        int[] nums2 = new int[]{1,2,3,8,15,65};

        Assert.assertArrayEquals(new int[]{1,2,2,3,4,5,8,9,15,65},mergeSort_twoPointer(nums1,nums2));
    }

}
