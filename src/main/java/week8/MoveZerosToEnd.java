package week8;

import org.junit.Test;

import java.util.Arrays;

public class MoveZerosToEnd {

    @Test
    public void example1(){
        int[] nums = new int[]{0,1,6,0,2,0,9,5,0};
        System.out.println(Arrays.toString(moveZerosToLeft(nums)));
    }

    @Test
    public void example2(){
        int[] nums = new int[]{0,1,6,0,2,0,9,5,0};
        System.out.println(Arrays.toString(moveZerosToRight(nums)));
    }


    public int[] moveZerosToLeft(int[] nums){
        int left = nums.length-1;
        for(int right=nums.length-1;right>=0;right--){
            if(nums[right]!=0){
                int temp = nums[left];
                nums[left--] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    public int[] moveZerosToRight(int[] nums){
        int left = 0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=0){
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

}
