package week3;

import org.junit.Test;

import java.util.*;

public class Practice10_PhoneNumber {
    /*
    Pseudocode -
    1. Store numbers & character in Map
    2. Create function to find combination for two list
    3. Start with first 2 digits, find possible combinations and store it in list
    4. Iterate with remaining digits, pass list from step 3 and next digit
    5. Store result in same list
    6. Return list
     */

    //Input
    static Map<String, List<String>> input = new HashMap<>();
    static {
        input.put("2",new ArrayList<>(Arrays.asList("a","b","c")));
        input.put("3",new ArrayList<>(Arrays.asList("d","e","f")));
        input.put("4",new ArrayList<>(Arrays.asList("g","h","i")));
        input.put("5",new ArrayList<>(Arrays.asList("j","k","l")));
        input.put("6",new ArrayList<>(Arrays.asList("m","n","o")));
        input.put("7",new ArrayList<>(Arrays.asList("p","q","r","s")));
        input.put("8",new ArrayList<>(Arrays.asList("t","u","v")));
        input.put("9",new ArrayList<>(Arrays.asList("w","x","y","z")));
    }

    @Test  //Positive
    public void example1(){
        System.out.println(letterCombinations("7296"));
    }

    @Test //Negative
    public void example2(){
        System.out.println(letterCombinations(""));
    }

    @Test //Edge
    public void example3(){
        System.out.println(letterCombinations("5"));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();

        if(digits.length()==0) return out;
        else if(digits.length()==1) return input.get(digits);

        out = findCombinations(input.get(String.valueOf(digits.charAt(0))),
                input.get(String.valueOf(digits.charAt(1))));

        for(int i=2;i<digits.length();i++)
            out = findCombinations(out,input.get(String.valueOf(digits.charAt(i))));

        return out;
    }

    private static List<String> findCombinations(List<String> ls1, List<String> ls2){
        List<String> combinations = new ArrayList<>();
        for(int i=0;i<ls1.size();i++)
            for(int j=0;j<ls2.size();j++) combinations.add(ls1.get(i)+ls2.get(j));

        return combinations;
    }

}
