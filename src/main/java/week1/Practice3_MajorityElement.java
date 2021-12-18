package week1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Practice3_MajorityElement {
    /*
    Pseudocode -
    1. Traverse through array & store it in a map
    2. If value of map is greater than n/2
        return corresponding key
     */

    /*
    Pseudocode -
    1. Sort array
    2. Get middle element (n/2) and return it
     */

    @Test  //Positive
    public void example1(){
        int[] nums = new int[] {2,2,1,1,1,2,2};
        // Output : 2
        Assert.assertEquals(findMajorityElement(nums),2);
    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[] {};
        // Output : 0
        Assert.assertEquals(findMajorityElement(nums),0);
    }

    @Test //Edge
    public void example3(){
        int[] nums = new int[] {5};
        // Output : 5
        Assert.assertEquals(findMajorityElement(nums),5);
    }

    private int findMajorityElement(int[] nums){
        int result = 0;
        Map<Integer,Integer> hmap = new HashMap<>();

        for(int eachItem : nums)
            hmap.put(eachItem, hmap.getOrDefault(eachItem,0)+1);

        for(Map.Entry<Integer,Integer> eachEntry : hmap.entrySet()){
            if(eachEntry.getValue()> nums.length/2) result = eachEntry.getKey().intValue();
        }

        return result;
    }

}
