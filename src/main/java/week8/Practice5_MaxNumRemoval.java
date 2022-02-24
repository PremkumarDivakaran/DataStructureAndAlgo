package week8;

import org.junit.Test;

public class Practice5_MaxNumRemoval {
    int count = 0;
    int maxCount = 0;

    @Test
    public void example1(){
        System.out.println(9%10);
        System.out.println(9/10);
        System.out.println(findMaxCount("aabcbc","abc"));
    }

    @Test
    public void example2(){
        System.out.println(findMaxCount("abababaaba","ababa"));
    }

    @Test
    public void example3(){
        System.out.println(findMaxCount("abaababaaaba","aba"));
    }

    private int removeString(String s, String t){
        if(!s.contains(t)) return count;
        else{
            count++;
            return removeString(s.replaceFirst(t,""),t);
        }
    }

    private int findMaxCount(String s, String t){
        int curCount = removeString(s,t);
        maxCount = Math.max(maxCount,curCount);
        count = 0;
        if(s.substring(s.indexOf(t)+1).contains(t))
            return findMaxCount(s.substring(s.indexOf(t)+1),t);
        return maxCount;
    }

}
