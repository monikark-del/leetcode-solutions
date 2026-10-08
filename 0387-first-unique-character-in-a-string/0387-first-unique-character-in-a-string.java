class Solution {
    /*public int firstUniqChar(String s) {
        
        int[] v=new int[123];

        for(int x=0;x<s.length();x++)
        {
            v[s.charAt(x)-'a']++;
        }

        for(int i=0;i<s.length();i++)
        {
            if(v[s.charAt(i)-'a'] ==1)
            {
                return i;
            }
        }
        
        return -1;
    }*/
    public int firstUniqChar(String s)
    {
        HashMap<Character,Integer> m=new HashMap<>();
        for(char i:s.toCharArray())
        {
            m.put(i,m.getOrDefault(i,0)+1);
        }
    
        for(int i=0;i<s.length();i++)
        {
            if(m.get(s.charAt(i))==1)
            {
                return i;
            }
        }
        return -1;
    }
}