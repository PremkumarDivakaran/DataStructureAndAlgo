package week3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice8_RingsAndRods {
    /*
    Pseudocode -
    1. Initialize left =0, right =1, Map<Integer, List<String>>
    2. Traverse through string till right<string.length
        a. Add string.charAt(right), string.charAt(left) to Map
    3. Traverse through map
        a. Check value of keys contains R, G, B & if yes, increment counter
    4. Return counter
     */

    @Test  //Positive
    public void example1(){
        String rings = "B0R0G0R9R0B0G0";
        Assert.assertEquals(1,countPoints(rings));
    }

    @Test //Negative
    public void example2(){
        String rings = "G4";
        Assert.assertEquals(0,countPoints(rings));
    }

    @Test //Edge
    public void example3(){
        String rings = "B0G0R0B1R1G1";
        Assert.assertEquals(2,countPoints(rings));
    }

    private int countPoints(String rings) {
        int left = 0, right = 1, counter = 0;
        Map<Character, List<Character>> hMap = new HashMap<>();

        while(right<rings.length()){
            if(!hMap.containsKey(rings.charAt(right))){
                List<Character> ls = new ArrayList<>();
                ls.add(rings.charAt(left));
                hMap.put(rings.charAt(right),ls);
            }else{
                hMap.get(rings.charAt(right)).add(rings.charAt(left));
            }
            left += 2;
            right += 2;
        }

        for (Map.Entry eachEntry:hMap.entrySet())
            if(hMap.get(eachEntry.getKey()).contains('R') &&
                    hMap.get(eachEntry.getKey()).contains('G') &&
                    hMap.get(eachEntry.getKey()).contains('B')) counter++;

        return counter;
    }

}
