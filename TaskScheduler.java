import java.util.Arrays;

public class TaskScheduler {

    public static void main(String[] args) {
        TaskScheduler main = new TaskScheduler();
        main.testLeastInterval();
    }

    public static void testLeastInterval() {
        TaskScheduler scheduler = new TaskScheduler();

        // Test case 1: Simple case with no cooldown
        char[] tasks1 = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n1 = 0;
        int result1 = scheduler.leastInterval(tasks1, n1);
        System.out.println("Test case 1: " + (result1 == 6 ? "Passed" : "Failed"));

        // Test case 2: Simple case with cooldown
        char[] tasks2 = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n2 = 2;
        int result2 = scheduler.leastInterval(tasks2, n2);
        System.out.println("Test case 2: " + (result2 == 8 ? "Passed" : "Failed"));

        // Test case 3: All tasks are the same
        char[] tasks3 = { 'A', 'A', 'A', 'A' };
        int n3 = 3;
        int result3 = scheduler.leastInterval(tasks3, n3);
        System.out.println("Test case 3: " + (result3 == 13 ? "Passed" : "Failed"));

        // Test case 4: Tasks with no need for idle time
        char[] tasks4 = { 'A', 'B', 'C', 'D' };
        int n4 = 2;
        int result4 = scheduler.leastInterval(tasks4, n4);
        System.out.println("Test case 4: " + (result4 == 4 ? "Passed" : "Failed"));

        // Test case 5: Tasks with maximum frequency
        char[] tasks5 = { 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D', 'D' };
        int n5 = 2;
        int result5 = scheduler.leastInterval(tasks5, n5);
        System.out.println("Test case 5: " + (result5 == 10 ? "Passed" : "Failed"));
    }

    public int leastInterval(char[] tasks, int n) {

        int freq[] = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];

        int idleSlots = (maxFreq - 1) * n;

        for (int i = 24; i >= 0 && idleSlots > 0; i--) {
            idleSlots -= Math.min(freq[i], maxFreq - 1);
        }

        return tasks.length + Math.max(0, idleSlots);

    }

}
