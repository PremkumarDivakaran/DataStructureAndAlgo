package week5;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Practice6_DuplicatesHackerRank {


    @Test
    public void testMethod(){
        List<String> name = Arrays.asList("bat","ball","glove","shoe","glove");
        List<Integer> items1 = Arrays.asList(1, 2, 1, 4, 1);
        List<Integer> items2 = Arrays.asList(2, 1, 1, 3, 1);
        int count = 0;
        Set<String> nameSet = new HashSet<>();
        Set<Integer> items1Set = new HashSet<>();
        Set<Integer> items2Set = new HashSet<>();

        for(int i=0;i<name.size();i++){
            if(!nameSet.add(name.get(i)) && !items1Set.add(items1.get(i)) && !items2Set.add(items2.get(i)))
                count++;
            else{
                items1Set.add(items1.get(i));
                items2Set.add(items2.get(i));
            }
        }

        System.out.println(count);

    }

    @Test
    public void testMethod1(){
        List<String> name = Arrays.asList("bat","ball","glove","shoe","glove");
        List<Integer> items1 = Arrays.asList(1, 2, 1, 4, 1);
        List<Integer> items2 = Arrays.asList(2, 1, 1, 3, 1);
        int count = 0;
        Set<String> hSet = new HashSet<>();

        for(int i=0;i<name.size();i++)
            if(!hSet.add(name.get(i)+items1.get(i)+items2.get(i))) count++;


        System.out.println(count);

    }

}
