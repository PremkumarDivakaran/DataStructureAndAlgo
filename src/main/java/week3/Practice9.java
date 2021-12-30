package week3;

import org.junit.Test;

import java.util.*;

public class Practice9 {
    /*
    Pseudocode -
     */

    @Test  //Positive
    public void example1(){
        String s = "This is is my friend";
        String[] sArr = s.split("\\W");
        int start = 0;
        Set<String> hSet = new LinkedHashSet<>();
        List<String> aLs = new ArrayList<>();


        for (String eachElement:sArr) hSet.add(eachElement);

        for (String eachElement:hSet)
            sArr[start++] = eachElement;


    }

    @Test //Negative
    public void example2(){
        int[] nums = new int[]{1,2,3,2,3,2,3,4};

        Map<Integer,Integer> hMap = new HashMap<>();
        for (int eachElement:nums) hMap.put(eachElement,hMap.getOrDefault(eachElement,0)+1);

        for(Map.Entry<Integer,Integer> eachEntry : hMap.entrySet())
            if(eachEntry.getValue()>1) System.out.println(eachEntry.getKey());



    }

    @Test //Edge
    public void example3(){
        int[] nums = new int[]{2, 43, 22, 44, 32, 56, 780, 23, 4, 12, 0, 789, 1};

        int maxSum = 0, left = 0, right =1;

        while(right<nums.length){
            int windowSum = nums[left++] + nums[right++];
            maxSum = Math.max(windowSum,maxSum);
        }
        System.out.println(maxSum);
    }

    private void solution(){

    }

}
