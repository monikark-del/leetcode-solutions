class Solution {
    public int minSubarray(int[] nums, int p) {

        HashMap<Integer,Integer> m=new HashMap<>();
        m.put(0,-1);

        long total=0;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            total+=nums[i];
        }
       
        int totalrem=(int)(total%p);
        if(totalrem==0)
        {
            return 0;
        }
        long sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            int rem = (int)(sum % p);
            int need = (rem - totalrem + p) % p;
            if(m.containsKey(need))
            {
                mini=Math.min(mini,i-m.get(need));
            }
            m.put((int)rem,i);
        }
        return mini==nums.length||mini==Integer.MAX_VALUE?-1:mini;
    }
}