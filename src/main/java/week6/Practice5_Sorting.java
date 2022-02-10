package week6;

import org.junit.Assert;
import org.junit.Test;

public class Practice5_Sorting {

    @Test  //Positive
    public void example1() {
        int[] nums = {4, 11, 2, 17, 22, 18, 1, 8};
        int[] out = {1, 2, 4, 8, 11, 17, 18, 22};
        Assert.assertArrayEquals(out, bubbleSort(nums));
        Assert.assertArrayEquals(out, insertionSort(nums));
        Assert.assertArrayEquals(out, selectionSort(nums));
    }

    @Test  //Positive
    public void example2() {
        int[] nums = {1, 3, 5, 8};
        int[] out = {1, 3, 5, 8};
        Assert.assertArrayEquals(out, bubbleSort(nums));
        Assert.assertArrayEquals(out, insertionSort(nums));
        Assert.assertArrayEquals(out, selectionSort(nums));
    }

    @Test  //Positive
    public void example3() {
        int[] nums = {4, 11, -2, 17, -22, 18, 1, 8};
        int[] out = {-22, -2, 1, 4, 8, 11, 17, 18};
        Assert.assertArrayEquals(out, bubbleSort(nums));
        Assert.assertArrayEquals(out, insertionSort(nums));
        Assert.assertArrayEquals(out, selectionSort(nums));
    }

    @Test  //Positive
    public void example4() {
        int[] nums = {4, 4, 4, 4, 4};
        int[] out = {4, 4, 4, 4, 4};
        Assert.assertArrayEquals(out, bubbleSort(nums));
        Assert.assertArrayEquals(out, insertionSort(nums));
        Assert.assertArrayEquals(out, selectionSort(nums));
    }

    public int[] bubbleSort(int[] nums) {
        int counter = nums.length - 1;
        int temp;
        while(counter>0) {
            for (int i = 0; i < counter ; i++) {
                if (nums[i]>nums[i+1]) {
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            counter--;
        }

        return nums;
    }

    public int[] insertionSort(int[] nums) {
        int temp1, start, temp2;
        for(int i=0; i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                temp1 = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp1;
            }
            start = i;

            while(start>0 && nums[start]<nums[start-1]){
                temp2 = nums[start];
                nums[start] = nums[start-1];
                nums[start-1] = temp2;
                start--;
            }
        }

        return nums;
    }

    public int[] selectionSort(int[] nums) {
        int temp1, temp2;

        for(int i=0;i<nums.length-1;i++){
            temp1 = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[temp1]) temp1=j;
            }
            temp2 = nums[i];
            nums[i] = nums[temp1];
            nums[temp1] = temp2;
        }

        return nums;
    }
}
