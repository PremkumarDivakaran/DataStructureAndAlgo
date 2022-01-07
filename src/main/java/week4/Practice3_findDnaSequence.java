package week4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Practice3_findDnaSequence {
    /*
    Pseudocode -
    1. Initialize set, left = 0, right = 10, output list
    2. Traverse through loop till right <= string.length
    3. Check substring(left,right) is added in set
            a) if not, check output list contains substring(left,right)
                a. if not, add substring(left,right) in set
    4. return list
     */

    @Test  //Positive
    public void example1(){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    @Test //Negative
    public void example2(){
        String s = "AAAAACCCCC";
        System.out.println(findRepeatedDnaSequences(s));
    }

    @Test //Edge
    public void example3(){
        String s = "AAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }

    private List<String> findRepeatedDnaSequences(String s) {
        List<String> out = new ArrayList<>();
        Set<String> hSet = new HashSet<>();
        int left = 0, right = 10;

        if(s.length()<=right) return out;

        while(right<=s.length()){
            if(!hSet.add(s.substring(left,right)))
                if(!out.contains(s.substring(left,right)))
                    out.add(s.substring(left,right));

            left++;
            right++;

        }

        return out;
    }

}
