package week1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElementFromArray {
    /*
    Pseudocode :
    1. Declare List
    2. Traverse through array and if element not matches target, add it to list
    3. Declare new integer array with size equals to list size
    4. Traverse through list, add it new integer array
    5. return integer array
     */

    @Test
    public void example1(){
        int[] nums = {2,5,9,4,8,1};
        int target = 9;
        int[] output = {2,5,4,8,1};

        Assert.assertEquals(Arrays.toString(output)
                ,Arrays.toString(removeTargetInArray(nums,target)));
    }

    @Test
    public void example2(){

        int[] nums = {2,5,9,4,9,8,1,9};
        int target = 9;
        int[] output = {2,5,4,8,1};

        Assert.assertEquals(Arrays.toString(output)
                ,Arrays.toString(removeTargetInArray(nums,target)));

    }

    @Test
    public void example3(){
        int[] nums = {2,5,4,8,1};
        int target = 9;
        int[] output = {2,5,4,8,1};

        Assert.assertEquals(Arrays.toString(output)
                ,Arrays.toString(removeTargetInArray(nums,target)));
    }

    @Test
    public void example4(){
        int[] nums = {};
        int target = 9;
        int[] output = {};

        Assert.assertEquals(Arrays.toString(output)
                ,Arrays.toString(removeTargetInArray(nums,target)));
    }

    private int[] removeTargetInArray(int[] nums, int target){
        List<Integer> ls = new ArrayList<Integer>();

        for(int i=0;i< nums.length;i++) {
            if (nums[i] != target) ls.add(nums[i]);
        }

        int[] returnArray = new int[ls.size()];
        int start = 0;

        for(Integer eachInt : ls) {
            returnArray[start] = eachInt;
            start++;
        }

        return returnArray;

    }
}
