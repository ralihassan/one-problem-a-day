import java.util.Arrays;
import java.util.List;

public class NMeetingsinOneRoom {

    public static void main(String[] args) {
        NMeetingsinOneRoom main = new NMeetingsinOneRoom();
        main.testMaxMeetings();
    }

    public static void testMaxMeetings() {
        NMeetingsinOneRoom main = new NMeetingsinOneRoom();

        // Test case 1: Simple case with non-overlapping meetings
        List<Integer> start1 = Arrays.asList(1, 3, 0, 5, 8, 5);
        List<Integer> end1 = Arrays.asList(2, 4, 6, 7, 9, 9);
        int result1 = main.maxMeetings(start1, end1);
        System.out.println("Test case 1: " + (result1 == 4 ? "Passed" : "Failed"));

        // Test case 2: All meetings overlap
        List<Integer> start2 = Arrays.asList(1, 1, 1, 1);
        List<Integer> end2 = Arrays.asList(2, 2, 2, 2);
        int result2 = main.maxMeetings(start2, end2);
        System.out.println("Test case 2: " + (result2 == 1 ? "Passed" : "Failed"));

        // Test case 3: No meetings
        List<Integer> start3 = Arrays.asList();
        List<Integer> end3 = Arrays.asList();
        int result3 = main.maxMeetings(start3, end3);
        System.out.println("Test case 3: " + (result3 == 0 ? "Passed" : "Failed"));

        // Test case 4: Meetings with same start and end time
        List<Integer> start4 = Arrays.asList(1, 2, 3);
        List<Integer> end4 = Arrays.asList(1, 2, 3);
        int result4 = main.maxMeetings(start4, end4);
        System.out.println("Test case 4: " + (result4 == 3 ? "Passed" : "Failed"));

        // Test case 5: Large number of meetings
        List<Integer> start5 = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
        List<Integer> end5 = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        int result5 = main.maxMeetings(start5, end5);
        System.out.println("Test case 5: " + (result5 == 10 ? "Passed" : "Failed"));
    }

    public int maxMeetings(List<Integer> start, List<Integer> end) {
        int meetings[][] = new int[start.size()][2];

        for (int i = 0; i < start.size(); i++) {
            meetings[i] = new int[] { start.get(i), end.get(i) };
        }

        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 0;
        int last = -1;

        for (int meeting[] : meetings) {
            if (meeting[0] >= last) {
                last = meeting[1];
                count++;
            }
        }

        return count;
    }

}
