class Solution {
    public int numOfSubarrays(int[] arr) {
        
        HashMap<Integer,Integer> m=new HashMap<>();
        long count=0;
        int sum=0;

        m.put(0,1);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum%2==1)
            {
                count+=(long)m.getOrDefault(0,0);
            }
            else
            {
                count+=(long)m.getOrDefault(1,0);
            }

            m.put(sum%2,m.getOrDefault(sum%2,0)+1);
        }
        return (int)(count%1000000007);
    }
}