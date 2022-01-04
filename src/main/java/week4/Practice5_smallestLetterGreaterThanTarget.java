package week4;

import org.junit.Test;

public class Practice5_smallestLetterGreaterThanTarget {
    /*
    Pseudocode -
    1. Intialize left=0, right=letters.length-1
    2. Check if target-'a'<letters[0] or target-'a'>letters[letters.length-1]
                -- if yes return letters[0]
    3. Traverse through loop till left<right
            a) intialize mid = (left+right)/2
            b) check if left==mid, if yes increment left & mid (edge case)
            b) check if letters[mid]-'a'<=target-'a'
                    -- if yes, set left=mid & store character in out variable
            c) check if letters[mid]-'a'>target-'a'
                    -- if yes, set right = mid & store character in out variable
            d) check if letters[mid]-'a'<target-'a', set left=mid
     4. return out variable
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
        char out = 0;
        int in = target - 'a';
        int left = 0, right = letters.length - 1;

        if (in >= letters[letters.length - 1] - 'a' || in < letters[0] - 'a') return letters[0];

        while (left < right) {
            int mid = (left + right) / 2;

            if (left == mid) {
                mid++;
                left++;
            }

            if (letters[mid] - 'a' <= in) {
                left = mid;
                out = letters[mid];
            } else {
                right = mid;
                out = letters[mid];
            }
        }
        return out;
    }


}
