class Solution {
    /*public int numSubarraysWithSum(int[] nums, int goal) {
        
        int count=0;
        int sum=0;
        int j=0;
        if(goal==0)
        {
            int zeros=0;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]==0)
                {
                    zeros++;
                }
                else
                {
                    zeros=0;
                }
                count+=zeros;
            }
            return count;
        }

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            while(sum>goal)
            {
                sum-=nums[j++];

            }
            if(sum==goal)
            {
               count++;
               int temp=j;
               
               while(temp<nums.length && nums[temp]==0 )
               {
                    count++;
                    temp++;
               }
             
            }
        }
        return count;
    }*/

    public int numSubarraysWithSum(int[] nums, int goal)
    {
        HashMap<Integer,Integer> m=new HashMap<>();
        int sum=0;
        int count=0;

        m.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(m.containsKey(sum-goal))
            {
                count+=m.get(sum-goal);
            }
            
            m.put(sum,m.getOrDefault(sum,0)+1);
            
        }
        return count;

    }
}