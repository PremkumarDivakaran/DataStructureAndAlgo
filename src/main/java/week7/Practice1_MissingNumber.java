package week7;

import org.junit.Test;

import java.util.Arrays;

public class Practice1_MissingNumber {

    @Test
    public void example1(){
        int[] nums = {3,0,1};
        System.out.println(findMissingNum(nums));
    }

    @Test
    public void example2(){
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(findMissingNum(nums));
    }

    @Test
    public void example3(){
        int[] nums = {0,1};
        System.out.println(findMissingNum(nums));
    }

    private int findMissingNum(int[] nums) {
        int expectedSum = (nums.length * (nums.length+1))/2;
        int numsSum = Arrays.stream(nums).sorted().sum();
        return expectedSum-numsSum;
    }
}
