class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        HashMap<String ,Integer> m=new HashMap<>();
        int i=0;
        int j=0;
        while(i<s1.length())
        {
            String s="";
           
            while(i<s1.length() && s1.charAt(i)!=' ')
            {
                s+=s1.charAt(i);
                i++;
            }
            if(!s.equals(" "))
            {
                m.put(s,m.getOrDefault(s,0)+1);
            }
            i++;
            
        }
        while(j<s2.length())
        {
            String y="";
            while(j<s2.length() && s2.charAt(j)!=' ')
            {
                y+=s2.charAt(j);
                j++;
            }
            if(!y.equals(" "))
            {
                m.put(y,m.getOrDefault(y,0)+1);
            }
            j++;
        }
        ArrayList<String> k=new ArrayList<>();
        for(String p:m.keySet())
        {
            if(m.get(p)==1)
            {
                k.add(p);
            }
        }
        String[] n=new String[k.size()];
        int q=0;
        for(String z:k)
        {
            n[q++]=z;
        }
        return n;
    }
}