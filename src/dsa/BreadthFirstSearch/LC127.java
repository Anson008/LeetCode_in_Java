package dsa.BreadthFirstSearch;

import java.util.*;

public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        Queue<String> q = new ArrayDeque<>();

        if (!wordDict.contains(endWord))
            return 0;

        int n = beginWord.length();
        int step = 1;
        q.offer(beginWord);
        while (!q.isEmpty()){
            for (int i = q.size() - 1; i >= 0; i--){
                String cur = q.poll();
                if (cur.equals(endWord))
                    return step;
                char[] chars = cur.toCharArray();
                for (int j = 0; j < n; j++){
                    for (char c = 'a'; c <= 'z'; c++){
                        char temp = chars[j];
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (wordDict.contains(nextWord)){
                            if (nextWord.equals(endWord))
                                return step + 1;
                            wordDict.remove(nextWord);
                            q.offer(nextWord);
                        }
                        chars[j] = temp;
                    }
                }
            }
            step++;
        }

        return 0;
    }
}
