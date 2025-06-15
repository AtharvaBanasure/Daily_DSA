import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        final int MOD = 1_000_000_007;
        long ans = 0;

        Map<Integer, Integer> leftFreq = new HashMap<>();
        Map<Integer, Integer> rightFreq = new HashMap<>();

        for (int i = 2; i < n; i++) {
            rightFreq.put(nums[i], rightFreq.getOrDefault(nums[i], 0) + 1);
        }

        leftFreq.put(nums[0], 1);

        for (int j = 1; j < n - 1; j++) {
            int mid = nums[j];
            int target = mid * 2;

            long cntLeft = leftFreq.getOrDefault(target, 0);
            long cntRight = rightFreq.getOrDefault(target, 0);

            ans = (ans + (cntLeft * cntRight) % MOD) % MOD;

            leftFreq.put(mid, leftFreq.getOrDefault(mid, 0) + 1);
            rightFreq.put(nums[j + 1], rightFreq.get(nums[j + 1]) - 1);
            if (rightFreq.get(nums[j + 1]) == 0) {
                rightFreq.remove(nums[j + 1]);
            }
        }

        return (int) ans;
    }
}

