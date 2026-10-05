class Solution {
    public boolean isAnagram(String s, String t) {
      
        int[] temp=new int[26];        
        for(int i=0;i<s.length();i++)
        {
            char chars=s.charAt(i);
            temp[chars-'a']++;
        }
        for(int i=0;i<t.length();i++)
        {
            char chars=t.charAt(i);
            temp[chars-'a']--;
        }

        for(int i=0;i<temp.length;i++)
        {
            if(temp[i]!=0)
            {
                return false;
            }
        }
        return true;
    }
}