class Solution {
    public int myAtoi(String s) {
        
        int i=0;
        int ans=0;
        boolean flag=false;
       
        while(i<s.length() && s.charAt(i)==' ')
        {
                i++;
            }
            if(i<s.length() && s.charAt(i)=='-')
            {
                flag=true;
                i++;
            }
             else if(i < s.length() && s.charAt(i) == '+')
        {
            i++;
        }
            while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
            {
            
            int digit = s.charAt(i) - '0';

            if(ans > (Integer.MAX_VALUE - digit) / 10)
            {
                if(flag)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
            }
        if(flag)
        {
            ans=-ans;
        }
        return ans;
    }
}