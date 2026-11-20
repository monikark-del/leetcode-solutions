class Solution {
    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for(int num : nums) {

            int prev = dp.getOrDefault(num, 0);

            int a = dp.getOrDefault(num - 1, 0) + 1;
            int b = prev + 1;

            dp.put(num, a);
            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), b));

            ans = Math.max(ans, Math.max(a, b));
        }

        return ans;
    }
}