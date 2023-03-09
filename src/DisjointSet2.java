import java.util.Arrays;

public class DisjointSet2 {
    int[] _parent;
    int[] _size;

    public DisjointSet2(int num){
        _parent = new int[num];
        _size = new int[num];
        for (int i = 0; i < num; i++){
            _parent[i] = i;
        }
        Arrays.fill(_size, 1);
    }

    public int find(int x){
        if (_parent[x] != x)
            _parent[x] = find(_parent[x]);
        return _parent[x];
    }

    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB)
            return;
        if (_size[rootA] <= _size[rootB]){
            _parent[rootA] = rootB;
            _size[rootB] += _size[rootA];
        }
        else{
            _parent[rootB] = rootA;
            _size[rootA] += _size[rootB];
        }
    }
}
