class Solution {
    public String reverseWords(String s) {
        
        StringBuilder res=new StringBuilder();

        int j=0;
        while(j<s.length())
        {
            String temp="";
            while(j<s.length() && s.charAt(j)!=' ')
            {
                temp+=s.charAt(j);
                j++;
            }
            if(temp.length()>0)
            {
            if(res.length()==0)
            {
                res.insert(0,temp);
            }
            else 
            {
                res.insert(0,temp+" ");
            }
            }
            j++;
            

        }
        return res.toString();
    }
}