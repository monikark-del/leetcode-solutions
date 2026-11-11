class Solution {

    int count=0;
    void palindrome(int i,int j,String s)
    {
        while(i>=0 && j<s.length())
        {
            if(s.charAt(i)==s.charAt(j))
            {
                count++;
                i--;
                j++;
            }
            else
            {
                break;
            }
        }
    }
    public int countSubstrings(String s) {
        
        for(int i=0;i<s.length();i++)
        {
            palindrome(i,i,s);
            palindrome(i,i+1,s);
        }

        return count;
    }
}