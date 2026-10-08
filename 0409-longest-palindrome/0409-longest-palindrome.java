class Solution {
    public int longestPalindrome(String s) {
      
        HashMap<Character,Integer> m=new HashMap<>();
        for(char i:s.toCharArray())
        {
            m.put(i,m.getOrDefault(i,0)+1);
        }
        
        boolean flag=false;
        int count=0;
        for(int j:m.values())
        {
            if(j%2==0)
            {
                count+=j;
            }
            else
            {
                count+=j-1;
                flag=true;
            }
        }
    if(flag)
    {
        count++;
    }
    return count;
    }
}