package week1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class Practice2_NumberOfConsecutive1 {
    /*
    Pseudocode -
    1. Intialize maxCount = 0
    2. Traverse through array
    3. If element is equal to '1'
        increment maxCount
        store max value in maxcount
    4. If element is not equal to '1'
        reset maxCount = 0
    5. Return maxCount

     */

    @Test //Positive
    public void example1(){
        int[] nums = new int[] {1,1,1,1,0,1,1,1};
        // output : 4
        Assert.assertEquals(numberOfConsecutiveOnes_Set(nums),4);
    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[] {0};
        //output : 0
        Assert.assertEquals(numberOfConsecutiveOnes_Set(nums),0);
    }

    @Test //Edge
    public void example3(){
        int[] nums = new int[] {1,0,0,0,0,1};
        //Output : 1
        Assert.assertEquals(numberOfConsecutiveOnes_Set(nums),1);
    }

    private int numberOfConsecutiveOnes(int[] nums){
        int maxCount = 0, maxConsecutiveCount = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                maxConsecutiveCount++;
            }
            else{
                maxConsecutiveCount = 0;
            }
            maxCount = Math.max(maxCount,maxConsecutiveCount);
        }

        return maxCount;

    }
    //Time Complexity -> O[n]


    private int numberOfConsecutiveOnes_Set(int[] nums){
        HashSet<Integer> hSet = new HashSet<>();
        int maxCount = 0, maxConsecutiveCount=0;

        for(int i=0; i<nums.length;i++){
            if(nums[i] != 1) maxConsecutiveCount = 0;
            else maxConsecutiveCount++;
            maxCount = Math.max(maxConsecutiveCount,maxCount);
        }

        return maxCount;
    }

}
