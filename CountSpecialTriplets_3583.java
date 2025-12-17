
import java.util.*;

class CountSpecialTriplets_3583 {

    public int specialTriplets(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> numPartialCnt = new HashMap<>();

        for (int v : nums) {
            numCnt.put(v, numCnt.getOrDefault(v, 0) + 1);
        }

        long ans = 0;
        for (int v : nums) {
            int target = v * 2;
            int lCnt = numPartialCnt.getOrDefault(target, 0);
            numPartialCnt.put(v, numPartialCnt.getOrDefault(v, 0) + 1);
            int rCnt =
                numCnt.getOrDefault(target, 0) -
                numPartialCnt.getOrDefault(target, 0);
            ans = (ans + (long) lCnt * rCnt) % MOD;
        }

        return (int) ans;
    }
}

class Solution2 {

    private static final int MOD = 1000000007;

    public int specialTriplets(int[] nums) {
        Map<Integer, List<Integer>> pos = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            pos.computeIfAbsent(v, k -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int target = nums[i] * 2;
            List<Integer> targetPos = pos.get(target);
            if (
                targetPos != null &&
                targetPos.size() > 1 &&
                targetPos.get(0) < i
            ) {
                int[] lr = upperBound(targetPos, i);
                int l = lr[0];
                int r = lr[1];
                if (nums[i] == 0) {
                    l--;
                }
                ans = (int) ((ans + (long) l * r) % MOD);
            }
        }
        return ans;
    }

    private int[] upperBound(List<Integer> arr, int i) {
        int l = 0;
        int r = arr.size() - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (i >= arr.get(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return new int[] { l + 1, arr.size() - 1 - l };
    }
}