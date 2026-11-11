class Solution {

    int maxi;
    int start=0;
    void longest(int i,int j,String s)
    {
        while(i>=0 && j<s.length())
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i--;
                j++;
            }
            else
            {
                break;
            }
            int maxlen=j-i-1;
            if(maxlen>maxi)
            {
                start=i+1;
                maxi=maxlen;
            }
        }
    }
    public String longestPalindrome(String s) {
        
        for(int i=0;i<s.length();i++)
        {
            longest(i,i,s);
            longest(i,i+1,s);
        }
        
        return s.substring(start,start+maxi);
    }
}