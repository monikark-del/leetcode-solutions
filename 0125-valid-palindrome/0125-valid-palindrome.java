class Solution {
    public boolean isPalindrome(String s) {
     
        s=s.toLowerCase();
        String ch="";
        
        for(int i=0;i<s.length();i++)
        {

            char chars=s.charAt(i);
            if(Character.isLetterOrDigit(chars))
            {
                ch+=chars;
            }
        }
        int i=0;
        int j=ch.length()-1;
        while(i<j)
        {
            if(ch.charAt(i)!=ch.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}