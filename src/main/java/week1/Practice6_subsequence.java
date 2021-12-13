package week1;

import org.junit.Assert;
import org.junit.Test;

public class Practice6_subsequence {
    /*
    Pseudocode -
     */

    @Test  //Positive
    public void example1(){
        String s = "axc", t = "ahbgdc";
        Assert.assertTrue(findSubsequence(s,t));
    }

    @Test //Negative
    public void example2(){

    }

    @Test //Edge
    public void example3(){
    }

    private boolean findSubsequence(String s, String t){
        if(s.isEmpty()) return true;
        if(t.isEmpty()) return false;

        String[] sArr = s.split("");
        String[] tArr = t.split("");
        int start = 0;
        boolean isSubsequence = false;

        for(int i=0;i<sArr.length;i++){
            isSubsequence = false;
            for(int j=start;j<tArr.length;j++){
                if(sArr[i].equalsIgnoreCase(tArr[j])){
                    start = j+1;
                    isSubsequence = true;
                    break;
                }
            }

            if(!isSubsequence) return false;
        }

        return isSubsequence;
    }

}
