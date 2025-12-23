
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class TwoBestNonOverlappingEvents {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[events.length][3];
        for (int[] d : dp) Arrays.fill(d, -1);
        return findEvents(events, 0, 0, dp);
    }

    // Recursive function to find the greatest sum for the pairs.
    int findEvents(int[][] events, int idx, int cnt, int[][] dp) {
        if (cnt == 2 || idx >= events.length) return 0;
        if (dp[idx][cnt] == -1) {
            int end = events[idx][1];
            int lo = idx + 1, hi = events.length - 1;
            while (lo < hi) {
                int mid = lo + ((hi - lo) >> 1);
                if (events[mid][0] > end) hi = mid;
                else lo = mid + 1;
            }
            int include =
                events[idx][2] +
                (lo < events.length && events[lo][0] > end
                        ? findEvents(events, lo, cnt + 1, dp)
                        : 0);
            int exclude = findEvents(events, idx + 1, cnt, dp);
            dp[idx][cnt] = Math.max(include, exclude);
        }
        return dp[idx][cnt];
    }

    public int maxTwoEventsPQ(int[][] events) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Arrays.sort(events, (a,b) -> a[0] - b[0]);

        int max = 0, maxSoFar = 0;

        for (int event[]: events) {
            
            while (!pq.isEmpty() && pq.peek()[1] < event[0]) {
                maxSoFar = Math.max(maxSoFar, pq.poll()[2]);
            }
            
            max = Math.max(max, maxSoFar+event[2]);
            pq.add(event);
        }

        return max;
    }
    
}