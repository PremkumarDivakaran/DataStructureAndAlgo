package week1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice9_IntersectionOfArray {
    /*
    Pseudocode -
    1. Intialize left as 1st array and right as 2nd array
    2. Traverse till left or right < corresponding array length
    3. if matches, print number
    4. if left>right right++
    5. if right>left left--
     */

    @Test  //Positive
    public void example1(){
        int[] arr1 = new int[]{2,3,5,6,8,10,43};
        int[] arr2 = new int[]{2,4,5,7,8,12};
        List<Integer> ls = Arrays.asList(2,5,8);
        Assert.assertEquals(intersectionOfArray(arr1,arr2),ls);

    }

    @Test //Negative
    public void example2(){

        int[] arr1 = new int[]{2,3,5,6,8,10,43};
        int[] arr2 = new int[]{1,4,7,9,12};
        List<Integer> ls = Arrays.asList();
        Assert.assertEquals(intersectionOfArray(arr1,arr2),ls);

    }

    @Test //Edge
    public void example3(){
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{1,4,7,9,12};
        List<Integer> ls = Arrays.asList();
        Assert.assertEquals(intersectionOfArray(arr1,arr2),ls);
    }

    //Time Complexity - O[n]
    private List<Integer> intersectionOfArray(int[] arr1, int[] arr2){
        List<Integer> ls = new ArrayList<>();

        if(arr1.length == 0 || arr1.length ==0) return ls;

        int left=0, right=0;
        while(left< arr1.length && right< arr2.length){
            if(arr1[left]==arr2[right]){
                ls.add(arr1[left]);
                left++;
                right++;
            }
            else if(arr1[left]<arr2[right]) left++;
            else right++;
        }

        return ls;
    }

}
