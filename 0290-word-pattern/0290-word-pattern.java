class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        HashMap<Character,String> m=new HashMap<>();
        HashMap<String,Character> p=new HashMap<>();
    
        int j=0;
        int i=0;
        while(i<s.length())
        {
            String temp="";
            while(i<s.length() && s.charAt(i)!=' ')
            {
                temp+=s.charAt(i);
                i++;
            }
            if(j<pattern.length() && m.containsKey(pattern.charAt(j)) && !m.get(pattern.charAt(j)).equals(temp))
            {
                return false;
            }
            if(j<pattern.length() && p.containsKey(temp) && p.get(temp)!=pattern.charAt(j))
            {
                return false;
            }
            if(j>=pattern.length())
            {
                return false;
            }
            m.put(pattern.charAt(j),temp);
            p.put(temp,pattern.charAt(j));
            j++;
            while(i<s.length() && s.charAt(i)==' ')
            {
                i++;
            }

        }
        return j==pattern.length();
    }
}