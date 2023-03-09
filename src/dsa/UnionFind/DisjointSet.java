package dsa.UnionFind;

import java.util.*;

public class DisjointSet {
    private int[] _parent;
    private int[] _rank;

    public DisjointSet(int numElements){
        for (int i = 0; i < numElements; i++){
            _parent[i] = i;
        }
        Arrays.fill(_rank, 1);
    }

    public int find(int k){
        if (_parent[k] != k)
            _parent[k] = find(_parent[k]);
        return _parent[k];
    }

    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;
        if (_rank[rootA] < _rank[rootB]){
            _parent[rootA] = rootB;
        }
        else if (_rank[rootA] > _rank[rootB]){
            _parent[rootB] = rootA;
        }
        else{
            _parent[rootB] = rootA;
            _rank[rootA]++;
        }
    }
}
