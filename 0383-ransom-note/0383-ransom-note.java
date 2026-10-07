class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character,Integer> m=new HashMap<>();
        for(char i:magazine.toCharArray())
        {
            m.put(i,m.getOrDefault(i,0)+1);
        }

        for(char j:ransomNote.toCharArray())
        {
            if(m.containsKey(j))
            { 
                if(m.get(j)>0)
                {
                   m.put(j,m.get(j)-1);
                }
                else
                {
                    return false;
                }
                
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}