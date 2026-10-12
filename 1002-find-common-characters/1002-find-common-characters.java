class Solution {
    public List<String> commonChars(String[] words) {
       
       HashMap<Character,Integer> m=new HashMap<>();

       for(char i: words[0].toCharArray())
       {
            m.put(i,m.getOrDefault(i,0)+1);
       }

       for(int j=1;j<words.length;j++)
       {
           HashMap<Character,Integer> p=new HashMap<>();

           for(char i:words[j].toCharArray())
           {
                p.put(i,p.getOrDefault(i,0)+1);
           }

           for(char k:m.keySet())
           {
                if(p.containsKey(k))
                {
                    m.put(k,Math.min(m.get(k),p.get(k)));
                }
                else
                {
                    m.put(k,0);
                }
           }
       }
       List<String> l=new ArrayList<>();
       for(char s:m.keySet())
       {
            while(m.get(s)>0)
            {
               
               l.add(String.valueOf(s));
               m.put(s,m.get(s)-1);
            }
       }
       return l;
    }
}