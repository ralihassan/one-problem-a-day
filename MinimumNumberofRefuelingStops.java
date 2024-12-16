import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops {

    public static void main(String[] args) {
        MinimumNumberofRefuelingStops main = new MinimumNumberofRefuelingStops();
        main.testMinRefuelStops();
    }

    public static void testMinRefuelStops() {
        MinimumNumberofRefuelingStops main = new MinimumNumberofRefuelingStops();

        // Test case 1: No refueling needed
        int target1 = 1;
        int startFuel1 = 1;
        int[][] stations1 = {};
        int result1 = main.minRefuelStops(target1, startFuel1, stations1);
        System.out.println("Test case 1: " + (result1 == 0 ? "Passed" : "Failed"));

        // Test case 2: Impossible to reach the target
        int target2 = 100;
        int startFuel2 = 1;
        int[][] stations2 = { { 10, 100 } };
        int result2 = main.minRefuelStops(target2, startFuel2, stations2);
        System.out.println("Test case 2: " + (result2 == -1 ? "Passed" : "Failed"));

        // Test case 3: Multiple refueling stops needed
        int target3 = 100;
        int startFuel3 = 10;
        int[][] stations3 = { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } };
        int result3 = main.minRefuelStops(target3, startFuel3, stations3);
        System.out.println("Test case 3: " + (result3 == 2 ? "Passed" : "Failed"));

        // Test case 4: Just enough fuel with one stop
        int target4 = 100;
        int startFuel4 = 50;
        int[][] stations4 = { { 25, 25 }, { 50, 50 } };
        int result4 = main.minRefuelStops(target4, startFuel4, stations4);
        System.out.println("Test case 4: " + (result4 == 1 ? "Passed" : "Failed"));

        // Test case 5: No stations, not enough fuel
        int target5 = 100;
        int startFuel5 = 50;
        int[][] stations5 = {};
        int result5 = main.minRefuelStops(target5, startFuel5, stations5);
        System.out.println("Test case 5: " + (result5 == -1 ? "Passed" : "Failed"));

        // Test case 6: Multiple stations, exact fuel needed
        int target6 = 100;
        int startFuel6 = 25;
        int[][] stations6 = { { 25, 25 }, { 50, 25 }, { 75, 25 } };
        int result6 = main.minRefuelStops(target6, startFuel6, stations6);
        System.out.println("Test case 6: " + (result6 == 3 ? "Passed" : "Failed"));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int stops = 0;
        int prev = 0;
        int n = stations.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n + 1; i++) {
            int dist = (i < n ? stations[i][0] : target) - prev;
            startFuel -= dist;

            while (startFuel < 0 && !pq.isEmpty()) {
                startFuel += pq.poll();
                stops++;
            }

            if (startFuel < 0) {
                return -1;
            }

            if (i < n) {
                pq.offer(stations[i][1]);
                prev = stations[i][0];
            }
        }

        return stops;
    }

}
