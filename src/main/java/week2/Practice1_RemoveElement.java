package week2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice1_RemoveElement {
    /*
     * static array and dynamic array !!
     *
     * static array --> Length fixed --> number of elements is declared at the begining
     * you cannot resize them --> resize?? --> create another array (Arrays.copyOf)
     *
     * Dynamic array --> Array size that can change (grow or shrink)
     * List / Set / Map
     *
     */

    // Constraint -->

    @Test // positive
    public void example1() {
        int[] nums = {5,3,2,1,2,3};
        int target =  3;
        //int[] out =  removeElement(nums, target);
        //int[] out =  removeElement_twoPointer(nums, target);
        System.out.println(Arrays.toString(removeElement_twoPointer(nums,target)));
        //Assert.assertTrue(Arrays.equals(out, new int[] {5,2,1,2}));

    }

    @Test // negative
    public void example3() {

        int[] nums = {};
        int target =  3;
        //int[] out =  removeElement(nums, target);
        int[] out =  removeElement_twoPointer(nums, target);
        Assert.assertTrue(Arrays.equals(out, new int[] {}));
    }

    /*
     * Traverse through each element in the array
     * Compare that element with the target
     * 	If matches --> ignore !
     * 	If does not match --> add to a list
     *
     * After the loop end, convert list to array
     * return the array
     *
     */

    public int[] removeElement(int[] nums, int target) {

        if(nums.length == 0) return nums; // negative cases first !!

        List<Integer> lst = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) { // traverse and add only if the element not matching
            if(nums[i] != target) lst.add(nums[i]);
        }

        int[] output = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            output[i] = lst.get(i);
        }

        return output;
    }

    //Time Complexity - O[n]
    public int[] removeElement_twoPointer(int[] nums, int target) {
        if(nums.length == 0) return nums;

        List<Integer> lst_1 = new ArrayList<Integer>();
        List<Integer> lst_2 = new ArrayList<Integer>();

        int left = 0, right = nums.length-1;

        while(left<right){
            if(nums[left] != target) lst_1.add(nums[left]);
            if(nums[right] != target) lst_2.add(nums[right],0);

            left++;
            right--;
        }
        lst_1.addAll(lst_2);
        System.out.println(lst_1);

        int[] output = new int[lst_1.size()];
        for (int i = 0; i < lst_1.size(); i++) {
            output[i] = lst_1.get(i);
        }

        return output;

        /*Arrays.stream(nums)
                .filter(n -> n!=target)
                .forEach(s -> System.out.println(s));*/

    }

    public void removeElement1(int[] nums, int target){
        int left = 0, right = 1;

        while(nums[left]!=target && nums[right]!=target){
            if(nums[left]==target){
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right++] = temp;
            }
            else{
                left++;
                right++;
            }
        }

        System.out.println(Arrays.toString(nums));

    }

    @Test
    public void testRunner(){
        int[] nums = {5,3,2,1,2,3};
        int target =  3;

        removeElement1(nums,target);
    }
}
