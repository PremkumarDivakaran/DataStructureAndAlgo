package week1;

import org.junit.Assert;
import org.junit.Test;

public class Practice6_subsequence {
    /*
    Pseudocode -
    1. Convert given strings to string arrays
    2. Traverse through arrays, starting with int start =0
    3. Set flag as false
    4. Check each element of target string is present in given string
        if yes, increment start with current index + 1 &
        set flag as true
        break inner loop
     5. Check flag is true/false in every iteration
            if false, return false
            if true, continue loop
     6. Return flag
     */

    /*
    Replace t using regex t.replaceAll([^abc],"")
     */

    @Test  //Positive
    public void example1(){
        String s = "abc", t = "ahbgdc";
        // Output : true
        Assert.assertTrue(findSubsequence(s,t));
    }

    @Test //Negative
    public void example2(){
        String s = "", t = "ahbgdc";
        // Output : true
        Assert.assertTrue(findSubsequence(s,t));
    }

    @Test //Negative
    public void example3(){
        String s = "abc", t = "";
        // Output : false
        Assert.assertFalse(
                findSubsequence(s,t));
    }

    @Test //Edge
    public void example4(){
        String s = "axc", t = "acbxgdc";
        // Output : true
        Assert.assertTrue(findSubsequence(s,t));
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
