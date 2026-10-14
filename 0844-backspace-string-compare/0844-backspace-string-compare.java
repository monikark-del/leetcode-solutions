class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        StringBuilder res=new StringBuilder();
        StringBuilder res2=new StringBuilder();

        int i=0;
        while(i<s.length())
        {   
            
            if(s.charAt(i)!='#')
            {
                res.append(s.charAt(i));
                
            }
            else 
            {
                if(res.length()>0)
                {
                res.deleteCharAt(res.length()-1);
                }
                
            }
            i++;
        }

        i=0;
        while(i<t.length())
        {   
            if(t.charAt(i)!='#')
            {
                res2.append(t.charAt(i));
               
            }
            else 
            {
                if(res2.length()>0)
                {
                res2.deleteCharAt(res2.length()-1);
                }
               
            }
            i++;
        }

        return res.toString().equals(res2.toString());
    }
}