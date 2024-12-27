import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TreeDiameter {

    public static void main(String[] args) {
        testTreeDiameter();
    }

    private static void testTreeDiameter() {
        TreeDiameter main = new TreeDiameter();

        // Test case 1: Simple linear tree
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}};
        int expected1 = 3;
        int result1 = main.treeDiameter(edges1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: Tree with a branch
        int[][] edges2 = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int expected2 = 3;
        int result2 = main.treeDiameter(edges2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3: Star-shaped tree
        int[][] edges3 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}};
        int expected3 = 2;
        int result3 = main.treeDiameter(edges3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4: Tree with multiple branches
        int[][] edges4 = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {4, 5}, {2, 6}};
        int expected4 = 5;
        int result4 = main.treeDiameter(edges4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));

        // Test case 5: Single node tree
        int[][] edges5 = {};
        int expected5 = 0;
        int result5 = main.treeDiameter(edges5);
        System.out.println("Test case 5: " + (result5 == expected5 ? "Passed" : "Failed"));

        // Test case 6: Single node tree
        int[][] edges6 = {{0,1}, {0,2}};
        int expected6 = 2;
        int result6 = main.treeDiameter(edges6);
        System.out.println("Test case 6: " + (result6 == expected6 ? "Passed" : "Failed"));
    }

    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) return 0;
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int edge[] : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        int nodes[] = dfs(graph, 0, new boolean[graph.size()]);
        return dfs(graph, nodes[0], new boolean[graph.size()])[1];
    }

    private int[] dfs(Map<Integer, ArrayList<Integer>> graph, int node, boolean visited[]) {
        visited[node] = true;
        int maxDistance = 0;
        int farthestNode = node;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                int result[] = dfs(graph, neighbor, visited);
                if (result[1] + 1 > maxDistance) {
                    maxDistance = result[1] + 1;
                    farthestNode = result[0];
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }

}