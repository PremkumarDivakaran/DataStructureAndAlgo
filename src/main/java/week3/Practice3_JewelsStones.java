package week3;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Practice3_JewelsStones {
    /*
    Pseudocode -
    1. Intialize counter
    1. convert stones into hashmap
    2. if covert jewel string into char array
    3. Iterate throurh array,
        a. if present, add value to counter
    4. Return counter
     */

    @Test  //Positive
    public void example1(){
        String jewels = "aA", stones = "aAAbbbb";
        Assert.assertEquals(numJewelsInStones(jewels,stones),3);
    }

    @Test //Negative
    public void example2(){
        String jewels = "z", stones = "ZZ";
        Assert.assertEquals(numJewelsInStones(jewels,stones),0);
    }

    @Test //Edge
    public void example3(){
        String jewels = "", stones = "ZZ";
        Assert.assertEquals(numJewelsInStones(jewels,stones),0);
    }

    @Test //Edge
    public void example4(){
        String jewels = "z", stones = "";
        Assert.assertEquals(numJewelsInStones(jewels,stones),0);
    }

    //Time Complexity - O[m+n]
    //Space Complexity - O[n]
    private int numJewelsInStones(String jewels, String stones) {
        int counter = 0;
        Map<Character,Integer> hMap = new HashMap<>();

        for(char eachChar:stones.toCharArray()) hMap.put(eachChar,hMap.getOrDefault(eachChar,0)+1);

        for(char eachChar:jewels.toCharArray()) if(hMap.containsKey(eachChar)) counter += hMap.get(eachChar);

        return counter;

    }

}
