package week6;

import org.junit.Test;

import java.util.*;
import java.util.Map.Entry;

public class Practice6_FrequencySort {

    @Test
    public void test1() {
        int[] data = {6,4,3,2,4,2};
        frequencySort(data);
    }

    private void frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<Entry<Integer,Integer>> lst = new ArrayList<>(map.entrySet());

        Collections.sort(lst, new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> entry1, Entry<Integer, Integer> entry2) {
                if(entry1.getValue() > entry2.getValue()) return 1;
                else if(entry1.getValue() < entry2.getValue()) return -1;
                else return 0;
            }
        });

        //Collections.sort(lst, Map.Entry.comparingByValue());
        System.out.println(lst);

        for (Entry<Integer, Integer> entry : lst) {
            Integer freq = entry.getValue();
            while(freq > 0) {
                System.out.println(entry.getKey());
                freq--;
            }
        }

        //System.out.println(Arrays.toString(nums));
    }
}
