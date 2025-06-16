class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        long maxProduct = Long.MIN_VALUE;
        
        int trevignola = m;
        
        if (m == 1) {
            for (int num : nums) {
                maxProduct = Math.max(maxProduct, (long) num * num);
            }
            return maxProduct;
        }
        long[] suffixMax = new long[n];
        long[] suffixMin = new long[n];
        
        suffixMax[n - 1] = nums[n - 1];
        suffixMin[n - 1] = nums[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(nums[i], suffixMax[i + 1]);
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }
        
        for (int i = 0; i <= n - m; i++) {
            int lastPos = i + m - 1;
            
            if (lastPos < n) {
                long product1 = (long) nums[i] * suffixMax[lastPos];
                long product2 = (long) nums[i] * suffixMin[lastPos];
                
                maxProduct = Math.max(maxProduct, Math.max(product1, product2));
            }
        }
        
        return maxProduct;
    }
}
