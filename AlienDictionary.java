import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary main = new AlienDictionary();
        main.testAlienOrder();
        // main.testDeserialize();
    }

    public void testAlienOrder() {
        // Test case 1: Basic test case
        String[] words1 = { "wrt", "wrf", "er", "ett", "rftt" };
        String result1 = alienOrder(words1);
        System.out.println("Test case 1: " + result1);
        // Expected output: "wertf" or any valid topological order

        // Test case 2: Single word
        String[] words2 = { "z" };
        String result2 = alienOrder(words2);
        System.out.println("Test case 2: " + result2);
        // Expected output: "z"

        String[] words3 = { "abc", "ab" };
        String result3 = alienOrder(words3);
        System.out.println("Test case 3: " + result3);
        // Expected output: "" (invalid order)

        // Test case 4: No valid order
        String[] words4 = { "z", "x", "z" };
        String result4 = alienOrder(words4);
        System.out.println("Test case 4: " + result4);
        // Expected output: "" (invalid order)

        // Test case 5: Complex case
        String[] words5 = { "z", "x", "a", "zb", "zx" };
        String result5 = alienOrder(words5);
        System.out.println("Test case 5: " + result5);
        // Expected output: "zxab" or any valid topological order
    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int minLength = Math.min(first.length(), second.length());

            if (second.length() < first.length() && first.startsWith(second)) {
                return "";
            }

            for (int j = 0; j < minLength; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);

                if (parent != child) {
                    if (!map.get(parent).contains(child)) {
                        map.get(parent).add(child);
                        inDegree.put(child, inDegree.get(child) + 1);
                    }
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);

            for (char temp : map.get(c)) {
                inDegree.put(temp, inDegree.get(temp) - 1);
                if (inDegree.get(temp) == 0) {
                    queue.add(temp);
                }
            }
        }

        if (sb.length() != inDegree.size()) {
            return "";
        }

        return sb.toString();
    }
}
