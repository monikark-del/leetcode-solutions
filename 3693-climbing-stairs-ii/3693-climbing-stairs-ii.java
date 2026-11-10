class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        
        dp[0]=0;
        for(int i=1;i<=n;i++){

        int one=Integer.MAX_VALUE;
        int two=Integer.MAX_VALUE;
        int three=Integer.MAX_VALUE;
           
        if(i-1>=0)
        {
            one=dp[i-1]+costs[i-1]+1*1;
        }
        if(i-2>=0)
        {
            two=dp[i-2]+costs[i-1]+2*2;
        }
        if(i-3>=0)
        {
            three=dp[i-3]+costs[i-1]+3*3;
        }
    
            dp[i]=+Math.min(one,Math.min(two,three));
        }
        return dp[n];
    }
}