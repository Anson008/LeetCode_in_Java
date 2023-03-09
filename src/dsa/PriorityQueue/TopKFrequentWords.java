package dsa.PriorityQueue;

import java.util.*;

public class TopKFrequentWords {
    private class Node{
        String word;
        int count;
        Node(String s){
            word = s;
            count = 1;
        }
        void inc(){
            count++;
        }
    }

    public void runTest(){
        String[] words = {"d","a","c","b","d","a","b","b","a","d","d","a","d"};
        int k = 5;
        String[] topK = topKFrequent(words, k);
        for (int i = 0; i < topK.length; i++){
            System.out.println(topK[i]);
        }
    }

    public String[] topKFrequent(String[] words, int k) {
        // Write your solution here
        HashMap<String, Node> wordFreq = new HashMap<>();
        for (String word : words){
            if (!wordFreq.containsKey(word))
                wordFreq.put(word, new Node(word));
            else
                wordFreq.get(word).inc();
        }

        PriorityQueue<Node> pQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b){
                int result = b.count - a.count;
                if (result == 0)
                    return b.word.compareTo(a.word);
                return result;
            }
        });

        for (Map.Entry<String, Node> entry : wordFreq.entrySet()){
            pQueue.offer(entry.getValue());
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++){
            if (pQueue.size() == 0)
                break;
            res.add(pQueue.poll().word);
        }
        String[] array = res.toArray(new String[res.size()]);
        return array;
    }
}
