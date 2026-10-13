class Solution {
    public boolean isHappy(int n) {
        
        if(n==1)
        {
            return true;
        }

        int sum=n;
        while(sum!=1 && sum!=4)
        {
            int digit=0;
            while(sum>0)
            {
                digit+=(sum%10)*(sum%10);
                sum/=10;
            }
            sum=digit;
        }
        if(sum==1)
        {
            return true;
        }
        return false;
    }
}