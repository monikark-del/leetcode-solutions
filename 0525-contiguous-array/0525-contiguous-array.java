class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer,Integer> m=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                nums[i]=-1;
            }
        }
        int maxi=0;
        int sum=0;
        m.put(0,-1);

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(m.containsKey(sum))
            {
                maxi=Math.max(maxi,i-m.get(sum));
            }
            else
            {
                m.put(sum,i);
            }
        }
        return maxi;
    }
}