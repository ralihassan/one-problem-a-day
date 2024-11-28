import java.util.*;

public class NQueens {

    public static void main(String[] args) {
        NQueens main = new NQueens();
        main.testSolveNQueens();
    }

    public static void testSolveNQueens() {
        NQueens main = new NQueens();

        // Test case 1: 1-Queen problem
        int n1 = 1;
        List<List<String>> expected1 = Arrays.asList(Arrays.asList("Q"));
        List<List<String>> result1 = main.solveNQueens(n1);
        System.out.println("Test case 1: " + (result1.equals(expected1) ? "Passed" : "Failed"));

        // Test case 2: 2-Queens problem (no solution)
        int n2 = 2;
        List<List<String>> expected2 = new ArrayList<>();
        List<List<String>> result2 = main.solveNQueens(n2);
        System.out.println("Test case 2: " + (result2.equals(expected2) ? "Passed" : "Failed"));

        // Test case 3: 3-Queens problem (no solution)
        int n3 = 3;
        List<List<String>> expected3 = new ArrayList<>();
        List<List<String>> result3 = main.solveNQueens(n3);
        System.out.println("Test case 3: " + (result3.equals(expected3) ? "Passed" : "Failed"));

        // Test case 4: 4-Queens problem
        int n4 = 4;
        List<List<String>> expected4 = Arrays.asList(
                Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
                Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));
        List<List<String>> result4 = main.solveNQueens(n4);
        System.out.println("Test case 4: " + (result4.equals(expected4) ? "Passed" : "Failed"));

        // Test case 5: 5-Queens problem
        int n5 = 5;
        List<List<String>> result5 = main.solveNQueens(n5);
        System.out.println("Test case 5: " + (result5.size() > 0 ? "Passed" : "Failed"));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, createQueen(i, n));
            set.add(i);
        }

        for (int i = 0; i < n; i++) {
            set.remove(i);
            cur.add(map.get(i));
            bt(result, cur, set, map, i, n);
            cur.remove(cur.size() - 1);
            set.add(i);
        }

        return result;
    }

    private void bt(List<List<String>> result, List<String> cur, Set<Integer> set, Map<Integer, String> map,
            int previous, int n) {
        if (cur.size() == n) {
            result.add(new ArrayList<>(cur));
        }

        for (int i = 0; i < n; i++) {
            if (!set.contains(i) || i - 1 == previous || i + 1 == previous) {
                continue;
            }
            set.remove(i);
            cur.add(map.get(i));
            bt(result, cur, set, map, i, n);
            cur.remove(cur.size() - 1);
            set.add(i);
        }

    }

    private String createQueen(int pos, int length) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (i == pos) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

}