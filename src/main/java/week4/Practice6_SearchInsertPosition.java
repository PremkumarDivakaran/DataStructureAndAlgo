package week4;

import org.junit.Test;

public class Practice6_SearchInsertPosition {
    /*
    Pseudocode -
    1. Intialize left=0, right=nums.length-1
    2. Check if target<nums[0], if yes return 0
    3. Check if target>nums[nums.length-1], if yes return nums.length
    4. Traverse through loop till left<=right
            a) intialize mid = (left+right)/2
            b) check if nums[mid]==target, return mid
            c) check if nums[mid]<target && right-left==1, return mid+1 (edge case)
            d) check if nums[mid]<target, set left=mid
            e) else, set right=mid
     */

    @Test  //Positive
    public void example1(){
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums,target));
    }

    @Test //Negative
    public void example2(){
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums,target));
    }

    @Test //Edge
    public void example3(){
        int[] nums = {1};
        int target = 1;
        System.out.println(searchInsert(nums,target));
    }

    private int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        if(target<nums[0]) return 0;
        else if(target>nums[nums.length-1]) return nums.length;

        while(left<=right){
            int mid = (left+right)/2;

            if(nums[mid]==target) return mid;
            else if(nums[mid]<target && right-left==1) return mid+1;
            else if(nums[mid]<target) left=mid;
            else right=mid;
        }

        return nums.length;
    }

}
