class Solution {
    public int maxScore(String s) {
        
        int ones=0;
        int zeros=0;
        int maxi=0;
        char[] arr=s.toCharArray();

        for(int i=0;i<arr.length;i++)
        {
            ones+=arr[i]-'0';
        }

        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]=='0')
            {
                zeros++;
                maxi=Math.max(maxi,zeros+ones);
            }
            else
            {
                ones--;
                maxi=Math.max(maxi,zeros+ones);
            }
        }
        return maxi;
    }
}