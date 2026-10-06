class Solution {
    public String longestCommonPrefix(String[] strs) {
        
       
        String res=strs[0];

        for(int j=1;j<strs.length;j++)
        {
            int i=0;
            String ans="";
            while(i<Math.min(strs[j].length(),res.length()))
            {
                if(res.charAt(i)==strs[j].charAt(i))
                {
                    ans+=res.charAt(i);
                    i++;
                }
                else
                {
                    break;
                }
            }
            res=ans;

        }
        return res;
    }
}