class Solution {
    public int minSteps(String s, String t) {
        
        HashMap<Character,Integer> m1=new HashMap<>();
        HashMap<Character,Integer> m2=new HashMap<>();

        for(char i:s.toCharArray())
        {
            m1.put(i,m1.getOrDefault(i,0)+1);
        }

        for(char i:t.toCharArray())
        {
            m2.put(i,m2.getOrDefault(i,0)+1);
        }
        
        int count=0;

        for(char i:m2.keySet())
        {
            if(!m1.containsKey(i))
            {
                count+=m2.get(i);
            }
            else
            {   
               if((m2.get(i)-m1.get(i))>0)
               {
                   count+=m2.get(i)-m1.get(i);
               }
            }
        }
        return count;
    }
}