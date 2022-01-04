package week4;

import org.junit.Test;

public class Practice2_KthMissingElement {
    /*
    Pseudocode -
    1. Traverse loop till counter reaches k
    2. Traverse through array, and find number starting from 1 is present
    3. if not present, increment counter
    4. if counter reaches k, then return number
     */

    @Test  //Positive
    public void example1(){
    }

    @Test //Negative
    public void example2(){
        int[] arr = {1,2};
        int k=1;
        System.out.println(findKthPositive(arr,k));

    }

    @Test //Edge
    public void example3() {
        int[] arr = {2,3,4,7,11};
        int k=5;
        System.out.println(findKthPositive(arr,k));
    }

    public int findKthPositive(int[] arr, int k) {
        int counter = 0, missingElement = 0;

        while (counter<k) {
            missingElement++;
            boolean isPresent = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == missingElement){
                    isPresent = true;
                    break;
                }
                else isPresent = false;
            }

            if(!isPresent) counter++;
        }

        return missingElement;
    }



}
