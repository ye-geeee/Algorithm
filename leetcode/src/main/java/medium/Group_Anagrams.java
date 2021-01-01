package medium;

import java.util.*;

public class Group_Anagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(new Group_Anagrams.Solution().groupAnagrams(strs));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> hash = new HashMap<>();

            for(String s : strs) {
                char[] key = s.toCharArray();
                Arrays.sort(key);

                String keyStr = String.valueOf(key);

                if (hash.containsKey(keyStr)) {
                    hash.get(keyStr).add(s);
                }
                else {
                    List<String> temp = new ArrayList<>();
                    temp.add(s);
                    hash.put(keyStr, temp);
                }
            }
            return new ArrayList<>(hash.values());
        }
    }
}
