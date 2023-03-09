package dsa.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class WordPatternMatch {
    public void runTest(){
        String s1 = "aaa";
        String p1 = "ab";
        Map<Character, String> mapping = new HashMap<>();
        System.out.println("Is match? " + isMatch(s1, 0, p1, 0, mapping));
    }

    public boolean isMatch(String word, int i, String pattern, int j,
                                  Map<Character, String> map)
    {
        int n = word.length(), m = pattern.length();

        // invalid word
        if (word.isEmpty() || pattern.isEmpty() || word.length() < pattern.length()) {
            System.out.println("End 1");
            return false;
        }

        // if both pattern and the string reaches the end
        if (i == n && j == m) {
            System.out.println("End 0");
            return true;
        }

        // if either string or pattern reaches the end
        if (i == n || j == m) {
            System.out.println("End 2");
            return false;
        }

        // consider the next character from the pattern
        char curr = pattern.charAt(j);
        System.out.printf("The %dth pattern %s%n", j, curr);

        // if the character is seen before
        if (map.containsKey(curr))
        {
            String s = map.get(curr);
            int k = s.length();

            // `ss` stores next `k` characters of the given string
            String ss;
            if (i + k < word.length()) {
                ss = word.substring(i, i + k);
            }
            else {
                ss = word.substring(i);
            }
            System.out.printf("ss starting at %d: %s\n", i, ss);
            // return false if the next `k` characters don't match with `s`
            if (ss.compareTo(s) != 0) {
                System.out.println("End 3");
                return false;
            }

            // recur for remaining characters if the next `k` characters match
            return isMatch(word, i + k, pattern, j + 1, map);
        }

        // process all remaining characters in the string if the current
        // character is never seen before
        for (int k = 1; k <= n - i; k++)
        {
            // insert substring formed by next `k` characters of the string
            // into the map
            System.out.printf("Substring starting at %d: %s\n", i, word.substring(i, i + k));
            System.out.printf("Current i = %d, j = %d\n", i, j);
            map.put(curr, word.substring(i, i + k));
            for (Character pchar: map.keySet()){
                String key = pchar.toString();
                String value = map.get(pchar);
                System.out.printf("key: %s, value: %s\n", key, value);
            }

            // check if it leads to the solution
            if (isMatch(word, i + k, pattern, j + 1, map)) {
                return true;
            }

            // otherwise, backtrack – remove the current character from the map
            map.remove(curr);
        }

        System.out.println("End 4");
        return false;
    }
}
