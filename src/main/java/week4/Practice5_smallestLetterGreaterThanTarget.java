package week4;

import org.junit.Test;

public class Practice5_smallestLetterGreaterThanTarget {
    /*
    Pseudocode -
    1. Intialize left=0, right=letters.length-1
    2. Check if target-'a'<letters[0] or target-'a'>letters[letters.length-1]
                -- if yes return letters[0]
    3. Traverse through loop till left<=right
            a) initialize mid = (left+right)/2
            b) check if letters[mid]-'a'<=target-'a'
                    -- if yes, set left=mid+1
            c) check if letters[mid]-'a'>target-'a'
                    -- if yes, set right = mid-1
     4. return letters[left]
     */

    @Test  //Positive
    public void example1(){
        char[] letters = {'c','f','g'};
        char target = 'c';
        System.out.println(nextGreatestLetter(letters,target));
    }

    @Test //Negative
    public void example2(){
        char[] letters = {'c','f','g'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters,target));
    }

    @Test //Edge
    public void example3(){
        char[] letters = {'a'};
        char target = 'a';

        System.out.println(nextGreatestLetter(letters,target));
    }

    private char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        if (target-'a'>=letters[letters.length-1]-'a' || target-'a'<letters[0]-'a')
            return letters[0];

        while (left<=right) {
            int mid = (left + right) / 2;
            if(letters[mid]-'a'<=target-'a') left = mid+1;
            else right = mid-1;
        }
        return letters[left];
    }


}
