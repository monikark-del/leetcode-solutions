class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer,Integer> m=new HashMap<>();

        int count=0;
        int sum=0;
        m.put(0,1);

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            
            int rem=((sum%k)+k)%k;
            if(m.containsKey(rem))
            {
                count+=m.get(rem);
            } 
            m.put(rem,m.getOrDefault(rem,0)+1);
            
        }
        return count;
    }
}