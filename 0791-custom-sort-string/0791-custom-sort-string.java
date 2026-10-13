class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character,Integer> m1=new HashMap<>();
        HashMap<Character,Integer> m2=new HashMap<>();
        
        for(int i=0;i<order.length();i++)
        {
            m1.put(order.charAt(i),i);
        }
        
        for(int i=0;i<s.length();i++)
        {
            m2.put(s.charAt(i),m2.getOrDefault(s.charAt(i),0)+1);
        }
        
        StringBuilder p=new StringBuilder();
        for(int i=0;i<order.length();i++)
        {
            if(m2.containsKey(order.charAt(i)))
            {
                while(m2.get(order.charAt(i))!=0)
                {
                    p.append(order.charAt(i));
                    m2.put(order.charAt(i),m2.get(order.charAt(i))-1);
                }
            }
        }

        for(char i:s.toCharArray())
        {
            if(!m1.containsKey(i))
            {
                p.append(i);
            }
        }
        return p.toString();
    }
}