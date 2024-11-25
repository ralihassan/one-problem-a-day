import java.util.*;

public class ConnectedComponentsinGraph {

    public static void main(String[] args) {
        ConnectedComponentsinGraph main = new ConnectedComponentsinGraph();
        main.testCountComponents();
    }

    public void testCountComponents() {
        // Test case 1: No edges, multiple nodes
        int n1 = 5;
        int[][] edges1 = {};
        int result1 = countComponents(n1, edges1);
        System.out.println("Test case 1: " + result1); // Expected: 5

        // Test case 2: Single component
        int n2 = 5;
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
        int result2 = countComponents(n2, edges2);
        System.out.println("Test case 2: " + result2); // Expected: 1

        // Test case 3: Two components
        int n3 = 5;
        int[][] edges3 = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        int result3 = countComponents(n3, edges3);
        System.out.println("Test case 3: " + result3); // Expected: 2

        // Test case 4: All nodes isolated
        int n4 = 3;
        int[][] edges4 = {};
        int result4 = countComponents(n4, edges4);
        System.out.println("Test case 4: " + result4); // Expected: 3

        // Test case 5: Complex graph with multiple components
        int n5 = 6;
        int[][] edges5 = { { 0, 1 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        int result5 = countComponents(n5, edges5);
        System.out.println("Test case 5: " + result5); // Expected: 2
    }

    public int countComponents(int n, int[][] edges) {
        ArrayList<Integer> arr[] = new ArrayList[n];
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int edge[] : edges) {
            arr[edge[0]].add(edge[1]);
            arr[edge[1]].add(edge[0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                helper(arr, visited, i);
            }
        }

        return count;
    }

    private void helper(ArrayList<Integer> arr[], boolean visited[], int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (int node : arr[i]) {
            if (!visited[node]) {
                helper(arr, visited, node);
            }
        }
    }
}