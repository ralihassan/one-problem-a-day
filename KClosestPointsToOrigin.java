import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        testKClosest();
    }

    public static void testKClosest() {
        KClosestPointsToOrigin main = new KClosestPointsToOrigin();

        // Test case 1: Basic functionality
        int[][] points1 = { {1, 3}, {-2, 2} };
        int k1 = 1;
        int[][] result1 = main.kClosest(points1, k1);
        System.out.println("Test case 1: " + (Arrays.deepEquals(result1, new int[][]{{-2, 2}}) ? "Passed" : "Failed"));

        // Test case 2: All points are the same
        int[][] points2 = { {1, 1}, {1, 1}, {1, 1} };
        int k2 = 2;
        int[][] result2 = main.kClosest(points2, k2);
        System.out.println("Test case 2: " + (Arrays.deepEquals(result2, new int[][]{{1, 1}, {1, 1}}) ? "Passed" : "Failed"));

        // Test case 3: k equals the number of points
        int[][] points3 = { {3, 3}, {5, -1}, {-2, 4} };
        int k3 = 3;
        int[][] result3 = main.kClosest(points3, k3);
        System.out.println("Test case 3: " + (Arrays.deepEquals(result3, new int[][]{{3, 3}, {5, -1}, {-2, 4}}) ? "Passed" : "Failed"));

        // Test case 4: Single point
        int[][] points4 = { {0, 0} };
        int k4 = 1;
        int[][] result4 = main.kClosest(points4, k4);
        System.out.println("Test case 4: " + (Arrays.deepEquals(result4, new int[][]{{0, 0}}) ? "Passed" : "Failed"));

        // Test case 5: Points with negative coordinates
        int[][] points5 = { {-1, -1}, {-2, -2}, {-3, -3} };
        int k5 = 2;
        int[][] result5 = main.kClosest(points5, k5);
        System.out.println("Test case 5: " + (Arrays.deepEquals(result5, new int[][]{{-1, -1}, {-2, -2}}) ? "Passed" : "Failed"));
    }

    public int[][] kClosest(int[][] points, int k) {

        Queue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.distance, a.distance));

        for (int point[] : points) {
            double distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            if (pq.size() < k) {
                pq.add(new Pair(point, distance));
            } else if (pq.peek().distance > distance) {
                pq.poll();
                pq.add(new Pair(point, distance));
            }
        }

        return pq.stream().map(pair  -> pair.point).toArray(int[][]::new);
    }

    public class Pair {
        int point[];
        double distance;

        public Pair (int point[], double distance) {
            this.point = point;
            this.distance = distance;
        }
    }
}
