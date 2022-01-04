package week4;

import org.junit.Test;

import java.util.*;

public class Practice1_CheckPattern {
    /*
    Example 1:
String[] ch = {"abb", "abc", "xyz", "xyy"};
String pattern = "mnn";
Output: ["xyy","abb"] --> List -> Any order
Answer: xyy and abb have same character at index 1 and 2 like the pattern
Example 2:
String[] ch = {"abb", "abc", "xyz", "xyy"};
String pattern =  "mno";
Output: ["abc", "xyz"]
Output: abc and xyz have all distinct characters, similar to the pattern.
Example 3:
String[] ch = ["abb", "abc", "xyz", "xyy"];
String pattern = "aba";
Output: []
Pattern has same character at index 0 and 2. No word in dictionary follows the pattern.
    Pseudocode -
    1. Store pattern in map
    2. Iterate string array and store it in map
    3. Compare values of pattern and each element map
    4. If equals, add it in list
    5. clear temp map
     */

    @Test  //Positive
    public void example1(){
        String[] ch = {"abb", "abc", "xyz", "xyy"};
        String pattern = "mnn";
        System.out.println(solution1(ch,pattern));
    }

    @Test //Positive
    public void example2(){
        String[] ch = {"abb", "abc", "xyz", "xyy"};
        String pattern =  "mno";
        System.out.println(solution1(ch,pattern));
    }

    @Test //Negative
    public void example3(){
        String[] ch = {"abb", "abc", "xyz", "xyy"};
        String pattern = "mmm";
        System.out.println(solution1(ch,pattern));
    }

    private List<String> solution(String[] ch, String pattern){
        List<String> out = new ArrayList<>();
        Map<Character,Integer> patternMap = new LinkedHashMap<>();
        Map<Character,Integer> tempMap = new LinkedHashMap<>();

        for(char eachChar:pattern.toCharArray())
            patternMap.put(eachChar,patternMap.getOrDefault(eachChar,0)+1);

        for(String eachString:ch){
            for(int i=0;i<eachString.length();i++)
                tempMap.put(eachString.charAt(i),tempMap.getOrDefault(eachString.charAt(i),0)+1);

            //if((patternMap.values()).equals(tempMap.values())) out.add(eachString);

            tempMap.clear();
        }
        return out;
    }

    private List<String> solution1(String[] ch, String pattern){
        List<String> out = new ArrayList<>();

        for(String eachString:ch)
            if(checkPattern1(eachString,pattern)) out.add(eachString);

        return out;
    }

    private boolean checkPattern(String s, String pattern){
        char[]  patternArray = pattern.toCharArray();
        char[] sArray = s.toCharArray();
        if(sArray.length != patternArray.length) return false;

        Map<Character,Character> patternMap = new HashMap<>();
        Map<Character,Character> sMap = new HashMap<>();

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

    private boolean checkPattern1(String s, String pattern){
        int length = s.length();

        if(pattern.length()!=length) return false;

        int[] ch = new int[126];


        for(int i=0;i<length;i++){
            if(ch[(int)pattern.charAt(i)]==0 && Arrays.binarySearch(ch,(int)s.charAt(i))<0)
                ch[(int)pattern.charAt(i)]=s.charAt(i);
            else if(ch[(int)pattern.charAt(i)]!=s.charAt(i)) return false;
        }

        return true;
    }

    @Test
    public void testMethod(){
        int[] intArr = new int[]{1,2,3,5,8,4};

        System.out.println(Arrays.binarySearch(intArr,1));
        System.out.println(Arrays.binarySearch(intArr,3));
        System.out.println(Arrays.binarySearch(intArr,4));
    }

}
