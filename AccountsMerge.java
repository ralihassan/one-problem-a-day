import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {
        AccountsMerge main = new AccountsMerge();
        main.testAccountsMerge();
    }

    public void testAccountsMerge() {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"));
        expected.add(Arrays.asList("John", "johnnybravo@mail.com"));
        expected.add(Arrays.asList("Mary", "mary@mail.com"));

        List<List<String>> result = accountsMerge(accounts);

        // Sort the result and expected lists for comparison
        for (List<String> list : result) {
            Collections.sort(list);
        }
        for (List<String> list : expected) {
            Collections.sort(list);
        }
        Collections.sort(result, (a, b) -> a.get(0).compareTo(b.get(0)));
        Collections.sort(expected, (a, b) -> a.get(0).compareTo(b.get(0)));

        assert result.equals(expected) : "Test failed!";
        System.out.println("Test passed!");
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for (List<String> account : accounts) {

            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                graph.computeIfAbsent(email, x -> new ArrayList<>());
                parent.put(email, name);

                if (i > 1) {
                    graph.get(account.get(i - 1)).add(email);
                    graph.get(email).add(account.get(i - 1));
                }
            }
        }

        Set<String> visited = new HashSet<>();

        List<List<String>> result = new ArrayList<>();
        for (String key : graph.keySet()) {
            if (!visited.contains(key)) {
                List<String> list = new ArrayList<>();
                dfs(key, graph, list, visited);
                Collections.sort(list);
                list.add(0, parent.get(key));
                result.add(list);
            }
        }

        return result;

    }

    private void dfs(String key, Map<String, List<String>> graph, List<String> list, Set<String> visited) {
        visited.add(key);
        list.add(key);
        for (String neighbor : graph.get(key)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, list, visited);
            }
        }
    }
}