class Solution {
    public boolean validPalindrome(String s) {
        
        int count=1;
        int i=0;
        int j=s.length()-1;

        while(i<=j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else 
            {
                int left=i+1;
                int right=j;

                while(left<right  && s.charAt(left)==s.charAt(right))
                {
                    left++;
                    right--;
                }
                if(left>=right)
                {
                    return true;
                }

                left=i;
                right=j-1;
                while(left<right  && s.charAt(left)==s.charAt(right))
                {
                        left++;
                        right--;
                }
                if(left>=right)
                {
                    return true;
                }
                else
                {
                    return false;
                }

            }
        }
    return true;
    }
}