package week3;

import org.junit.Test;

import java.util.*;

public class Practice7_GroupAnagrams {
    /*
    Pseudocode -
    1. Initialize left = 0, right = 1, List<List<String>>, two maps - sourceMap, targetMap
    2. Traverse through given string array till left reaches end
    3. Validate string is empty, if not
        a. Initialize Local list and store strs[left] in the list
        b. put strs[left] in sourceMap & strs[right] in targetMap
        c. check both are equal
            if yes,
            a) add strs[right] to list
            b) reset strs[right]=""
        d. increment right
        e. reset sourceMap & targetMap
        f. add local list to List<List<String>>
     4. Return List<List<String>>
     */

    @Test  //Positive
    public void example1() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        //System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams_1(strs));
    }

    @Test //Negative
    public void example2() {
        String[] strs = new String[]{"", ""};
        System.out.println(groupAnagrams_1(strs));
    }

    @Test //Edge
    public void example3() {
        String[] strs = new String[]{"","",""};
        System.out.println(groupAnagrams_2(strs));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        Map<Character, Integer> sourceMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        List<List<String>> out = new ArrayList<>();

        for (int left = 0; left < strs.length; left++) {
            int right = left + 1;
            List<String> localList = new ArrayList<>();
            if (!strs[left].equals("0")) {
                localList.add(strs[left]);
                while (right < strs.length) {
                    for (int i = 0; i < strs[left].length(); i++)
                        sourceMap.put(strs[left].charAt(i), sourceMap.getOrDefault(strs[left].charAt(i), 0) + 1);
                    for (int i = 0; i < strs[right].length(); i++)
                        targetMap.put(strs[right].charAt(i), targetMap.getOrDefault(strs[right].charAt(i), 0) + 1);

                    if (sourceMap.equals(targetMap)) {
                        localList.add(strs[right]);
                        strs[right] = "0";
                    }

                    sourceMap.clear();
                    targetMap.clear();
                    right++;
                }
                out.add(localList);
            }
        }
        return out;
    }

    private List<List<String>> groupAnagrams_1(String[] strs) {
        List<String> input = new ArrayList<>();
        for (String eachElement : strs) {
            input.add(eachElement);
        }

        Map<Character, Integer> sourceMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        List<List<String>> out = new ArrayList<>();

        for (int left = 0; left < input.size(); left++) {
            int right = left + 1;
            List<String> localList = new ArrayList<>();
            localList.add(input.get(left));
            while (right < input.size()) {
                for (int i = 0; i < input.get(left).length(); i++)
                    sourceMap.put(input.get(left).charAt(i), sourceMap.getOrDefault(input.get(left).charAt(i), 0) + 1);
                for (int i = 0; i < input.get(right).length(); i++)
                    targetMap.put(input.get(right).charAt(i), targetMap.getOrDefault(input.get(right).charAt(i), 0) + 1);

                if (sourceMap.equals(targetMap)) {
                    localList.add(input.get(right));
                    input.remove(right);
                }

                sourceMap.clear();
                targetMap.clear();
                right++;
            }
            out.add(localList);
        }
        return out;
    }

    private List<List<String>> groupAnagrams_2(String[] strs) {
        Map<String,List<String>> hMap = new HashMap<>();

        for (String eachElement:strs) {
            char[] charArr = eachElement.toCharArray();
            Arrays.sort(charArr);
            String s = new String(charArr);
            hMap.putIfAbsent(s, new ArrayList<>());
            hMap.get(s).add(eachElement);
        }

        return new ArrayList<>(hMap.values());
    }

}
