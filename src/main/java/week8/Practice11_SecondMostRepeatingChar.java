package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Practice11_SecondMostRepeatingChar {

    @Test
    public void example1(){
        String s="amazon development center";
        Assert.assertEquals('n',mostRepeatingCharacter(s));
    }

    public char mostRepeatingCharacter(String s){
        s = s.replaceAll(" ","");
        Map<Character,Integer> map = new HashMap<>();
        for(char eachChar:s.toCharArray()) map.put(eachChar, map.getOrDefault(eachChar,0)+1);


        List<Map.Entry<Character,Integer>> charLst =
            map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());

        return charLst.get(1).getKey();

    }

}
