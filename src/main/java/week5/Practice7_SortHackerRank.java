package week5;

import org.junit.Test;

import java.util.*;

public class Practice7_SortHackerRank {

    @Test
    public void test1() {
        int[] data = {3,4,6,2,4,2};
        frequencySort(data);
    }

    private void frequencySort(int[] nums) {
        Map<Integer,Integer> tMap = new TreeMap<>();

        for(int i=0;i<nums.length;i++)
            tMap.put(nums[i], tMap.getOrDefault(nums[i],0)+1);

        List<Integer> valList = new ArrayList<>(tMap.values());
        Collections.sort(valList);

        List<Integer> out = new ArrayList<>();

        for(int i=0;i<valList.size();i++){
            for(Map.Entry<Integer,Integer> eachEntry:tMap.entrySet()){
                if(valList.get(i)==eachEntry.getValue()){
                    out.add(eachEntry.getKey());
                    tMap.put(eachEntry.getKey(),0);
                    break;
                }
            }
        }

        System.out.println(out);
    }



}
