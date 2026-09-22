class Solution {
    public int minStartValue(int[] nums) {
        
        int mini=Integer.MAX_VALUE;
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            mini=Math.min(mini,sum);
        }

       return mini<0?1-mini:1;
    }
}