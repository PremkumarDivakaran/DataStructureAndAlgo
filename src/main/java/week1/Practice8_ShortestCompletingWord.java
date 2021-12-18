package week1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Practice8_ShortestCompletingWord {
    /*
    Pseudocode -
    1. Convert String 'licenseplate' to string array
    2. Traverse through array and compare each string in licenseplate
        with each String in given array
    3. Intialize Arraylist and put each characters in string in list
    4. If 'licenseplate' each character present in the list, remove that
        character & continue

     */

    @Test  //Positive
    public void example1(){
    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
        //licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
        findShortestCompletingWord("1s3 PSt", new String[] {"step","steps"});
    }

    private void findShortestCompletingWord(String licensePlate, String[] words){
        String[] licensePlateArr = licensePlate.replaceAll("[^a-zA-Z]","").split("");
        int shortLength = 0;

        for(int i=0;i< licensePlateArr.length;i++){
            for(int j=0;j< words.length;j++){
                List<String> ls = Arrays.asList(words[j].split(""));

                if(ls.contains(licensePlateArr[i])){
                    ls.remove(licensePlateArr[i]);
                    continue;
                }

            }
        }


    }

}
