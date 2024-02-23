package dsa.Graph.TopologicalSort;

import java.util.*;

public class LC210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; i++){
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            graph.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            indegree[end]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0)
                q.offer(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            res.add(cur);
            for (int neighbor : graph.getOrDefault(cur, new ArrayList<>())){
                if (--indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }

        int[] ans = new int[0];
        if (count == numCourses){
            ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++){
                ans[i] = res.get(i);
            }
        }

        return ans;
    }
}
