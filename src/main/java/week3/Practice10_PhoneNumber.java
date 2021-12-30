package week3;

import org.junit.Test;

import java.util.*;

public class Practice10_PhoneNumber {
    /*
    Pseudocode -

     */

    @Test  //Positive
    public void example1(){
    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
        System.out.println(letterCombinations("23"));
    }

    private List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();

        //input
        Map<String, List<String>> input = new HashMap<>();
        input.put("2",new ArrayList<>(Arrays.asList("a","b","c")));
        input.put("3",new ArrayList<>(Arrays.asList("d","e","f")));
        input.put("4",new ArrayList<>(Arrays.asList("g","h","i")));
        input.put("5",new ArrayList<>(Arrays.asList("j","k","l")));
        input.put("6",new ArrayList<>(Arrays.asList("m","n","o")));
        input.put("7",new ArrayList<>(Arrays.asList("p","q","r","s")));
        input.put("8",new ArrayList<>(Arrays.asList("t","u","v")));
        input.put("9",new ArrayList<>(Arrays.asList("w","x","y","z")));

        String[] digitsArray = digits.split("");

        List<String> ls1 = input.get("2");
        List<String> ls2 = input.get("3");

        for(int i=0;i<ls1.size();i++){
            for(int j=0;j<ls2.size();j++){
                out.add(ls1.get(i)+ls2.get(j));
            }
        }

        return out;
    }

}
