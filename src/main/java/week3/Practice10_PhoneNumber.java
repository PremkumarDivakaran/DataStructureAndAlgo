package week3;

import org.junit.Test;

import java.util.*;

public class Practice10_PhoneNumber {
    /*
    Pseudocode -

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
    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("5"));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();

        if(digits.length()==0) return out;
        else if(digits.length()==1) out = input.get(digits);
        else{

        }

        return out;
    }

}
