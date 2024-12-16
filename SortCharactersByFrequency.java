import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        testFrequencySort();
    }

    public static void testFrequencySort() {
        SortCharactersByFrequency main = new SortCharactersByFrequency();

        // Test case 1: Basic functionality
        String input1 = "tree";
        String expected1 = "eert"; // or "eetr"
        String result1 = main.frequencySort(input1);
        System.out.println("Test case 1: " + (result1.equals(expected1) || result1.equals("eetr") ? "Passed" : "Failed"));

        // Test case 2: All characters are the same
        String input2 = "aaaa";
        String expected2 = "aaaa";
        String result2 = main.frequencySort(input2);
        System.out.println("Test case 2: " + (result2.equals(expected2) ? "Passed" : "Failed"));

        // Test case 3: Characters with the same frequency
        String input3 = "cccaaa";
        String expected3 = "aaaccc"; // or "cccaaa"
        String result3 = main.frequencySort(input3);
        System.out.println("Test case 3: " + (result3.equals(expected3) || result3.equals("cccaaa") ? "Passed" : "Failed"));

        // Test case 4: Single character
        String input4 = "z";
        String expected4 = "z";
        String result4 = main.frequencySort(input4);
        System.out.println("Test case 4: " + (result4.equals(expected4) ? "Passed" : "Failed"));

        // Test case 5: Empty string
        String input5 = "";
        String expected5 = "";
        String result5 = main.frequencySort(input5);
        System.out.println("Test case 5: " + (result5.equals(expected5) ? "Passed" : "Failed"));

        // Test case 6: Mixed case sensitivity
        String input6 = "Aabb";
        String expected6 = "bbAa"; // or "bbaA"
        String result6 = main.frequencySort(input6);
        System.out.println("Test case 6: " + (result6.equals(expected6) || result6.equals("bbaA") ? "Passed" : "Failed"));
    }

    public String frequencySort(String s) {
        
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);   
        }

        for (char c : map.keySet()) {
            pq.add(new Pair(c, map.get(c)));
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 0) {
            Pair p = pq.poll();
            for (int i=0; i<p.freq ; i++) {
                sb.append(p.c);
            }
        }

        return sb.toString();
    }

    public class Pair {
        char c;
        int freq;

        public Pair (char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

}
