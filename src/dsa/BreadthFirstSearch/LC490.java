package dsa.BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination){
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int M = maze.length;
        int N = maze[0].length;
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1])
                return true;
            for (int[] dir : dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                while (x >= 0 && x <= M && y >= 0 && y <= N && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (!visited[x][y]){
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
