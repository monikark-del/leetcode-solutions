class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        HashMap<Character,Integer> m=new HashMap<>();

        for(int i=0;i<s1.length();i++)
        {
            m.put(s1.charAt(i),i);
        }

        int count=0;
        int first=-1;
        int second=-1;

        for(int i=0;i<s2.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                count++;
                if(count==1)
                {
                    first=i;
                }
                else if(count==2)
                {
                    second=i;
                }
                else
                {
                    return false;
                }
            }
        }

        if(count==0)
        {
            return true;
        }
        if(count!=2)
        {
            return false;
        }

        if(s1.charAt(first)==s2.charAt(second) && s2.charAt(first)==s1.charAt(second))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}