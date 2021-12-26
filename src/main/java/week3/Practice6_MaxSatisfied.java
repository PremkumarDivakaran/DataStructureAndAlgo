package week3;

import org.junit.Assert;
import org.junit.Test;

public class Practice6_MaxSatisfied {
    /*
    Pseudocode -
    1. Initialize maxSum = 0, left = 0, right = minutes-1, maxSatified = 0
    2. Traverse through customer and grump array using sliding window for every 'minutes' elements
    till right reaches array length
            a. add customer satisfaction count to local window sum if grump array element is 1
            b. store left in index if localWindowSum > maxSum
            c. store max value in maxSum using Math.max(maxSum,localWindowSum)
     3. Traverse grump array starting from index stored in 2a, till less than index+minutes
            a. store '0' in indices
     4. Traverse through customer and grump array
            a. add customer satification count in maxSatified if corresponding grump element is '0'
     5. Return maxSatified
     */

    @Test  //Positive
    public void example1(){
        int[] customers = new int[]{9,9,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        int minutes = 3;

        Assert.assertEquals(29,maxSatisfied(customers,grumpy,minutes));
    }

    @Test //Negative
    public void example2(){
        int[] customers = new int[]{1};
        int[] grumpy = new int[]{0};
        int minutes = 1;

        Assert.assertEquals(1,maxSatisfied(customers,grumpy,minutes));
    }

    @Test //Edge
    public void example3(){
        int[] customers = new int[]{1,2};
        int[] grumpy = new int[]{0,1};
        int minutes = 0;

        Assert.assertEquals(1,maxSatisfied(customers,grumpy,minutes));
    }

    @Test //Edge
    public void example4(){
        int[] customers = new int[]{3,7};
        int[] grumpy = new int[]{0,0};
        int minutes = 2;

        Assert.assertEquals(10,maxSatisfied(customers,grumpy,minutes));
    }

    @Test //Edge
    public void example5(){
        int[] customers = new int[]{3,7};
        int[] grumpy = new int[]{0,1};
        int minutes = 2;

        Assert.assertEquals(10,maxSatisfied(customers,grumpy,minutes));
    }

    @Test //Edge
    public void example6(){
        int[] customers = new int[]{3,8,8,7,1};
        int[] grumpy = new int[]{1,1,1,1,1};
        int minutes = 3;

        Assert.assertEquals(23,maxSatisfied(customers,grumpy,minutes));
    }


    private int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start = 0, maxSum = 0, maxSatified = 0, sum = 0, index = 0;

        for(int i=0;i<customers.length;i++){
            if(i>=minutes){
                if(grumpy[start]!=0) sum -= customers[start++];
                else start++;
            }
            if(grumpy[i]==1) sum += customers[i];
            if(sum>maxSum) index = i;
            maxSum = Math.max(sum,maxSum);
        }

        if(index >= minutes)
            for(int i=index;i>index-minutes;i--) grumpy[i]=0;
        else
            for(int i=index;i>=0;i--) grumpy[i]=0;

        for(int i=0;i<customers.length;i++)
            if(grumpy[i]==0) maxSatified += customers[i];

        return maxSatified;
    }

}
