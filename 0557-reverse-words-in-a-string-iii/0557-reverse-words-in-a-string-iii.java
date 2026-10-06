class Solution {
    public String reverseWords(String s) {
        
        StringBuilder res=new StringBuilder(s);
        int i=0;
        int j=0;
        int m=0;
        while(j<res.length())
        {
            while(j<res.length() && res.charAt(j)!=' ')
            {
                j++;
            }
            int end=j-1;
            while(i<end)
            {
                char temp=res.charAt(i);
                res.setCharAt(i,res.charAt(end));
                res.setCharAt(end,temp);
                i++;
                end--;
            }
    
            i=j+1;
            j=i;
        }
       

        return res.toString();
    }
}