package week6;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Practice7_ProductSort {
    /*
    Pseudocode -
    1. Iterate through array and store in hashmap (values store in sorted key, since hashcode
    of integer should stored in sorted order)
    2. Sort the map based on the values
    3. Iterate through map and store key in same input array based on frequency
     */

    @Test  //Positive
    public void example1(){
        int[] nums = {4,5,6,5,4,3};
        int[] out = {3,6,4,4,5,5};
        Assert.assertArrayEquals(out,findProductSort(nums));
    }

    @Test  //Positive
    public void example4(){
        int[] nums = {4, 5, 6, 4, 5, 3, 4};
        int[] out = {3, 6, 5, 5, 4, 4, 4};
        Assert.assertArrayEquals(out,findProductSort(nums));
    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
    }

    private int[] findProductSort(int[] nums){
        Map<Integer,Integer> hMap = new HashMap<>();
        for(int eachNum:nums) hMap.put(eachNum,hMap.getOrDefault(eachNum,0)+1);

        List<Map.Entry<Integer,Integer>> lst = new ArrayList<>(hMap.entrySet());

        Collections.sort(lst,Map.Entry.comparingByValue());

        int start = 0;
        for(int i=0;i<lst.size();i++){

            int freq = lst.get(i).getValue();
            while(freq>0){
                nums[start++] = lst.get(i).getKey().intValue();
                freq--;
            }
        }

        return nums;
    }

}
