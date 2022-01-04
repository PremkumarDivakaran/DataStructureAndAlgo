package week3;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Practice11_KDiffPair {
    /*
    Pseudocode -
    1. Initialize left = 0, right = 1, count = 0
    2. Sort given array using Arrays.sort
    3. Traverse through loop till right < nums.length
    4. Check if diff = k, increment count, left, right & continue
    5. Check if diff > k, increment left, right & continue
    6. Add one more condition, to check if next element is same, move left pointer to next
    7. Else increment right
    8. return count
     */

    @Test  //Positive
    public void example1(){
        int[] nums = new int[]{3,1,4,1,5};
        int k = 2;
        Assert.assertEquals(2,findPairs(nums,k));
        Assert.assertEquals(2,findPairs_1(nums,k));
        Assert.assertEquals(2,findPairs_2(nums,k));
    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[]{1,4,1,2,3};
        int k = 4;
        Assert.assertEquals(0,findPairs(nums,k));
        Assert.assertEquals(0,findPairs_1(nums,k));
        Assert.assertEquals(0,findPairs_2(nums,k));
    }

    @Test //Edge
    public void example3(){
        int[] nums = new int[]{1,3,1,5,4};
        int k = 0;
        Assert.assertEquals(1,findPairs(nums,k));
        Assert.assertEquals(1,findPairs_1(nums,k));
        Assert.assertEquals(1,findPairs_2(nums,k));
    }

    @Test //Edge
    public void example4(){
        int[] nums = new int[]{1,1,1,1,1};
        int k = 0;
        Assert.assertEquals(1,findPairs(nums,k));
        Assert.assertEquals(1,findPairs_1(nums,k));
        Assert.assertEquals(1,findPairs_2(nums,k));
    }


    private int findPairs(int[] nums, int k) {
        int left = 0, right = 1, count = 0;
        Arrays.sort(nums);

        while(right<nums.length){
            if(Math.abs(nums[left]-nums[right])>k || Math.abs(nums[left]-nums[right])==k){
                if(Math.abs(nums[left]-nums[right])==k) count++;
                while(left<nums.length-1 && nums[left]==nums[left+1]) left++;
                left++;
                right=left+1;
                continue;
            }else{
                right++;
            }
        }

        return count;
    }

    //HashMap
    private int findPairs_1(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> hMap = new HashMap<>();

        for(int eachElement:nums) hMap.put(eachElement,hMap.getOrDefault(eachElement,0)+1);

        for(Integer eachElement : hMap.keySet())
            if ((k == 0 && hMap.get(eachElement) > 1) ||
                    (k>0 && hMap.containsKey(eachElement+k))) count++;

        return count;
    }

    //HashSet
    private int findPairs_2(int[] nums, int k) {
        int count = 0;
        Set<Integer> hSet = new HashSet<>();

        for(int eachElement:nums) hSet.add(eachElement);

        if(k==0 && nums.length>hSet.size()) count = nums.length - hSet.size();

        for(Integer eachElement : hSet)
            if(k>0 && hSet.contains(eachElement+k)) count++;

        return count;
    }

}
