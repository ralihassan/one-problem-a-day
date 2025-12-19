class FindAllPeopleWithSecret {

    public List<Integer> findAllPeople(
        int n,
        int[][] meetings,
        int firstPerson
    ) {

        Map<Integer, List<int[]>> sameTimeMeeting = new TreeMap<>();

        for (int meeting[] : meetings) {
            sameTimeMeeting.computeIfAbsent(meeting[2], k -> new ArrayList<>());
            sameTimeMeeting.get(meeting[2]).add(new int[]{meeting[0], meeting[1]});

        }

        UnionFind unionFind = new UnionFind(n);
        unionFind.unite(0, firstPerson);

        for (int time : sameTimeMeeting.keySet()) {
            for (int meeting[]: sameTimeMeeting.get(time)) {
                unionFind.unite(meeting[0], meeting[1]);
            }

            for (int meeting[]: sameTimeMeeting.get(time)) {
                if (!unionFind.connected(meeting[0], 0)) {
                    unionFind.reset(meeting[0]);
                    unionFind.reset(meeting[1]);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (unionFind.connected(i, 0)) {
                res.add(i);
            }
        }

        return res;
    }
}

class UnionFind {

    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void unite(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public void reset(int x) {
        parent[x] = x;
        rank[x] = 0;
    }
}