class Solution {
    public int largestAltitude(int[] gain) {
        
        int maxi=Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<gain.length;i++)
        {
            maxi=Math.max(maxi,sum);
            sum+=gain[i];
        }
        return Math.max(maxi,sum);
    }
}