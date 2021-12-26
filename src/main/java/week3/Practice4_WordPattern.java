package week3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Practice4_WordPattern {
    /*
    Pseudocode -
    1. check length of charArray of pattern and string array of s are equal.
        if no, retun false
    2. Put String, character in Map
    3. Traverse through loop,
        check if character in pattern is present. if yes, check value in map equals string array and if
        not return false
        otherwise add in map
     */

    @Test  //Positive
    public void example1(){
        String pattern = "abba", s="dog dog dog dog";
        System.out.println(wordPattern1(pattern,s));
    }

    // dog a
    // cat b
    // cat b
    // fish a

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
    }

    private boolean wordPattern(String pattern, String s){
        char[]  patternArray = pattern.toCharArray();
        String[] sArray = s.split(" ");
        if(sArray.length != patternArray.length) return false;

        Map<Character,String> hMap = new HashMap<>();

        for(int i=0;i<sArray.length;i++){
            if(!hMap.containsKey(patternArray[i])) hMap.put(patternArray[i],sArray[i]);
            else if (!hMap.get(patternArray[i]).equals(sArray[i])) return false;
        }

        return true;
    }

    private boolean wordPattern1(String pattern, String s){
        char[]  patternArray = pattern.toCharArray();
        String[] sArray = s.split(" ");
        if(sArray.length != patternArray.length) return false;

        Map<Character,String> patternMap = new HashMap<>();
        Map<String,Character> sMap = new HashMap<>();

        for(int i=0;i<sArray.length;i++){
            if(sMap.containsKey(sArray[i])){
                if(!sMap.get(sArray[i]).equals(patternArray[i])) return false;
            }

            if(!patternMap.containsKey(patternArray[i]) && !sMap.containsKey(sArray[i])){
                patternMap.put(patternArray[i],sArray[i]);
                sMap.put(sArray[i],patternArray[i]);
            }
            else if(!patternMap.get(patternArray[i]).equals(sArray[i])) return false;

        }

        return true;
    }

    /*
     * Hashing PsuedoCode
     *
     * Pattern -> Character (Key) : String (Value) &&
     * Data -> String (Key) : Character (Value)
     *
     * Iterate through each word of String and corresponding character in Pattern
     *     1) If it is new (no entry) on both -> add to the respective map
     *  2) If the character is not there but String in map -> return false
     *  3) If the character is there in map, then get the corresponding value & compare
     *      a) If it is not same as expected -> return false
     *
     *  If all above conditions passed through then return true
     *
     */

    private boolean wordPattern2(String pattern, String s){
        char[]  patternArray = pattern.toCharArray();
        String[] sArray = s.split(" ");
        if(sArray.length != patternArray.length) return false;

        Map<Character,String> patternMap = new HashMap<>();
        Map<String,Character> sMap = new HashMap<>();

        for(int i=0;i<sArray.length;i++){
            if(!patternMap.containsKey(patternArray[i]) && !sMap.containsKey(sArray[i])){
                patternMap.put(patternArray[i],sArray[i]);
                sMap.put(sArray[i],patternArray[i]);
            }
            else if(patternMap.containsKey(patternArray[i]) && sMap.containsKey(sArray[i])){
                if(!patternMap.get(patternArray[i]).equals(sArray[i]) ||
                        !sMap.get(sArray[i]).equals(patternArray[i])) return false;
            }
            else return false;

        }

        return true;
    }

}
