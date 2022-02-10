package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Practice6_FirstNonRepeatingCharacter {

    @Test
    public void example1(){
        String s = "leetcode";
        Assert.assertEquals(0,firstUniqChar(s));
    }

    @Test
    public void example2(){
        String s = "aaabbb";
        Assert.assertEquals(-1,firstUniqChar(s));
    }

    @Test
    public void example3(){
        String s = "aaabbbbd";
        Assert.assertEquals(7,firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        Map<Character,Integer> hmap = new HashMap<>();
        char[] sArr = s.toCharArray();

        for(char eachChar:sArr)
            hmap.put(eachChar, hmap.getOrDefault(eachChar,0)+1);

        for(int i=0;i<sArr.length;i++){
            if(hmap.get(sArr[i])==1) return i;
        }

        return -1;
    }
}
