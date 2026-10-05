class Solution {
    public String reverseStr(String s, int k) {
        
        StringBuilder res=new StringBuilder(s);
        
        for(int i=0;i<s.length();i+=2*k)
        {
            int last_index=Math.min(i+k,s.length());
            
            int start=i;
            int end=last_index-1;
            while(start<end)
            {
                char temp=s.charAt(start);
                res.setCharAt(start,s.charAt(end));
                res.setCharAt(end,temp);
                start++;
                end--;
            }
        }
        return res.toString();
    }
}