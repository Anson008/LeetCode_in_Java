package dsa.Graph.TopologicalSort;

import java.util.*;

public class LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++){
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            graph.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            indegree[end]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0)
                q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            count++;
            for (int neighbor : graph.getOrDefault(cur, new ArrayList<>())){
                if (--indegree[neighbor] == 0)
                    q.offer(neighbor);
            }
        }
        return count == numCourses;
    }
}
