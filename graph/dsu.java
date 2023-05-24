package graph;

public class dsu {
    int[] rank, root;
    int unique;

    dsu(int n) {
        unique = n;
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if (root[x] == x)
            return x;

        return root[x] = find(root[x]);
    }

    void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rank[rootx] < rank[rooty]) {
            root[rootx] = rooty;
        } else if (rank[rootx] > rank[rooty]) {
            root[rooty] = rootx;
        } else {
            root[rooty] = rootx;
            rank[rootx]++;
        }
    }

    boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
