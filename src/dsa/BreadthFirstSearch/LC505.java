package dsa.BreadthFirstSearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination){
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int M = maze.length;
        int N = maze[0].length;
        int[][] distance = new int[M][N];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> (a[2] - b[2]));
        pq.offer(new int[] {start[0], start[1], 0});
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            for (int[] dir : dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                int count = 0;
                while (x >= 0 && x <= M && y >= 0 && y <= N && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                if (distance[cur[0]][cur[1]] + count < distance[x][y]){
                    distance[x][y] = distance[cur[0]][cur[1]] + count;
                    pq.offer(new int[] {x, y, distance[x][y]});
                }
            }
        }

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private void bfs(int[][] maze, int[] start, int[][] distance, int[][] dirs){

    }
}
