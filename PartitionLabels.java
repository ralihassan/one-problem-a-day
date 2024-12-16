import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels main = new PartitionLabels();
        main.testPartitionLabels();
    }

    public static void testPartitionLabels() {
        PartitionLabels main = new PartitionLabels();

        // Test case 1: Simple case with distinct partitions
        String s1 = "ababcbacadefegdehijhklij";
        List<Integer> result1 = main.partitionLabels(s1);
        System.out.println("Test case 1: " + (result1.equals(List.of(9, 7, 8)) ? "Passed" : "Failed"));

        // Test case 2: Single character string
        String s2 = "a";
        List<Integer> result2 = main.partitionLabels(s2);
        System.out.println("Test case 2: " + (result2.equals(List.of(1)) ? "Passed" : "Failed"));

        // Test case 3: All characters are the same
        String s3 = "aaaa";
        List<Integer> result3 = main.partitionLabels(s3);
        System.out.println("Test case 3: " + (result3.equals(List.of(4)) ? "Passed" : "Failed"));

        // Test case 4: Characters with no overlap
        String s4 = "abc";
        List<Integer> result4 = main.partitionLabels(s4);
        System.out.println("Test case 4: " + (result4.equals(List.of(1, 1, 1)) ? "Passed" : "Failed"));

        // Test case 5: Overlapping partitions
        String s5 = "eccbbbbdec";
        List<Integer> result5 = main.partitionLabels(s5);
        System.out.println("Test case 5: " + (result5.equals(List.of(10)) ? "Passed" : "Failed"));
    }

    public List<Integer> partitionLabels(String s) {

        int indexes[] = new int[26];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            indexes[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, indexes[s.charAt(i) - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }

}
